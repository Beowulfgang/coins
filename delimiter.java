//Andrew Mealy
//Date: 1.14.16
//Start Time: 7:12pm

import java.util.*;

public class delimiter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter in format: 'Quarter,25,Dime,10,Nickel,5,Penny,100");		
		String str = scan.nextLine();
		String names = str;	
		names = names.replaceAll("\\d.","");
		names = names.replaceAll(",{2}", "\t");	//gets user input names
		str = str.replaceAll("[^\\d.]+|\\.(?!\\d)", ",");  //regex ftw
	    String numberValue = str.replaceFirst("^,","");   
	    String[] stringArray = numberValue.split(","); 
	    Double[] intArray = new Double[stringArray.length];	 //stores coin values in double array   

	    for (int i = 0; i < stringArray.length; i++) {
	         String numberAsString = stringArray[i];
	         intArray[i] = Double.parseDouble(numberAsString);
	      }	  
	    
		Double[] value = new Double[intArray.length]; 
		System.out.println(names);//shouldn't have built using array
		RecursiveCalculations(intArray, value, 0, intArray[intArray.length-1]);
		System.out.println("Count: " + j);

	}
	static int j=0;
	public static void RecursiveCalculations(Double[] coins, Double[] value, int indexLocation, double totalAmount) {	 			
		if(indexLocation>=coins.length) {
			for(int i=0; i<coins.length; i++)
				System.out.print(""+value[i]+"\t");
				System.out.print("\n");
				j++;
			return;
		}
		if(indexLocation == coins.length-1) {
			if(totalAmount%coins[indexLocation]==0) {
				value[indexLocation] = totalAmount/coins[indexLocation];
				RecursiveCalculations(coins, value, indexLocation+1, 0);
			}
		}
		else {
			for(int i=0; i<=totalAmount/coins[indexLocation]; i++) {
				value[indexLocation] = (double) i;
				RecursiveCalculations(coins, value, indexLocation+1, totalAmount-coins[indexLocation]*i);
			}
		}

	}
}
