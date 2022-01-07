<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
	<script src="/node_modules/jquery/dist/jquery.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<script>
function getMessage(no) {
	util.requestSync("/study/getMessage" + no, null, "GET", result)
}

function result(data) {
	console.log(data);
	alert(data.name);
}
util.initSelectBox('type', 'master', '', 'Y');
</script>
<body>
<div style="border:1px solid; width:100%; height:50px; text-align:right;">${ServerInfo}</div>
<h1>
	Hello world! JSP
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>${samki}</p>
<h2>${combo}</h2>
1.클래스를 이용한 JSON 반환<input type="button" value="getMessage1" 
										onClick="getMessage(1)"/><br/>
2.Map을 이용한 JSON 반환<input type="button" value="getMessage2" 
										onClick="getMessage(2)"/><br/>
<select id="type" style="width:140px"></select><br>
<%=System.getProperty("spring.profiles.active") %>
</body>
</html>
