/**
 * PremiumPlan.java
 * ----------------
 * Represents a paid membership plan with premium features 
 * 
 * @author megumihora
 */

package Membership;

public class PremiumPlan extends Plan {

	private static double premiumPlanFee = 5; 
	private static int productID = 00002;
	private String notes; 
	//private int monthsPaidMembership; 
	
	/**
	 * Constructs PremiumPlan object
	 */
	public PremiumPlan(){//param int monthsPaidMembership
		super(premiumPlanFee, productID);
		//this.monthsPaidMembership = monthsPaidMembership; 
	}
	
	public PremiumPlan(String notes){
		this(); 
		this.notes = notes; 
	}
	
	/**
	 * Gets number of months of paid membership that the customer paid for 
	 * @return
	 */
	/*public int getMonthsPaid(){
		return monthsPaidMembership; 
	}*/
	
	/**
	 * Sets number of months of paid membership that the customer paid for
	 * @param monthsPaid
	 */
	/*public void setMonthsPaid(int monthsPaid){
		this.monthsPaidMembership = monthsPaid; 
	}*/
	

	
}
