<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
    <link rel="stylesheet" href="/node_modules/tui-grid/dist/tui-grid.min.css">
    <script src="/node_modules/jquery/dist/jquery.min.js"></script>
    <script src="/node_modules/tui-grid/dist/tui-grid.min.js"></script>
    <script>	
        const grid = new tui.Grid({
        el: document.getElementById('grid'),
        /* data: [],*/
        scrollX: false,
        scrollY: false,
        rowHeaders: ['checkbox'],
        columns: [       
        	{
       		header: '그룹키',
            name: 'GROUP_KEY',
        	},
        	{
       		header: '파일키',
            name: 'FILE_KEY',	
        	},
            {
            header: '파일명',
            name: 'FILE_REALNAME',
            width : 500,               
            },           
            {
           	header: '등록자',
            name: 'REG_ID'                   
            },
            {
           	header: '등록일',
            name: 'REG_DATE',         
            },
            {
            header : "경로",
            name : "FILE_PATH"
            }
        ]
        });
        tui.Grid.applyTheme("normal", {
        	cell : {
        		normal : {
        			background : "white"     				
        		},
        		header : {
                    background : "#eaeaea",               
                }             
        	}
        });
        grid.hideColumn('GROUP_KEY');
        grid.hideColumn('FILE_KEY');
        grid.hideColumn('FILE_PATH');
             
        function btnSearch() {
        	util.requestSync("/board/getBasicDummy", null, "GET", result);
		}
        
        function result(res) {
			grid.resetData(res);
		}
        function btnSave() {
			alert("성공");
		}
      
        grid.on('click', (e) => {
        	console.log(e);
        	console.log(e.columnName + ' clicked!!');       	
        	var index = grid.getValue(grid.getFocusedCell().rowKey, '_checked' );
        	console.log(index);
        	});
       	grid.on('dblclick', (e) => {
       		console.log(e.columnName + ' double clicked!!');    		
       		if(e.columnName === 'FILE_REALNAME') {
       			var GROUP_KEY = grid.getValue(grid.getFocusedCell().rowKey, 'GROUP_KEY' );
       			var FILE_KEY = grid.getValue(grid.getFocusedCell().rowKey, 'FILE_KEY' );
       			console.log(GROUP_KEY);
       			console.log(FILE_KEY);
        	  	location.href = "/board/getFileDownload?GROUP_KEY=" + GROUP_KEY + "&FILE_KEY=" + FILE_KEY;               	  	     	  	
       		}      	    	
        });
    </script>
</head>
<body>
	<button onClick="btnSearch()">Search</button>
	<button onClick="btnSave()">모두 저장</button>
	<div id="grid"></div>
</body>
</html>