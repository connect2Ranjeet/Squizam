/**
 * Invoice.java 
 * ------------
 * Contains multiple LineItem objects, date submitted, and invoice ID
 *
 * @author megumihora
 */
package Membership;

import java.util.ArrayList;
import java.util.Date;


public class Invoice {
	
	private String invoiceID; 
	private Date dateSubmitted; 
	private ArrayList<LineItem> lineItems; 
	
	public Invoice(){
		this.dateSubmitted = new Date(); 
		this.lineItems = new ArrayList<LineItem>(); 
	}
	
	/**
	 * Constructs new empty Invoice object
	 * @param invoiceID
	 * @param lineItems
	 */
	public Invoice(String invoiceID, Date dateSubmitted){
		this.invoiceID = invoiceID; 
		this.dateSubmitted = dateSubmitted; 
		lineItems = new ArrayList<LineItem>(); 
	}
	
	/**
	 * Constructs new Invoice object with first line item only
	 */
	public Invoice(String invoiceID, Date dateSubmitted, LineItem firstLine){
		this(invoiceID, dateSubmitted); //calls default constructor
		lineItems.add(firstLine); //add 1st lineItem
	}
	
	/**
	 * Constructs new Invoice object with existing ArrayList of lineItems
	 * @param invoiceID
	 * @param lineItems
	 */
	public Invoice(String invoiceID, Date dateSubmitted, ArrayList<LineItem> lineItems){
		this(invoiceID, dateSubmitted); 
		this.lineItems = new ArrayList<LineItem>(lineItems); //use Collections' copy constructor to create new copy of parameter lineItems for this use
	}
	
	/**
	 * Adds one line item to invoice
	 * @param lineItem
	 */
	public void addLineItem(LineItem lineItem){
		this.lineItems.add(lineItem); 
	}
	
	/**
	 * Gets total price of this invoice as a double
	 * @return price
	 */
	public double getInvoicePrice(){
		double price = 0; 
		for(LineItem item : lineItems){
			price += item.getLineItemPrice(); 
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
	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}

	/**
	 * Sets lineItems
	 * @param lineItems
	 */
	public void setLineItems(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	
}
