<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>request parameter</title>
</head>
<body>
<%
   String data1,data2;
   String name,id,pw,gender,local,meme;
   String [] hobbys;
   
%>
<%
   request.setCharacterEncoding("utf-8");

   data1=request.getParameter("data1").trim();
   data2=request.getParameter("data2").trim();
   name =request.getParameter("name").trim();
   
   id= request.getParameter("id").trim();
   pw= request.getParameter("pw").trim();
   gender = request.getParameter("gender").trim();
   local = request.getParameter("local").trim();
   hobbys = request.getParameterValues("hobby");
   meme= request.getParameter("memo").trim();
   
%>

hidden : <%= data1 %>, <%= data2 %><br>
이름 : <%= name %><br>
아이디 : <%=  id %><br>
패스워드 : <%= pw %> <br>
취미 : <%= Arrays.toString(hobbys) %><br>
성별 : <%= gender %><br>
도시 :  <%= local %><br>
메모 : <%= meme %><br>




</body>
</html>