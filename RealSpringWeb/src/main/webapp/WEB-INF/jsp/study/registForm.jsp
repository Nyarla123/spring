<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/common.js"></script>
	<script>
		function doReg() {
			$("#form").submit();
		}
	</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div style="border:1px solid;width:100%;height:50px;text-align:right;">${ServerInfo}</div>
        <form id="form" name="form" method="post" action="/nosession/doReg">
        
        <label>Name
        </label>
        <input type="text" name="name" id="name" /><br/>
        
        <label>Email
        </label>
        <input type="text" name="email" id="email" /><br/>
        
        <label>Password
        </label>
        <input type="password" name="password" id="password" /><br/>
        
        <label>성별</label>
        <span><input type="radio" name="gender" id="man" value="M" /><label for="man" >남</label></span>
        <span><input type="radio" name="gender" id="woman" value="W"/><label for="woman">여</label></span><br/>
        
        <label>취미</label>
        <input type="checkbox" id="hobby1" name="hobby1" value="1"><label for="hobby1">독서</label>
        <input type="checkbox" id="hobby2" name="hobby2" value="1"><label for="hobby2">운동</label><br/>
        <input type="button" value="등록" onClick="doReg();">
        
        </form>
</body>
</html>