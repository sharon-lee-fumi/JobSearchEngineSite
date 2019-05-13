<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Position</title>
</head>
<body>
	<h1> Position Details </h1>
	
	<c:url var="url" value="/saveEmployer" />
	<form:form modelAttribute="employer" methos="post" action="${url}">
		<div style="color:red">${name}</div>
		<form:hidden path="id" />
		Name:<form:input path="name" /><br/>
		
		<div style="color:red">${job_jobTitle}</div>
		Job Title:<form:input path="job.jobTitle" /><br/>
		<div style="color:red">${job_salaryMin}</div>
		Salary Min:<form:input path="job.salaryMin" /><br/>
		<div style="color:red">${job_salaryMax}</div>
		Salary Max:<form:input path="job.salaryMax" /><br/>
		<div style="color:red">${job_details}</div>
		Details: <form:textarea path="job.details" /><br>
		<input type="submit" value="Save!" />
	</form:form>
</body>
</html>