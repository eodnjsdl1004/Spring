<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>model 전달자</h2>
	
	<a href="res_ex02">res_02으로 이동</a>
	<a href="res_ex03">res_03으로 이동</a>
	<a href="res_ex04?id=kkk123">res_04으로 이동</a>
	
	<form action ="res_ex05" >
		아이디:<input type="text" name="id"><br>
		이름:<input type="text" name="name"><br>
		<button type="submit">전송</button>
	</form>
	
</body>
</html>