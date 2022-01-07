<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
	<script src="/node_modules/jquery/dist/jquery.min.js"></script>
	<script src="/resources/js/common.js"></script>
</head>
<script>

	util.initSelectBox('upper','master','','Y');
	util.initSelectBox('members', '', '', 'Y', 'study/getMembers');
	
	$("#upper").change(function () {
		util.initSelectBox("lower", $(this).val(), '', 'Y');
	});
</script>
<body>
	상위 코드 : <select id="upper" style="width:140px"></select><br>
	하위 코드 : <select id="lower" style="width:140px"></select><br>
	<hr>
	회원 목록 : <select id="members" style="width:140px"></select><br>
</body>
</html>