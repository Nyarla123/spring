<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
	<script src="/node_modules/jquery/dist/jquery.min.js"></script>
	<script src="https://nhn.github.io/tui.grid/latest/dist/tui-grid.js"></script>
	<link href="/resources/css/tui-grid.css" rel="stylesheet">
	<script>
		const grid = new tui.Grid({
		el: document.getElementById('grid'),
		data: gridData,
		scrollX: false,
		scrollY: false,
		columns: [
			{
			header: 'Name',
			name: 'name'
			},
			{
			header: 'Artist',
			name: 'artist'
			},
			{
			header: 'Type',
			name: 'type'
			},
			{
			header: 'Release',
			name: 'release'
			},
			{
			header: 'Genre',
			name: 'genre'
			}
		]
		});
		window.onload = function() {
			$.ajax({
				url : "ajax/toastList", // toastDataList
				methods : "POST",
				success : function(result) {
					console.log(result);
					grid.resetData(eval(result));
				}
			})
		}
	</script>
</head>
<script>

</script>
<body>
   <div id="grid">
   </div>
</body>
</html>
