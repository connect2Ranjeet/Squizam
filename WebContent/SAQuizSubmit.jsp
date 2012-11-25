<%@ include file="Header.jsp" %>

<%
	String numSAQuestions = request.getParameter("numSAQuestions"); 
	String[] responses = new String[Integer.parseInt(numSAQuestions)]; //creates responses array to fit all passed parameters
	
	//Store student's responses in array, one response per array index
	for(int i=0; i<responses.length; i++){
		responses[i] = request.getParameter("q" + (i + 1));
	}
  	
%>

<%-- Print out the variables. --%>
<h1>You answered: </h1>
<p>Q1: <%= responses[0] %></p>

<%@ include file="Footer.jsp" %>