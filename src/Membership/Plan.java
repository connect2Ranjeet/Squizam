/**
 * Plan.java
 * -------------------
 * Abstract class representing a user's membership plan 
 */

package Membership;

public abstract class Plan{
	
	private double monthlyFee; 
	private int productID; 
	
	/**
	 * Constructs Abstract Plan object
	 */
	public Plan(double monthlyFee, int productID){
		this.monthlyFee = monthlyFee; 
		this.productID = productID; 
	}
	
	/**
	 * Getter for monthly fee
	 * @return monthlyFee
	 */
	public double getMonthlyFee(){
		return monthlyFee; 
	}
	
	/**
	 * Setter for monthly fee
	 * @param monthlyFee
	 * @throws IllegalArgumentException is input is invalid 
	 */
	public void setMonthlyFee(double monthlyFee){
		if(monthlyFee >= 0){
			this.monthlyFee = monthlyFee; 
		}else{
			throw new IllegalArgumentException("Please enter valid monthly fee that is 0 or greater"); 
		}
	}
	
	/**
	 * Gets productID
	 * @return productID
	 */
	public int getProductID(){
		return productID; 
	}
	
	/**
	 * Sets productID
	 * @param int productID
	 */
	public void setProductID(int productID){
		this.productID = productID; 
	}
	
	
}//end Plan class
