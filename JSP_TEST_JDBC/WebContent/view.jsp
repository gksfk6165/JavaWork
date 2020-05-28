<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> <%-- JDBC 관련 import --%>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
  request.setCharacterEncoding("utf-8");

  int uid = Integer.parseInt(request.getParameter("uid"));


%>
<%
    String name = "";
    String subject = "";
    String content = "";
    String regdate = "";
    int viewcnt = 0;
%>

<%!
    //JDBC 관련 기본 객체 변수
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;   //SELECT 결과 
    int cnt = 0;  //DML 결과, executeUpdate()
    
    //Connection 에 필요한 값 세팅
    final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    final String USERID = "scott0316";
    final String USERPW="tiger0316";
%>    

<%!
   //쿼리문 준비
   final String SQL_WRITE_SELECT_BY_UID =
		   "SELECT * FROM test_write WHERE wr_uid = ?";
%>

<%

   try{
       Class.forName(DRIVER);
       out.println("드라이버 로딩 성공" + "<br>");
       conn = DriverManager.getConnection(URL,USERID,USERPW);
       out.println("conn 성공"+"<br>");
       
       //트랜잭션 실행
       pstmt= conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
       pstmt.setInt(1,uid);
       
       rs=pstmt.executeQuery();
       
       if(rs.next()){
           subject = rs.getString("wr_subject");
           content = rs.getString("wr_content");
           if(content == null) content = "";   // null 처리 
           name = rs.getString("wr_name");
           viewcnt = rs.getInt("wr_viewcnt");
           Date d = rs.getDate("wr_regdate");
           Time t = rs.getTime("wr_regdate");
           regdate = "";
           if(d != null){
               regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " 
                       + new SimpleDateFormat("hh:mm:ss").format(t);
           }
       } else {
           // wr_uid 값의 레코드가 없는 뜻
%>
           <script>
               alert("해당 정보가 삭제되거나 없습니다");
               history.back();
           </script>
<%          
           return;   // 더이상 JSP 프로세싱 하지 않고 종료
       } // end if
       
       // 모든 쿼리 성공하면 commit
       conn.commit();
   } catch(Exception e){
       e.printStackTrace();
       // 예외 처리
       conn.rollback();
   } finally {
       // 리소스 해제
       try {
           if(rs != null) rs.close();
           if(stmt != null) stmt.close();
           if(pstmt != null) pstmt.close();
           if(conn != null) conn.close();
       } catch(Exception e){
           e.printStackTrace();
       }
   }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>읽기</title>
</head>
<body>
<h1>항목 보기</h1>
id : <%= uid %><br>
작성자 : <%= name %><br>
제목 : <%=subject %><br>
등록일 : <%= regdate %><br>
조회수 : <%= viewcnt %><br>
내용 : <br>
<%= content %><br>
<hr>

</body>
</html>