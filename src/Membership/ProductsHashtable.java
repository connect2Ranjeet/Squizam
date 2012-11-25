/**
 * ProductsHashtable.java
 * -------------------
 * Hashtable is used to store purchases, with Key: Integer of ProductID, and Value: PremiumPlan objects 
 * Acts as temporary substitute for a database, which will eventually be used to store purchases' information 
 */

package Membership;

import java.util.Hashtable;

public class ProductsHashtable {
	
	private Hashtable<Integer, Plan> allPlans; 

	/**
	 * Creates new empty Hashtable to keep track of purchases
	 */
	public ProductsHashtable(){
		allPlans = new Hashtable<Integer, Plan>(); 
		
		PremiumPlan premPlan = new PremiumPlan();
		BasicPlan basicPlan = new BasicPlan();
		
		allPlans.put(premPlan.getProductID(), premPlan); 
		allPlans.put(basicPlan.getProductID(), basicPlan); 
	}
	
	/**
	 * Adds plan by productID key and PremiumPlan value into Hashtable 
	 * @param PremiumPlan thisPlan
	 */
	public void addPlan(Plan thisPlan){
		allPlans.put(thisPlan.getProductID(), thisPlan); 
	}
	
	/**
	 * Looks up plan by productID in Hashtable, and returns that plan 
	 * @param productID
	 * @return PremiumPlan thisPlan
	 */
	public Plan getPremiumPlan(int productID){
		Plan thisPlan = allPlans.get(productID); 
		return thisPlan; 
	}
}
