//Andrew Mealy
//Date: 1.14.16
//Star Time: 6:03pm
//Rescursive

package tester1234;
public class tester{
	public static void main(String[] args){
			int[] coins = {25,10,5,1};
			int[] value = new int[coins.length];
			System.out.println("Quarter\t"+ "Dime\t"+ "Nickel\t" + "Penny" );
			RecursiveCalculations(coins, value, 0, 100);
			System.out.println("Count: " + j);
		}
	static int j=0;
	public static void RecursiveCalculations(int[] coins, int[] value, int indexLocation, int totalAmount){	 
		if(indexLocation>=coins.length) {
	
			for(int i=0; i<coins.length; i++)
				System.out.print(""+value[i]+"\t");
				System.out.print("\n");
				j++;
				return;
			}
			if(indexLocation == coins.length-1){
				if(totalAmount%coins[indexLocation]==0) {
					value[indexLocation] = totalAmount/coins[indexLocation];
					RecursiveCalculations(coins, value, indexLocation+1, 0);
				}
			}
			else {
				for(int i=0; i<=totalAmount/coins[indexLocation]; i++) {
					value[indexLocation] = i;
					RecursiveCalculations(coins, value, indexLocation+1, totalAmount-coins[indexLocation]*i);
				}
			}
		}
	}
