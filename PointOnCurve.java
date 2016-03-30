/*
 * @author Saurabh Chavan
 * @version 1.0
 * @name ECC points on curve
 * @date 5.13.2015
 */


package chinmay;
import java.math.*;

public class PointOnCurve { //generator //elliptic curve points

	BigInteger y,a,b,P,r1,r2,new_x,new_y;
	int exponent;
    
	
    public void computePoints(BigInteger a,BigInteger b,BigInteger P){
    	
    	int p = P.intValue();
    	exponent=(p+1)/4;  
    	int count=1;
    	
    	for(BigInteger x=BigInteger.ZERO;(x.intValue())<p;x=x.add(new BigInteger("1"))){
    		
    		
    		 y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(P);
    		 r1=(y.pow(exponent)).mod(P);
    	     r2=(P.subtract(r1)).mod(P);    		 
    		 new_x=(r1.pow(2)).mod(P);
    		 new_y=(r2.pow(2)).mod(P);
    		 
    		 if(y.equals(new_x) && y.equals(new_y)){
    			 
    			 
    			 System.out.println("P"+count+" ("+x+","+r1+")"); 
    			 count++;
    			 System.out.println("P"+count+" ("+x+","+r2+")");
    			 count++;
    			 
    		 }
    		
    	}
    	
    	
    }
    
    
    public static void main(String[] args){
    	
    	PointOnCurve pc=new PointOnCurve();
    	
                                  //a                     //b             //P
    	pc.computePoints(new BigInteger("2"),new BigInteger("9"),new BigInteger("23"));
    	
    	
    }
	
	
	
}
