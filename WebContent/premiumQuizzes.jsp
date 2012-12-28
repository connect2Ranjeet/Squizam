<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, java.text.NumberFormat, PremiumQuiz.*"%>
<%@ include file="Header.jsp" %>
<%
	PremiumQuiz[] allQuizzes = PremiumQuizDB.getAllPremiumQuizzes();
%>
<%if(request.getAttribute("orderPlaced")!=null){
%>    
	<p>Thank you for your order! You can view all of your invoices by following the link below.</p>
	<br /><br />
<%}%>

<h1>Professional Quiz Packages</h1>

<p>Jump-start your career with these top-rated compilations of our premium professional quizzes. Each package has been carefully
written, reviewed and published by our team of expert instructors, and is ready to take your skills to the next level!</p>
<p>Buy one for yourself, or send some to your students, kids, or friends! Competitively priced, starting at $4.99/package. </p>

<form action="ProcessPremiumQuizServlet" method="post">
	<table>
		<tr>
			<th>Package</th>
			<th>Quantity</th>
		</tr>
<%
for(int i = 0; i < allQuizzes.length; i++){
%>
	<tr>
			<td><%=allQuizzes[i].getName()%></td>
			<td><input type="text" name="premiumQuizItem" value="0"  /></td>
	</tr>
<% 
}
%>
	
		<tr><td><input type="submit" value="Add To Cart" /></td></tr>
	</table>
</form>

<br /><br /><br />
<%@ include file="ShoppingCart.jsp" %>
<p>
<% 
String error = (String)request.getAttribute("error");
if(error != "" && error != null){
%>
<%=error%>
<%
}%>
</p>

<%@ include file="Footer.jsp" %>