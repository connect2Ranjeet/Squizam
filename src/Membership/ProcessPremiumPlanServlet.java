package Membership;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessPremiumPlanServlet
 */
@WebServlet({ "/ProcessPremiumPlanServlet", "/ProcessPremium" })
public class ProcessPremiumPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductsHashtable productsTable; 
    private Invoice myInvoice; 
    private int invoiceCounter; 
    
    public void init(){
    	productsTable = new ProductsHashtable(); 
    	invoiceCounter = 0; 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName"); 
		String lastName = request.getParameter("lastName"); 
		String email = request.getParameter("email"); 
		String username = request.getParameter("username"); 
		String password = request.getParameter("password1"); 
		int timeUnits = Integer.parseInt(request.getParameter("timeUnits")); 
		String monthsOrYears = request.getParameter("monthsOrYears");
		String planType = request.getParameter("planType"); 
		String creditCardNum = request.getParameter("creditCardNum"); 
		int creditCardExpMonth = Integer.parseInt(request.getParameter("creditExpMonth")); 
		int creditCardExpYear = Integer.parseInt(request.getParameter("creditExpYear")); 
		String creditCardType = request.getParameter("creditCardType"); 
		
		Date dateSubmitted = new Date(); 
		myInvoice = new Invoice(firstName + lastName + dateSubmitted.toString(), dateSubmitted);
		invoiceCounter++; //add 1 to the invoice counter, to keep track of number of invoices created since server startup
		int numMonthsSubscription = 0; 
		if(monthsOrYears.equals("months")){
			numMonthsSubscription = timeUnits; 
		}else if(monthsOrYears.equals("years")){
			numMonthsSubscription = timeUnits * 12; 
		}
		LineItem item1 = new LineItem(username, password, firstName, lastName, email, creditCardType, creditCardExpMonth, creditCardExpYear, creditCardNum, planType, numMonthsSubscription); 
		myInvoice.addLineItem(item1); 
		

		String url="/SignUpPremium.jsp";
		request.setAttribute("invoice", myInvoice);
		request.setAttribute("invoiceCounter", invoiceCounter); 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
		dispatcher.forward(request,response); //send user back to SignUpPremium page 

	}

}
