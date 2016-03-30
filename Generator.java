import java.util.*;
import java.math.*;
import java.*;

public class Generator {
	
	public BigInteger []marray,barray,uarray,Aarray;
	public int i=0,j,res,res1,res2;
    public BigInteger u,P,m,saved_val;
           	
	public static void main(String[] args) {
				
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Generator Calculator");
    	System.out.print("Please enter the number to calculate factors :");
    	int n=sc.nextInt();
    	System.out.printf("Prime factors of number "+n +" are : " + PrimeFactorsCaclulator.primeFactorsCalculator(n-1));
    	List<Integer> listx= new ArrayList<Integer>();
    	listx=(ArrayList<Integer>) PrimeFactorsCaclulator.primeFactorsCalculator(n-1);
 
   	System.out.println(listx);
		BigInteger u,m1,P,A;
		int comp;
		P = BigInteger.valueOf(n);
	    Generator g=new Generator();
	    BigInteger pminus1=P.subtract(new BigInteger("1"));
	      	    
outerloop:for( int j=2;j<pminus1.intValue();j++){
	    	     u = BigInteger.valueOf(j);
              for(int x=0;x<listx.size();x++){
	    		 
	    		 m1=pminus1.divide(BigInteger.valueOf(listx.get(x)));
	    		 A=SquareAMultiply.modExp(u,m1,P);
	    		 comp=A.compareTo(new BigInteger("1"));
	 	    	if(comp == 0){	 	    	
	 	    		continue outerloop;
	 	    	}	    		 	    	    		 
	    	 }		
	    		  System.out.println("The  generator is  = "+j);
	    	      break;	
	    	}    	
	    }
	    }
