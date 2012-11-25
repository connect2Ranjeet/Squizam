/**
 * BasicPlan.java
 * --------------
 * Represents a free, basic plan with no premium features 
 */
package Membership;

public class BasicPlan extends Plan {

	private static double basicPlanFee = 0; 
	private static int productID = 00001; 
	
	/**
	 * Constructs BasicPlan object
	 */
	public BasicPlan() {
		super(basicPlanFee, productID);
	}
	
}
