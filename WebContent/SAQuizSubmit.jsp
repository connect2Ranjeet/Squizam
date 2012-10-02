<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Short Answer Quiz Submission Page</title>
</head>
<body>

<%
	
	String[] responses = new String[1]; //creates responses array to fit all passed parameters
	
	//Store student's responses in array, one response per array index
	for(int i=0; i<responses.length; i++){
		responses[i] = request.getParameter("q" + (i + 1));
	}
  	
%>

<%-- Print out the variables. --%>
<h1>You answered: </h1>
<p>Q1: <%= responses[0] %></p>

</body>
</html>