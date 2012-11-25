<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, java.text.NumberFormat, PremiumQuiz.*"%>
<%@ include file="Header.jsp" %>

<h1>Professional Quiz Packages</h1>

<p>Jump-start your career with these top-rated compilations of our premium professional quizzes. Each package has been carefully
written, reviewed and published by our team of expert instructors, and is ready to take your skills to the next level!</p>
<p>Buy one for yourself, or send some to your students, kids, or friends! Competitively priced at $4.99/package. </p>

<form action="ProcessPremiumQuizServlet" method="post">
	<table>
		<tr>
			<th>Package</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td>SAT Beginner Vocab</td>
			<td><input type="text" name="begVocabSATQty" value="0" /></td>
		</tr>
		<tr>
			<td>SAT Intermediate Vocab</td>
			<td><input type="text" name="intVocabSATQty" value="0"  /></td>
		</tr>
		<tr>
			<td>SAT Advanced Vocab</td>
			<td><input type="text" name="advVocabSATQty" value="0"  /></td>
		</tr>
		<tr>
			<td>SAT Beginner Math</td>
			<td><input type="text" name="begMathSATQty" value="0" /></td>
		</tr>
		<tr>
			<td>SAT Intermediate Math</td>
			<td><input type="text" name="intMathSATQty" value="0" /></td>
		</tr>
		<tr>
			<td>SAT Advanced Math</td>
			<td><input type="text" name="advMathSATQty" value="0" /></td>
		</tr>
		<tr>
			<td>GRE Vocab I</td>
			<td><input type="text" name="vocab1GREQty" value="0" /></td>
		</tr>
		<tr>
			<td>GRE Vocab II</td>
			<td><input type="text" name="vocab2GREQty" value="0" /></td>
		</tr>
		<tr><td><input type="submit" value="Add To Cart" /></td></tr>
	</table>
</form>

<br /><br /><br />
<%@ include file="ShoppingCart.jsp" %>

<%@ include file="Footer.jsp" %>