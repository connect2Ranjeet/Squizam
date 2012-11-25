<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, java.text.NumberFormat, PremiumQuiz.*"%>
    
<h2>Shopping Cart</h2>

<%
	QuizInvoice invoice = (QuizInvoice)session.getAttribute("invoice"); 
	if(invoice==null){
		//nothing has been added to invoice yet		
%>
	<p>Your shopping cart is empty! Please add items in the table above</p>
<% 
	}else{
%>
<form action="ProcessPremiumQuizServlet" method="post">
<input type="hidden" name="updateCart" value="true"/>
<table border="1px solid black">
	<tr>
		<th>Item Name</th>
		<th>Quantity</th>
		<th>Price</th>
	</tr>

<% 
		ArrayList<QuizLineItem> lineItems = invoice.getLineItems(); 
		NumberFormat nf = NumberFormat.getCurrencyInstance(); 
		//shopping cart has items in it
		for(int i = 0; i < lineItems.size(); i++){
%>
		<tr>
			<td><%=lineItems.get(i).getName()%></td>
			<td><input type="text" name="<%= "updatedQuantity" + i %>" value="<%=lineItems.get(i).getQuantity()%>" /></td>
			<td><%=nf.format(lineItems.get(i).getLineItemPrice())%></td>
			<td><a href="ProcessPremiumQuizServlet?delete=<%=lineItems.get(i).getName()%>">Remove Item</a></td>
		</tr>
<% 
		}//end for
	}//end if-else
%>

<tr><td><input type="submit" value="Update Quantities" /></td></tr>
</table>
</form>