<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="/resources/jquery/dist/jquery.min.js"></script>
</head>
<script>
function getMessage(no) {
	$.ajax({
		method   : "GET",
		url      : "/study/getMessage" + no,
		dataType : "JSON",
		data     : null,
		error    : function() {alert:('error');},
		success  : result
	});
}

function result(data) {
	console.log(data);
	alert(data.name);
}
</script>
<body>
<h1>
	Hello world! JSP
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>${samki}</p>
<h2>${combo}</h2>
1.클래스를 이용한 JSON 반환<input type="button" value="getMessage1" 
										onClick="javascript:getMessage(1)"/><br/>
2.Map을 이용한 JSON 반환<input type="button" value="getMessage2" 
										onClick="javascript:getMessage(2)"/><br/>
<select id="type" style="width:140px"></select>
</body>
</html>
