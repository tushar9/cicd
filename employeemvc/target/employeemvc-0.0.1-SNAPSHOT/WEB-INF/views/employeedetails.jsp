<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Employee Details</title>
</head>
<body>
		<h1>Employee Details</h1>
		Employee Id: ${employee.id} <br>
		Employee Name: ${employee.name} <br>
		Employee Salary: ${employee.salary} <br>
		Employee Job: ${employee.job} <br>
		<br>
		<a href='/employeemvc/mvc/employees/all'>Back to List Page</a>
</body>
</html>
