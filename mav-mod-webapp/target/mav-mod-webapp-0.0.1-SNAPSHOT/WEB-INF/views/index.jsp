<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modular Maven Webapp</title>
</head>
<body>
	<p><a href="add">Add</a> a sample user.</p>
	
	<p><a href="get">Get</a> the cached user.</p>
	
	<div>
		<c:if test="${user != null}">
			You ${action} sample user ${user.first} ${user.last}.
		</c:if>
	</div>
</body>
</html>