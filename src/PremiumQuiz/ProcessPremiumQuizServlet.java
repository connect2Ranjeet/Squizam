package PremiumQuiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Membership.Invoice;
import Membership.LineItem;

/**
 * Servlet implementation class ProcessPremiumPackage
 */
@WebServlet({ "/ProcessPremiumPackage", "/ProcessPackage" })
public class ProcessPremiumQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean error = false; 
	private PremiumQuiz[] allQuizzes; 
	ArrayList<String> toDeleteArrayList = new ArrayList<String>(0); 
	
	public void init(){
		allQuizzes = PremiumQuizDB.getAllPremiumQuizzes();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		QuizInvoice myInvoice = (QuizInvoice) session.getAttribute("invoice"); 
		if(myInvoice == null){
			myInvoice = new QuizInvoice(); 
		}
		
		//user is ready to finalize/submit their order
		String finalize = request.getParameter("finalize");
		
		if(finalize != null && finalize.equals("true")){
			if(myInvoice.getLineItemsLength() > 0){
				System.out.println("Adding invoice to db"); 
				PremiumQuizDB.insertInvoice(myInvoice); 
				//if insertion is successful, clear current invoice object
				if(myInvoice != null){
					myInvoice = new QuizInvoice(); 
					request.setAttribute("orderPlaced", true); 
				}
			}else{
				System.out.println("No items in the invoice."); 
			}
		}
		
		String showAllInvoices = request.getParameter("showAllInvoices"); 
		if(showAllInvoices != null && showAllInvoices.equals("true")){
			System.out.println("Showing All Invoices"); 
			ArrayList<QuizInvoice> allInvoices = PremiumQuizDB.getAllInvoices(); 
			request.setAttribute("allInvoices", allInvoices);
		}
		
		String removeInvoice = request.getParameter("removeInvoice"); 
		if(removeInvoice != null){
			System.out.println("Removing Invoice: " + removeInvoice); 
			PremiumQuizDB.removeInvoice(removeInvoice); 
		}
		
		//user pressed 'remove line item' link
		String toDelete = request.getParameter("delete"); 
		if(toDelete != null && !toDelete.equals("")){ //if user has selected link to delete a line item
			System.out.println("Deleting item: " + toDelete); 
			myInvoice.removeLineItem(toDelete); //remove that line item from the invoice
			System.out.println("Invoice length" + myInvoice.getLineItemsLength()); 
			if(myInvoice.getLineItemsLength() == 0){
				System.out.println("Empty Invoice!"); 
				myInvoice = null; //reset myInvoice to null so that shopping cart displays as empty again, if the invoice is empty
			}
			//System.out.println(toDelete); 
		}//delete line item 
		
		//user pressed 'update cart' button
		String updateCart = request.getParameter("updateCart"); 
		if(updateCart != null && updateCart.equals("true")){
			ArrayList<QuizLineItem> lineItems = myInvoice.getLineItems(); 
			if(lineItems != null && lineItems.size() > 0){
				for(int i = 0; i < lineItems.size(); i++){
					String name = "updatedQuantity" + i; 
					System.out.println(name); 
					String updatedQuantity = request.getParameter(name); 
					System.out.println(updatedQuantity); 
					int updatedQty = 0; 
					
					if(updatedQuantity != null && updatedQuantity != ""){
						try{
							updatedQty = Integer.parseInt((updatedQuantity).trim()); 
						}catch(NumberFormatException e){
							System.out.println("This is not a number");
					        System.out.println(e.getMessage());
					        error = true; 
						}
						if(updatedQty == 0){ //if user has not entered valid quantity or if they changed the quantity to 0, remove that line item 
							toDeleteArrayList.add(lineItems.get(i).getName()); 
							//myInvoice.removeLineItem(item.getName()); 
						}else if(updatedQty > 0){
							lineItems.get(i).setQuantity(updatedQty); //otherwise, update line item quantity in invoice 
							System.out.println("Line Item name: " + lineItems.get(i).getName()); 
							System.out.println("New Line Item quantity: " + lineItems.get(i).getQuantity()); 
							System.out.println("Updated quantity: " + updatedQty); 
						}else{
							error = true; 					}
						//move onto next parameter line item 
					}else{
						error = true; 				}
					
				}//end for
			}
			//now we delete the line items whose indices were stored in the toDeleteArray
			for(int i = 0; i < toDeleteArrayList.size(); i++){
				System.out.println("Deleting: " + toDeleteArrayList.get(i)); 
				myInvoice.removeLineItem(toDeleteArrayList.get(i)); 	
			}
		}//update cart
	
		for(int i = 0; i < allQuizzes.length; i++){
			PremiumQuiz thisQuiz = allQuizzes[i]; 
		}
		
		String[] itemQuantities = request.getParameterValues("premiumQuizItem"); 
		
		if(itemQuantities != null){
			for(int i = 0; i < itemQuantities.length; i++){
				if(itemQuantities[i] != null && itemQuantities[i] != ""){
					int qty = 0; 
					try{
						qty = Integer.parseInt(itemQuantities[i]); 
					}catch(NumberFormatException e){
						System.out.println("This is not a number");
				        System.out.println(e.getMessage());
				        error = true; 
					}
					if(qty >= 0){
						String name = allQuizzes[i].getName(); 
						if(qty !=0 && !containsProduct(name, qty, myInvoice)){
							QuizLineItem item = new QuizLineItem(name, qty, allQuizzes[i].getPrice()); 
							myInvoice.addLineItem(item); 
						}
					}else{
						error = true; 			}
				}
			}
		}

		
		String errorMsg = ""; 
		
		if(error){
			errorMsg = "Please ensure all inputs are positive integers."; 
			error = false; 
		}
		
		session.setAttribute("invoice", myInvoice); 

		String url="/premiumQuizzes.jsp";
		request.setAttribute("invoice", myInvoice);
		request.setAttribute("error", errorMsg); 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
		dispatcher.forward(request,response); //send user back to SignUpPremium page 
		
	}
	
	public boolean containsProduct(String name, int addQuantity, QuizInvoice myInvoice){
		ArrayList<QuizLineItem> lineItems = myInvoice.getLineItems(); 
		for(QuizLineItem item : lineItems){
			if(name.equals(item.getName())){
				//that item already exists - so we increment the quantity instead of adding a new line item
				item.setQuantity(item.getQuantity() + addQuantity); 
				return true; 
			}
		}
		return false;	
	}

}
