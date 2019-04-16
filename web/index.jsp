<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 绝对地址 -->
	<a href="http://localhost:8080/Ch03/TestHttpServletRequest">访问servlet,全拼的时候</a><br />
	<a href="/Ch03/TestHttpServletRequest">访问servlet</a><!-- 永远从上下文路径开始写 --><br />
	<!-- 相对地址 -->
	<a href="./TestHttpServletRequest?username=peter&age=18">访问servlet,相对地址</a><br />
	<a href="TestHttpServletRequest">访问servlet,相对地址</a><!-- ./ 可以缺省不写 -->
	
	<form action="TestHttpServletRequest" method="post"><!-- 只有这一种方法 使用post方法 -->
		<input type="text" name="username"/>
		<input type="text" name="username"/>
		<input type="text" name="age"/>
		<input type="submit" value="访问Servlet"/>
	</form>
	<!-- post请求中   请求体中是有东西的 -->
	
</body>
</html>