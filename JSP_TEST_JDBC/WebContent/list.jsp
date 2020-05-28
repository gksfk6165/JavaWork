<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%!

  Connection conn = null;
  Statement stmt = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  int cnt = 0;
  
  
  final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
  final String USERID = "scott0316";
  final String USERPW = "tiger0316";

%>

<%!
  //쿼리문 준비
  final String SQL_WRTIE_SELECT = 
		  "SELECT * FROM test_write ORDER BY wr_uid ASC";

%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>글 목록</title>
<style>
table{width:100%;}
table,th,td{
border:1px solid black;
border-collapse:collapse;
}

</style>
</head>
<body>
<%
   try{
	   Class.forName(DRIVER);
	   out.println("드라이버 로딩 성공 " +"<br>");
	   conn = DriverManager.getConnection(URL,USERID,USERPW);
	   out.println("conn 성공"+"<br>");
	   
	   pstmt = conn.prepareStatement(SQL_WRTIE_SELECT);
	   
	   rs = pstmt.executeQuery();
	   out.println("쿼리성공<br>");
   
%>
<br><br>
<hr>
<h1>리스트</h1>
<table>
  <tr>
    <th>UID</th>
    <th>제목</th>
    <th>작성자</th>
    <th>조회수</th>
    <th>등록일</th>
  </tr>
<% 

while(rs.next()){
	out.println("<tr>");
	int uid = rs.getInt("wr_uid");
    String subject = rs.getString("wr_subject");
    String name = rs.getString("wr_name");
    int viewcnt = rs.getInt("wr_viewcnt");
    Date d = rs.getDate("wr_regdate");
    Time t = rs.getTime("wr_regdate");
    String regdate="";
    if(d != null){
        regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) +" "
                +new SimpleDateFormat("hh:mm:ss").format(t);
    }
	out.println("<td>"+ uid +"</td>");
	out.println("<td><a href='view.jsp?uid="+ uid+"'>"+subject+"</a></td>");
	out.println("<td>"+name+"</td>");
	out.println("<td>"+viewcnt+"</td>");
	out.println("<td>"+regdate+"</td>");
	out.println("</tr>");
}



%>

</table>
<br>
<button onclick="location.href='write.jsp'">신규등록 </button>

<%   
   }catch(Exception e){
	   e.printStackTrace();
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

</body>
</html>