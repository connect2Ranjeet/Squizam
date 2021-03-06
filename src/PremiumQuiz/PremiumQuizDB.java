package PremiumQuiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import utils.DatabaseUtil;

public class PremiumQuizDB {
	
	public static PremiumQuiz[] getAllPremiumQuizzes() {
		ArrayList<PremiumQuiz> quizList = new ArrayList<PremiumQuiz>(); 
		
		try{
			Connection conn = DatabaseUtil.getConnection(); //get connection object 
			Statement statement = conn.createStatement(); 
			String sqlQuery = "SELECT * FROM Products"; //NO SEMICOLON IF QUERY IS FROM JAVA!!! -- actual MySQL command to be executed
			statement.executeQuery(sqlQuery); //send in query via statement object
			ResultSet results = statement.executeQuery(sqlQuery); //records returned in object ResultSet
			
			while(results.next()){//iterate through ResultsSet object, getting one line/row of records at a time
				//and for each row of records, we pull data from each column individually and save to variables
				String name = results.getString("name"); 
				String description = results.getString("description"); 
				double price = results.getDouble("price");
				
				PremiumQuiz quiz = new PremiumQuiz(name, price, description);  //create Java object to store all of this info in one place
				quizList.add(quiz); 
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return quizList.toArray(new PremiumQuiz[0]); 
	}
	
	public static PremiumQuiz getPremiumQuiz(int id){
		PremiumQuiz quiz = new PremiumQuiz(); 
		try{
			Connection conn = DatabaseUtil.getConnection(); //get connection object 
			Statement statement = conn.createStatement(); 
			String sqlQuery = "SELECT * FROM Products WHERE productID = " + id; //NO SEMICOLON IF QUERY IS FROM JAVA!!! -- actual MySQL command to be executed
			statement.executeQuery(sqlQuery); //send in query via statement object
			ResultSet results = statement.executeQuery(sqlQuery); //records returned in object ResultSet
			
			while(results.next()){//iterate through ResultsSet object, getting one line/row of records at a time
				//and for each row of records, we pull data from each column individually and save to variables
				String name = results.getString("name"); 
				String description = results.getString("description"); 
				double price = results.getDouble("price");
				
				quiz = new PremiumQuiz(name, price, description);  //create Java object to store all of this info in one place
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return quiz; 
	}
	
	public static void insertInvoice(QuizInvoice invoice){
		try{
			
			Connection conn = DatabaseUtil.getConnection(); //get connection object 
			int invoiceID = 0; 
			String sqlQuery = ""; 
			
			//insert the invoice date into invoices TABLE --invoiceID auto-generated
			Statement statement = conn.createStatement(); 
			sqlQuery = "INSERT into Invoices VALUES(0, CURDATE())"; //CURDATE() - MySQL built-in date generating function	
			statement.executeUpdate(sqlQuery); //send in query via statement object
			sqlQuery = "SELECT LAST_INSERT_ID()"; //get invoiceID = aka last ID auto-generated by MySQL
			statement.executeQuery(sqlQuery); 
			ResultSet results = statement.executeQuery(sqlQuery);
			if(results.next()){
				invoiceID = results.getInt(1); 
			}
			
			//System.out.println("InvoiceID: " + invoiceID); 
			
			ArrayList<QuizLineItem> allLineItems = invoice.getLineItems(); 
			//System.out.println("Line Items size: " + allLineItems.size());
			
			//for each line item in the invoice, insert line item into LineItems TABLE -- LineItemsID auto-generated
			for(int i = 0; i < allLineItems.size(); i++){
				QuizLineItem thisLineItems = allLineItems.get(i); 
				String productName = thisLineItems.getName(); 
				//System.out.println("Product Name: " + productName); 
				//product ID
				int productID = 0;
				sqlQuery = "SELECT * FROM Products WHERE name = ?"; 
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
				ps.setString(1, productName);
				results = ps.executeQuery();
				while(results.next()){
					productID = results.getInt("productID"); 
				}
				//System.out.print("Product ID: " + productID); 
				
				//qty 
				int qty = thisLineItems.getQuantity(); 
				sqlQuery = "INSERT into LineItems VALUES(0, " + productID + ", " + qty + " )"; 
				statement.executeUpdate(sqlQuery); 
			
				//System.out.println("Quantity: " + qty); 
				
				//line item ID
				int LineItemsID = 0; 
				sqlQuery = "SELECT LAST_INSERT_ID()"; //get invoiceID = aka last ID auto-generated by MySQL
				statement.executeQuery(sqlQuery); 
				results = statement.executeQuery(sqlQuery);
				if(results.next()){
					LineItemsID = results.getInt(1); 
				}
				
				//System.out.println("LineItemsID: " + LineItemsID); 
				
				//insert invoiceID and LineItemsID for every LineItems in LineItemssInvoices TABLE -- foreign key table 
				sqlQuery = "INSERT into LineItemsInvoices VALUES( " + invoiceID + ", " + LineItemsID + " )"; 
				statement.executeUpdate(sqlQuery); 
				
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<QuizInvoice> getAllInvoices(){
		
		ArrayList<QuizInvoice> allInvoices = new ArrayList<QuizInvoice>(); 
		
		try{
			
			Connection conn = DatabaseUtil.getConnection(); 
			String sqlQuery = ""; 
			Statement statement = conn.createStatement(); 
			
			//Construct a QuizInvoice object for each invoice in the database, and store in ArrayList allInvoices 
			sqlQuery = "SELECT * FROM Invoices"; 
			ResultSet resultSet = statement.executeQuery(sqlQuery); 
			while(resultSet.next()){
				//invoiceID
				int invoiceID = resultSet.getInt("invoiceID"); 
				//System.out.println("Invoice ID: " + invoiceID); 
				//date 
				Date date = resultSet.getDate("date"); 
				//System.out.println("Date: " + date); 
				
				ArrayList<QuizLineItem> lineItems = new ArrayList<QuizLineItem>(); 
				
				//create Invoice Object
				sqlQuery = "SELECT Products.name, Products.price, LineItems.quantity FROM Invoices " +
						"INNER JOIN LineItemsInvoices ON Invoices.invoiceID = LineItemsInvoices.invoiceID " +
						"INNER JOIN LineItems ON LineItemsInvoices.lineItemID = LineItems.lineItemID INNER JOIN Products " +
						"ON LineItems.productID = Products.productID WHERE Invoices.invoiceID = ?"; 
				
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
				ps.setInt(1, invoiceID);
				ResultSet results = ps.executeQuery();
				//System.out.println("Results size: " + results.getFetchSize()); 
				while(results.next()){
					String name = results.getString("Products.name"); 
					//System.out.println("Name: " + name);
					
					double price = results.getDouble("Products.price"); 
					//System.out.println("Price: " + price); 
					
					int qty = results.getInt("LineItems.quantity"); 
					//System.out.println("Quantity: " +  qty + "\n"); 
					
					QuizLineItem thisLineItems = new QuizLineItem(name, qty, price); 
					lineItems.add(thisLineItems); 
					//System.out.println("Added Line Item"); 
				}
				
				QuizInvoice thisInvoice = new QuizInvoice("invoice" + invoiceID, date, lineItems);
				
				allInvoices.add(thisInvoice);
				

			}		

		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return allInvoices; 
	}
	
	public static void removeInvoice(String invoiceIDString){
		
		try{
			
			Connection conn = DatabaseUtil.getConnection(); 
			String sqlQuery = ""; 
			
			int invoiceID = Integer.parseInt(invoiceIDString.substring(7, invoiceIDString.length()));
			
			//Construct a QuizInvoice object for each invoice in the database, and store in ArrayList allInvoices 
			sqlQuery = "DELETE Invoices, LineItemsInvoices, LineItems FROM Invoices INNER JOIN " +
					" LineItemsInvoices ON Invoices.invoiceID = LineItemsInvoices.invoiceID INNER JOIN " +
					" LineItems ON LineItemsInvoices.lineItemID = LineItems.lineItemID WHERE Invoices.invoiceID = ?"; 
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, invoiceID);
			ps.executeUpdate();
			System.out.println("Invoice " + invoiceID + " removed"); 
			

		}catch(SQLException ex){
			ex.printStackTrace();
		}

	}
	
	
	/*
	public static Track[] getUserTracks(User u) {
		
	}
	*/
	
	public static void main(String[] args){


	}
}
