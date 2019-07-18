<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator result here</title>
</head>
<body bgcolor=blue>

<blink> Result: ${param.n1} ${param.op} ${param.n2} = ${requestScope.result}</blink>

</body>
</html>