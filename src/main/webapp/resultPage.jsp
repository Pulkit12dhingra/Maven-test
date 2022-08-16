<%@ page language="java" contentType="text/html; charset = ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="true"%>
<! DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>

<body>
	<h1>
		Result =
		<%= request.getAttribute("result") %>
	</h1>
</body>
</html>