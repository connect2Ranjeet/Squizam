<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, java.text.NumberFormat, java.util.Date, PremiumQuiz.*"%>
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
		System.out.println("LINE ITEMS:" + lineItems.size()); 
		//shopping cart has items in it
		if(lineItems.size()>0){
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
		}else{
%>
			<p>Your shopping cart is empty! Please add items in the table above</p>
<%
		}
	}//end if-else
%>

<tr><td><input type="submit" value="Update Quantities" /></td></tr>
</table>
</form>
<br />
<a href="ProcessPremiumQuizServlet?finalize=true">Finalize Order!</a>
<br /><br />
<a href="ProcessPremiumQuizServlet?showAllInvoices=true">Show All Invoices</a>


<br /><br />
<% if(request.getAttribute("allInvoices") != null){ 
	ArrayList<QuizInvoice> allInvoices = (ArrayList<QuizInvoice>)request.getAttribute("allInvoices"); 
	if(allInvoices.size() > 0){
%>
<h3>Invoices:</h3>
<table border="1px solid black">
<tr><th>Invoice ID</th><th>Invoice Date</th><th>Invoice Cost</th></tr>
<%
	for(int i = 0; i < allInvoices.size(); i++){
		String invoiceID = allInvoices.get(i).getInvoiceID(); 
		Date invoiceDate = allInvoices.get(i).getDateSubmitted(); 
		String totalCost = allInvoices.get(i).getInvoicePriceString();
%>
	<tr>
		<td><%=invoiceID %></td>
		<td><%=invoiceDate %></td>
		<td><%=totalCost %></td>
		<td><a href=ProcessPremiumQuizServlet?removeInvoice=<%=invoiceID%>>Remove Invoice</a></td>
	</tr>
<%
	}//end for
%>
</table>
<%
	}else{
%>
	<p>There are no invoices on record</p>
<%
	}
}//end allInvoices
%>