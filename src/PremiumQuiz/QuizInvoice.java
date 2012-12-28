package PremiumQuiz;

import java.util.ArrayList;
import java.util.Date;

import Membership.LineItem;

public class QuizInvoice {

	private ArrayList<QuizLineItem> lineItems; 
	private String invoiceID = ""; 
	private Date dateSubmitted; 
	
	public QuizInvoice(){
		this.dateSubmitted = new Date();
		this.lineItems = new ArrayList<QuizLineItem>(); 
	}
	
	public QuizInvoice(String invoiceID, Date dateSubmitted){
		this.invoiceID = invoiceID; 
		this.dateSubmitted = dateSubmitted; 
		lineItems = new ArrayList<QuizLineItem>(); 
	}
	
	public QuizInvoice(String invoiceID, Date dateSubmitted, ArrayList<QuizLineItem> lineItems){
		this.invoiceID = invoiceID; 
		this.dateSubmitted = dateSubmitted; 
		this.lineItems = new ArrayList<QuizLineItem>(lineItems); 
	}
	/**
	 * Adds one line item to invoice
	 * @param lineItem
	 */
	public void addLineItem(QuizLineItem lineItem){
		this.lineItems.add(lineItem); 
	}
	
	public void removeLineItem(String name){
		for(int i = 0; i < lineItems.size(); i++){
			if(name.equals(lineItems.get(i).getName())){
				lineItems.remove(i); 
			}
		}
	}
	
	public int getLineItemsLength(){
		return lineItems.size(); 
	}
	
	/**
	 * Gets total price of this invoice as a double
	 * @return price
	 */
	public double getInvoicePrice(){
		double price = 0; 
		System.out.println("Line Items size: " + lineItems.size()); 
		for(int i = 0; i < lineItems.size(); i++){
			price += lineItems.get(i).getLineItemPrice(); 
			System.out.println("Price of Invoice: " + lineItems.get(i).getLineItemPrice()); 
		}
		return price; 
	}
	
	/**
	 * Gets total price of this invoice as a currency-formatted String
	 * @return priceString 
	 */
	public String getInvoicePriceString(){
		String priceString = LineItem.formatter.format(getInvoicePrice()); 
		return priceString; 
	}

	/**
	 * Gets invoiceID
	 * @return int invoiceID
	 */
	public String getInvoiceID() {
		return invoiceID;
	}

	/**
	 * Sets invoiceID
	 * @param invoiceID
	 */
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	/**
	 * Gets dateSubmitted
	 * @return Date dateSubmitted
	 */
	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	/**
	 * Sets dateSubmitted
	 * @param dateSubmitted
	 */
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	/**
	 * Gets lineItems
	 * @return ArrayList<LineItem> lineItems
	 */
	public ArrayList<QuizLineItem> getLineItems() {
		return lineItems;
	}

	/**
	 * Sets lineItems
	 * @param lineItems
	 */
	public void setLineItems(ArrayList<QuizLineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
}
