<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Header.jsp" %>
	<h1>Multiple Choice Quiz</h1>
	<form method=post action="MCQuizSubmit.jsp">
	
		What type of cell in the eye detects color? <br />
		<input type="radio" name="q1" value="rods">Rods<br />
		<input type="radio" name="q1" value="cones">Cones<br /><br />
	
		Which ONE of these animals is NOT a vertebrate? <br />
		<select name="q2">
			<option value="tiger">Tiger
			<option value="snail">Snail
			<option value="whale">Whale
			<option value="trout">Trout
			<option value="pelican">Pelican
		</select> 
		
		<br /><br />
		
		<input type="hidden" name="quizID" id="quizID" value="000001" />
		<input type="hidden" name="numMCQuestions" id="numMCQuestions" value="2" />
	
		<input type="submit" value="SUBMIT" />
	</form>
<%@ include file="Footer.jsp" %>