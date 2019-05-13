<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employers</title>
<c:url value="/scripts/script.js" var="scriptUrl" />
<script src="${scriptUrl}"></script>
</head>
<body>
	<c:url value="/add" var="addUrl" />
	<p><a href="${addUrl}">Add a new job</a></p>
	<div>
		<c:url value="/getEmployer/" var="JSONUrl" />
		<c:forEach var="employer" items="${employerList}">
			<h3>
			<a href="#" id="a${employer.id}" onclick="getEmployer('${JSONUrl}', ${employer.id})">${employer.name}</a>
			<div id="employer${employer.id}"></div>
			</h3>
		</c:forEach>
	</div>
	
	<hr>
	<c:url value="/searchItem" var="searchUrl" />
	<form method="GET" action="${searchUrl}">
		Search by Employer Keyword: <input name="word" />
		
		<input type="submit" value="Search" />
	</form>
	<hr>
	<c:url value="/display" var="displayUrl" />
	<p><a href="${displayUrl}">Display Full Job List</a></p>

</body>
</html>