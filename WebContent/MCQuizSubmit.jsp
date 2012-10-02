<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiple Choice Quiz Submission Page</title>
</head>
<body>
<%
	//IF STATEMENT
	String[] responses = new String[2]; //creates responses array to fit all passed parameters
	
	//Store student's responses in array, one response per array index
	for(int i=0; i<responses.length; i++){
		responses[i] = request.getParameter("q" + (i + 1));
	}
  	
%>

<%-- Print out the variables. --%>
<h1>You answered: </h1>
<p>Q1: <%= responses[0] %>, Q2:  <%= responses[1] %></p>


</body>
</html>