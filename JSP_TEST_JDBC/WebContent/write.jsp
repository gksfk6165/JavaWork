<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>글 작성</title>
</head>
<script>
function chkSubmit(){
	frm = document.forms["frm"];
	var name = frm["name"].value.trim();
	var subject = frm["subject"].value.trim();
	if(name ==""){
		alert("작성자 란은 반드시 입력해야 합니다.");
		frm["name"].focus();
		return false;
	}
	
	if(subject ==""){
		alert("제목 란은 반드시 입력해야 합니다.");
		frm["subject"].focus();
		return false;
	}
	return true;
	
	
	
}


</script>
<body>
<form name="frm" method="post" onsubmit="return chkSubmit()" action = "writeOk.jsp">
작성자 : <input type="text" name ="name"><br>
제목 : <input type ="text" name ="subject"><br>
메모 :<br>
<textarea name="content"></textarea><br>
<br>
<input type="submit" value = "등록"> 
</form>
<br>
<button type ="button"onclick="location.href='list.jsp'">목록으로</button>
</body>
</html>