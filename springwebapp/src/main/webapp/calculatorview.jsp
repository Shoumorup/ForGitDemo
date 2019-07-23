<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Answers here</title>
</head>
<body>
	<form action="calculator" method="get">
	Number1 <input name=n1> <br>
	Number2 <input name=n2> <br>
	
	<input name=op value="+" type=submit>
	<input name=op value="-" type=submit>
	<input name=op value="*" type=submit>
	<input name=op value="/" type=submit>
	
	</form> <br>
	<c:if test="${not(empty(result))}">
		<h3> Result is: </h3> 
		<h4> ${param.n1} ${param.op} ${param.n2} = ${result}</h4>
	</c:if>
</body>
</html>