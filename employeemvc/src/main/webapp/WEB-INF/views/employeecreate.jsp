<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Employee Create</title>
</head>
<body>
		<h1>Create Employee</h1>
		<form:form method="POST" modelAttribute="newEmployee">
			Employee Id: <form:input path="id"/> <br>
			Employee Name: <form:input path="name"/> <br>
			Employee Salary: <form:input path="salary"/> <br>
			Employee Job: <form:input path="job"/> <br>
			<br>		
			<input type='submit' value='Submit'/>
		</form:form>		
</body>
</html>
