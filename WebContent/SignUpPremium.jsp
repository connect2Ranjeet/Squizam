<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Membership.*, java.util.ArrayList"%>
<%@ include file="Header.jsp" %>

<%
	if(request.getAttribute("invoice") == null){
%>

	<h1>Sign up for Squizam Premium</h1>
	<form action="ProcessPremium" method="post" onSubmit="return validateForm(this)">
	<input type="button" onclick="alert('Hello from JavaScript')" value="Check JavaScript">			
	
		<p>If you'd like to sign up for Squizam Premium, please fill out the information below.</p>
		<input type="hidden" name="productID" value="00002" />
		
		<input type="checkbox" name="planType" value="premium" checked />Yes, I'd like to sign up for Squizam Premium<br />
		
		<table>
			<tr>
				<td>I'd like to sign up for: 
					<select name="timeUnits">
					  <option> </option>
					  <option>1</option>
					  <option>2</option>
					  <option>3</option>
					  <option>4</option>
					  <option>5</option>
					  <option>6</option>
					  <option>7</option>
					  <option>8</option>
					  <option>9</option>
					  <option>10</option>
					  <option>11</option>
					</select>
					<select name="monthsOrYears">
					  <option> </option>
					  <option>months</option>
					  <option>years</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>First Name: </td><td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name: </td><td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Username: </td><td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password: </td><td><input type="password" name="password1" /></td>
			</tr>
			<tr>
				<td>Re-enter Password: </td><td><input type="password" name="password2" /></td>
			</tr> 
			<tr>
				<td>Email: </td><td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Credit Card Type: </td>
				<td>
					<input type="radio" name="creditCardType" value="Visa" checked />Visa
					<input type="radio" name="creditCardType" value="Mastercard" />MasterCard
					<input type="radio" name="creditCardType" value="Discover" />Discover
					<input type="radio" name="creditCardType" value="American Express" />American Express 
				</td>
			</tr>
			<tr>
			<td>Credit Card Number: </td><td><input type="text" name="creditNum" /></td>
			</tr>
			<tr>
			<td>Credit Card Expiration Month: 
				<select name="creditExpMonth">
					  <option> </option>
					  <option>1</option>
					  <option>2</option>
					  <option>3</option>
					  <option>4</option>
					  <option>5</option>
					  <option>6</option>
					  <option>7</option>
					  <option>8</option>
					  <option>9</option>
					  <option>10</option>
					  <option>11</option>
					  <option>12</option>
					</select>
			</td>
			<td>Credit Card Expiration Year: 
				<select name="creditExpYear">
					  <option> </option>
					  <option>12</option>
					  <option>13</option>
					  <option>14</option>
					  <option>15</option>
					  <option>16</option>
					  <option>17</option>
					  <option>18</option>
					  <option>19</option>
					  <option>20-</option>
					</select>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
<%
	}else{
		Invoice myInvoice = (Invoice) request.getAttribute("invoice"); 
		ArrayList<LineItem> myLine = myInvoice.getLineItems(); 
%>
	
<h1>Thanks for signing up for Squizam Premium!</h1>
<p>Here are your account details:</p>
<table>
<%		for(int i = 0; i < myLine.size(); i++){ %>
		<tr><td>First Name: </td><td><%=myLine.get(i).getFirstName()%></td></tr>
		<tr><td>Last Name: </td><td><%=myLine.get(i).getLastName()%></td></tr>
		<tr><td>Username: </td><td><%=myLine.get(i).getUsername()%></td></tr>
		<tr><td>Email </td><td><%=myLine.get(i).getEmail()%></td></tr>
		<tr><td>Months of Premium Membership: </td><td><%=myLine.get(i).getMonthsPaidMembership()%></td></tr>
		<tr><td>Monthly Rate of Premium Membership</td><td><%=myLine.get(i).getPrice()%></td></tr>
		<tr><td>Membership Fee: </td><td><%=myLine.get(i).getLineItemPriceString()%></td></tr>
		<tr><td>Credit Card Type</td><td><%=myLine.get(i).getCreditCardType()%></td></tr>
		<%-- <tr><td>Credit Card Number</td><td><%=myLine.get(i).getEncodedCreditCardNum()</td></tr>--%>
<% 		} 
%>
</table>
<p>Total Invoice Cost: <bold><%=myInvoice.getInvoicePriceString()%></bold></p>

<p>Invoice ID: <i><%=myInvoice.getInvoiceID()%></i></p>
<p>This is invoice number: <i><%=request.getAttribute("invoiceCounter")%></i>

<% 
	}//end Invoice Summary
%>


<%@ include file="Footer.jsp" %>