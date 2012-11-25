<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>
	<h1>Short Answer Quiz</h1>
	<form method=post action="SAQuizSubmit.jsp">
	
		Q1. Describe the role of photosynthesis in the water cycle:<br /> <textarea rows="10" cols="50" name="q1"></textarea><br /><br /><br />
		
		<input type="hidden" name="quizID" id="quizID" value="000002" />
		<input type="hidden" name="numSAQuestions" id="numSAQuestions" value="1" />
		<input type="submit" value="SUBMIT" />
		
	</form>
	
<%@ include file="Footer.jsp" %>