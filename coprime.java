/* 
 * 7/24/2006
 * This program is meant to solve the problem, Optimus Coprime in the BHCSI
 * programming competition. The main purpose is to see whether two numbers are
 * coprime.
 */
 
import java.io.*;
import java.util.*;
import java.lang.*;

public class coprime{
	
	public static void main(String[] args) throws IOException{
		
		Scanner stdin = new Scanner(new File("coprime.in"));
		int id1, id2, cases, divisor;
		
// Reads in the number of cases
		cases = stdin.nextInt();
		
// Goes through each case one by one
		for(int index = 0;index < cases;index++){

// Reads in the 2 numbers			
			id1 = stdin.nextInt();
			id2 = stdin.nextInt();
			
// Goes through each potential factor and checks if any number divides into both.
			for(divisor = 2;divisor <= Math.min(id1, id2) && (id1%divisor != 0 || id2%divisor != 0);divisor++);
			
// If the divisor is greater than the min between the two, it did not find a factor between the two
			if(divisor > Math.min(id1, id2))
				System.out.println(id1 + " and " + id2 + ", TRANSFORM AND COMBINE!");
// Otherwise, the two numbers are not coprime				
			else
				System.out.println(id1 + " and " + id2 + ", separate and move out.");
		}
		
		stdin.close();
	}
	
}