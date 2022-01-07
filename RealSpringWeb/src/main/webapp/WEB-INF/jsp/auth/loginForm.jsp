<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.invalidate();
	System.out.println("SESSION ID [" + (session == null ? null : session.getId()) + "]");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="nosession/login" method="post">
        <span>이름 :</span><input type="text" name="name" placeholder="아이디를 입력하세요"><br>
        <span>암호 :</span><input type="password" name="password" placeholder="암호를 입력하세요">
        <input type="submit" value="로그인">
        <c:if test="${error == 'true'}">
        	<font color="red"><b>이름이나 암호가 일치하지 않습니다.</b></font>
        </c:if>
    </form>
</body>
</html>