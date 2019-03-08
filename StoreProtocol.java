package StoreMode;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
 
/**
 * 
 * @author Dana Buzatu
 *
 */
public class StoreProtocol  {
	
    private static final int SEARCHING = 0;
    private static final int AVAILABILITY = 1;
    private static final int SELECTION = 2;
    private static final int DECISION = 3;
    private static final int PURCHASE =4;
 
    /**
     * Client entering the Store Mode
     * @param state
     */
    public void searching (int state) {
    	
    	//Client enters in The Store Mode
    	
    	state = AVAILABILITY;
    }
    
     /**
      * Check the bundles number availability in the server and currency owned by the Client
      * @param state
      * @param bundlesNumber how many bundles available
      * @param currency how many stars (currency available)
      */
    public void availability (int state, int bundlesNumber, int currency) {
    	if (bundlesNumber > 0 && currency > 0) {
    		state = SELECTION;
    	}
    }
    
    /**
     * The selection is being made
     * @param state
     */
    public void selecting (int state) {
    	
    	//selection with guitar controller, strumBar
    	
    	state = DECISION;
    }
    
    /**
     * Checks the clint response if he wants to make a purchase
     * @param state
     * @param theInput "Yes' or "No" response
     * @return the Output
     */
    public String deciding (int state, String theInput) {
    	
            String theOutput = "Do you want to buy this bundle?";
            
            if (theInput.equalsIgnoreCase("Yes")){
            	state = PURCHASE;
            }
            
            return theOutput;
    }
    /**
     * Purchasing by eliminating the Bundle from the Server and adding it to the client
     * @param state
     * @param listf List of Bundles f
     * @param currency owned by the Client
     * @return
     */
    public ArrayList<File> purchasing (int state, ArrayList<File> listf, int currency){
    	
    		//add the bundle to the Bundles List owned by the Client (Store Mode)
    	
    		currency = currency - 1; //decreasing the currency owned by the Client with 1 unit 
    		
    		//remove from the List of Bundles available in Server (Store Mode Manager)
    		
    		return listf;
    }
    
    public void main () {
    	
    	int state = SEARCHING;
        int bundlesNumber = 2; //how many bundles available
        int stars = 5; //get number of stars from play mode
        
        //creating the bundles as zip archives
        //createBundle("Layla.zip","img1.png", "img2.png", "img3.png");
    	//createBundle("Sweet-Child-Of-Mine.zip","img4.png", "img5.png", "img6.png");
    	
    	ArrayList<File> al = new ArrayList<File>(); // Server Bundles (Store Mode Manager)
    	ArrayList<File> bl = new ArrayList<File>(); // Client Bundles (Store Mode)
    	
    	//adding to the Server Bundles and removing from Client Bundles
    	
    	//al.add("Layla.zip");
    	//al.add("Sweet-Child-Of-Mine.zip");
    	//bl.remove("Layla.zip");
    	//bl.remove("Sweet-Child-Of-Mine.zip");
    	
    	if (state == SEARCHING) {
    		searching(state);}
    		
    	if (state == AVAILABILITY) {
			availability (state, bundlesNumber, stars);}
    	
    	
    	if  (state == SELECTION) {
    		selecting (state);
    	}
    	
    	if (state == DECISION) {
    		deciding (state,"Yes");
    	}
    	
    	if (state == PURCHASE) {
    		purchasing (state, al, stars);
    	}
    }	
    	
}
    