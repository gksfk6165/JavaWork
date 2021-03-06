<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %> <%-- JDBC 관련 import --%>
<%
  request.setCharacterEncoding("utf-8");
  String name = request.getParameter("name");
  String subject = request.getParameter("subject");
  String content = request.getParameter("content");


  
  //유효성 검사
  
  if(name == "" || subject =="" || content ==""){


%>
        <script>
           alert("작성해 주세요!");
           history.back();
        
        </script>
<%
   return;
  };


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
        final String SQL_WRITE_INSERT=
        "INSERT INTO test_write "+"(wr_uid, wr_subject, wr_content, wr_name)"
        +"VALUES(test_write_seq.nextval,?,?,?)";
%>

<%
   try{
       Class.forName(DRIVER);
       out.println("드라이버 로딩 성공" + "<br>");
       conn = DriverManager.getConnection(URL,USERID,USERPW);
       out.println("conn 성공"+"<br>");
       
       //트랜잭션 실행
       pstmt = conn.prepareStatement(SQL_WRITE_INSERT);
       pstmt.setString(1, subject);
       pstmt.setString(2, content);
       pstmt.setString(3, name);
       
       
       
       cnt =pstmt.executeUpdate();
       
       
   }catch(Exception e){
       e.printStackTrace();
       //예외처리
   }finally{
       //리소스해제
       try{
           if(rs != null) rs.close();
           if(stmt != null) stmt.close();
           if(pstmt != null)pstmt.close();
           if(conn !=null) conn.close();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<% if(cnt ==0){ %>
    <script>
      alert("작성 실패 !!");
      history.back();
    </script>
<% 
}else{
%>
    <script>
      alert("작성 성공 !!");
      location.href='list.jsp';
    </script>
<%
}

%>



