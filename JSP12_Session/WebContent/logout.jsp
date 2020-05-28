<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String sessionName="num1";
    session.removeAttribute("num1");
    
    
    
    
    %>
    <script>
    alert("로그아웃 되었습니다.")
    location.href = "login.jsp";
    </script>
    
    