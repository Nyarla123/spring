<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/common.js"></script>
</head>
<body>
	<form id="form" name="form" method="POST" enctype="multipart/form-data" action="/board/upload">
       <table id="fileTable" border=1 class="reg" style="width:95%;margin: 10 6 10 6;">
       		<tr>
       			<td>
       				<input type="file" name="files" accept="">
       			</td>
       		</tr>
       </table>
       <br/>
       <button type="submit">등록</button>
    </form>
</body>
</html>