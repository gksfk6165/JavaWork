<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
int cnt = (Integer)request.getAttribute("updateOk");
int uid = (Integer)request.getAttribute("uid");
%>


    

<% if(cnt == 0){ %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('수정 성공');
		location.href = "view.do?uid=<%= uid%>";
	</script>
<% } %>
















