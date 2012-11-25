/**
 * LineItem.java
 * -------------
 * Contains information regarding a user's paid membership plan
 */
package Membership;

import java.text.NumberFormat;

public class LineItem {
	//Keeps track of customer who has purchased paid plan, and their information 
	Plan myPlan;  //this customer's instance of PremiumPlan 
	private String planType = "premium"; 
	private String firstName; 
	private String lastName; 
	private String username; 
	private String password; 
	private String email; 
	private String creditCardType; 
	private String creditCardNum; 
	private String encodedCreditCardNum = "";  
	private String creditCardExp; 
	private int monthsPaidMembership;
	public static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	private double price; 
	private double monthlyRate; 
	
	
	/**
	 * Constructs new LineItem object 
	 * @param username
	 * @param password
	 * @param monthsPaidMembership
	 */
	public LineItem(String username, int monthsPaidMembership, String planType){
		if(planType.equals("premium")){
			myPlan = new PremiumPlan();
		}
		this.username = username; 
		this.monthsPaidMembership = monthsPaidMembership; 
		this.planType = planType; 
		this.price = monthsPaidMembership * myPlan.getMonthlyFee(); 
	}
	
	public LineItem(String username, String password, String firstName, String lastName, String email, String creditCardType, int creditCardExpMonth, int creditCardExpYear, String creditCardNum, String planType, int monthsPaidMembership){
		if(planType.equals("premium")){
			myPlan = new PremiumPlan();
		}
		this.username = username; 
		this.password = password; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.creditCardType = creditCardType; 
		this.creditCardNum = creditCardNum; 
		this.creditCardExp = creditCardExpMonth + "/" + creditCardExpYear; 
		this.planType = planType; 
		this.monthsPaidMembership = monthsPaidMembership; 
		this.monthlyRate = myPlan.getMonthlyFee(); 
		this.price = monthsPaidMembership * myPlan.getMonthlyFee(); 
		
		/*
		int creditCardLength = (this.creditCardNum).length(); 
		for(int i = 0; i < (creditCardLength - 4); i++){
			this.encodedCreditCardNum += "*"; 
		}
		
		this.encodedCreditCardNum += this.creditCardNum.charAt(creditCardLength - 4); 
		this.encodedCreditCardNum += this.creditCardNum.charAt(creditCardLength - 3); 
		this.encodedCreditCardNum += this.creditCardNum.charAt(creditCardLength - 2); 
		this.encodedCreditCardNum += this.creditCardNum.charAt(creditCardLength - 1); 
		*/
	}
	
	
	/**
	 * Returns price as a double of membership plan order
	 * @return totalPrice
	 */
	public double getLineItemPrice(){
		return price; 
	}
	
	public void setLineItemPrice(double price){
		this.price = price; 
	}
	
	/**
	 * Returns currency-formatted total price of membership plan order 
	 * @return totalPrice
	 */
	public String getLineItemPriceString(){
		String totalPriceString = ""; 	
		totalPriceString = formatter.format(getLineItemPrice());
		return totalPriceString; 
	}

	
	/**
	 * Gets customer's unique username
	 * @return String username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets customer's unique username
	 * @param String new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets months of paid membership 
	 * @return int monthsPaidMembership
	 */
	public int getMonthsPaidMembership() {
		return monthsPaidMembership;
	}
	
	/**
	 * Sets months of paid membership
	 * @param int new monthsPaidMembership
	 */
	public void setMonthsPaidMembership(int monthsPaidMembership) {
		this.monthsPaidMembership = monthsPaidMembership;
	} 

	public String toString(){
		String ret = "Username = " + username + "\nMonths of Premium Membership = " + monthsPaidMembership + "\nPrice: " + getLineItemPriceString(); 
		return ret; 
	}

	public String getPlanType() {
		return planType;
	}


	public void setPlanType(String planType) {
		this.planType = planType;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCreditCardType() {
		return creditCardType;
	}


	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}


	public String getCreditCardNum() {
		return creditCardNum;
	}


	public String getCreditCardExp() {
		return creditCardExp;
	}


	public void setCreditCardExp(String creditCardExp) {
		this.creditCardExp = creditCardExp;
	}


	public static NumberFormat getFormatter() {
		return formatter;
	}


	public static void setFormatter(NumberFormat formatter) {
		LineItem.formatter = formatter;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public String getEncodedCreditCardNum() {
		return encodedCreditCardNum;
	}

	public void setEncodedCreditCardNum(String encodedCreditCardNum) {
		this.encodedCreditCardNum = encodedCreditCardNum;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	
}
