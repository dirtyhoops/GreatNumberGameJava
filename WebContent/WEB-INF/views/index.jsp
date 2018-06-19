<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	
</head>
<body>
	<h2>Welcome to the Great Number Game!</h2>
	<h4>I am thinking of  a number between 1 and 100</h4>
	<h4>Take a guess</h4>
	
	<% String guessResponse = (String) session.getAttribute("guessResponse");
	if(guessResponse == "correct") { %>
		<div class="correctResponse">
			<h2>CORRECT!!!!</h2>
		</div>
	<% } else if(guessResponse == "low") {%>
		<div class="lowResponse">
			<h2>Too Low</h2>
		</div>	
	<% } else if(guessResponse == "high") { %>
		<div class="highResponse">
			<h2>Too High</h2>
		</div>
	<% } %>
	
	
	
	<form action="/GreatNumberGame/index" method="post">
		<input type="number" name="guess">
		<button class="btn btn-success">Submit</button>
	</form>
	
</body>
</html>