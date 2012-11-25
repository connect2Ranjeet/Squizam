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
	private static final double quizPrice = 4.99; 


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
		
		String toDelete = request.getParameter("delete"); 
		if(toDelete != null && !toDelete.equals("")){ //if user has selected link to delete a line item
			myInvoice.removeLineItem(toDelete); //remove that line item from the invoice
			if(myInvoice.getLineItemsLength() == 0){
				myInvoice = null; //reset myInvoice to null so that shopping cart displays as empty again, if the invoice is empty
			}
			//System.out.println(toDelete); 
		}//delete line item 
		
		String updateCart = request.getParameter("updateCart"); 
		if(updateCart != null && updateCart.equals("true")){
			ArrayList<QuizLineItem> lineItems = myInvoice.getLineItems(); 
			ArrayList<String> toDeleteArrayList = new ArrayList<String>(0); 
			for(int i = 0; i < lineItems.size(); i++){
				String name = "updatedQuantity" + i; 
				System.out.println(name); 
				System.out.println(i); 
				String updatedQuantity = request.getParameter(name); 
				int updatedQty = 0; 
				
				if(updatedQuantity != null && updatedQuantity != ""){
					updatedQty = Integer.parseInt((updatedQuantity).trim()); 
				}
				
				if(updatedQty == 0){ //if user has not entered valid quantity or if they changed the quantity to 0, remove that line item 
					toDeleteArrayList.add(lineItems.get(i).getName()); 
					//myInvoice.removeLineItem(item.getName()); 
				}else{
					lineItems.get(i).setQuantity(updatedQty); //otherwise, update line item quantity in invoice 
				}	
				//move onto next parameter line item 
			}//end for
			
			//now we delete the line items whose indices were stored in the toDeleteArray
			for(int i = 0; i < toDeleteArrayList.size(); i++){
				System.out.println(toDeleteArrayList.get(i)); 
				myInvoice.removeLineItem(toDeleteArrayList.get(i)); 	
			}
		}//update cart
	
		String begVocabSATQty = request.getParameter("begVocabSATQty"); 
		String intVocabSATQty = request.getParameter("intVocabSATQty"); 
		String advVocabSATQty = request.getParameter("advVocabSATQty"); 
		String begMathSATQty = request.getParameter("begMathSATQty"); 
		String intMathSATQty = request.getParameter("intMathSATQty"); 
		String advMathSATQty = request.getParameter("advMathSATQty"); 
		String vocab1GREQty = request.getParameter("vocab1GREQty"); 
		String vocab2GREQty = request.getParameter("vocab2GREQty"); 
		
		if(begVocabSATQty!=null){
			int begVocabSAT = Integer.parseInt(begVocabSATQty); 
			String name = "Beginner Vocab SAT"; 
			if(begVocabSAT != 0 && !containsProduct(name, begVocabSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, begVocabSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(intVocabSATQty!=null){
			int intVocabSAT = Integer.parseInt(intVocabSATQty); 
			String name = "Intermediate Vocab SAT"; 
			if(intVocabSAT != 0 && !containsProduct(name, intVocabSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, intVocabSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(advVocabSATQty!=null){
			int advVocabSAT = Integer.parseInt(advVocabSATQty); 
			String name = "Advanced Vocab SAT"; 
			if(advVocabSAT != 0 && !containsProduct(name, advVocabSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, advVocabSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(begMathSATQty!=null){
			int begMathSAT = Integer.parseInt(begMathSATQty); 
			String name = "Beginner Math SAT"; 
			if(begMathSAT != 0 && !containsProduct(name, begMathSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, begMathSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(intMathSATQty!=null){
			int intMathSAT = Integer.parseInt(intMathSATQty); 
			String name = "Intermediate Math SAT"; 
			if(intMathSAT != 0 && !containsProduct(name, intMathSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, intMathSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(advMathSATQty!=null){
			int advMathSAT = Integer.parseInt(advMathSATQty); 
			String name = "Advanced Math SAT"; 
			if(advMathSAT != 0 && !containsProduct(name, advMathSAT, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, advMathSAT, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(vocab1GREQty!=null){
			int vocab1GRE = Integer.parseInt(vocab1GREQty); 
			String name = "GRE Vocab Part I"; 
			if(vocab1GRE != 0 && !containsProduct(name, vocab1GRE, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, vocab1GRE, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		if(vocab2GREQty!=null){
			int vocab2GRE = Integer.parseInt(vocab2GREQty); 
			String name = "GRE Vocab Part II"; 
			if(vocab2GRE != 0 && !containsProduct(name, vocab2GRE, myInvoice)){
				QuizLineItem item = new QuizLineItem(name, vocab2GRE, quizPrice); 
				myInvoice.addLineItem(item); 
			}
		}
		
		session.setAttribute("invoice", myInvoice); 

		String url="/premiumQuizzes.jsp";
		request.setAttribute("invoice", myInvoice);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
		dispatcher.forward(request,response); //send user back to SignUpPremium page 
		

	}
	
	public boolean containsProduct(String name, int addQuantity, QuizInvoice myInvoice){
		ArrayList<QuizLineItem> lineItems = myInvoice.getLineItems(); 
		for(QuizLineItem item : lineItems){
			if(name.equals(item.getName())){
				//that item already exists - so we incremenet the quantity instead of adding a new line item
				item.setQuantity(item.getQuantity() + addQuantity); 
				return true; 
			}
		}
		return false;	
	}

}
