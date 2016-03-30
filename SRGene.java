/*
 * @author Saurabh Chavan
 * @version 2.0
 * @name ModuloInverse
 * @date 5.13.2015
 */
package chinmay;
import java.util.*;
import java.math.*;

class SRGene extends ModuloInverse{

 private static Scanner src;

public static void main(String[] args){
    	
    	
    	     BigInteger y,a,b,P,r1,r2,d,d1,alpha,alpha1,x2P,y2P,xnextP,ynextP,x,prevX,prevY,new_x,new_y;
    	     int order=1;
    	         	     
    	     src = new Scanner(System.in);
    		
    	     System.out.println("Please enter x");	     		
    	     x=src.nextBigInteger();

    		 System.out.println("Please enter y");
    		 r1=src.nextBigInteger();
    		 
    		 System.out.println("Please enter a");
    		 a=src.nextBigInteger();
    		 
    		 System.out.println("Please enter b");
    		 b=src.nextBigInteger();
    		 
    		 System.out.println("Please enter P");
    		 P=src.nextBigInteger();
    		 r2=(P.subtract(r1)).mod(P);    		 
             System.out.println("hello"+r2);
             
             y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(P);
             new_x=(r1.pow(2)).mod(P);
    		 new_y=(r2.pow(2)).mod(P);
    	
if(y.equals(new_x) && y.equals(new_y)){
    			 ModuloInverse m=new ModuloInverse();

                 //2p calculation;  
    	         System.out.println("P1: ("+x+","+r1+") "); // x r2
    			 
    			 BigInteger f1= r1.multiply(new BigInteger("2")); //  2 into yp
    			 order++;	 		 
    			 d=m.inputCode(f1,P);		 	 
    			 alpha = (((x.pow(2)).multiply(new BigInteger("3")).add(a)).multiply(d)).mod(P);

    			 x2P=((alpha.multiply(alpha)).subtract(x.add(x))).mod(P);
    			 y2P=(((x.subtract(x2P)).multiply(alpha)).subtract(r1)).mod(P); 
    			 order++;
    			 System.out.println("P2: ("+x2P+","+y2P+") ");
    			 
    			   prevX=x2P;
    			   prevY=y2P;
    	
    			   
    			  // 3P,4P
    	    while(!(prevX.compareTo(x)==0 && prevY.compareTo(r2)==0)) {    			
    		
    	        	BigInteger f2=x.subtract(prevX);
    	        	
    	        	d1=m.inputCode(f2,P);
    	        	alpha1 =((r1.subtract(prevY)).multiply(d1)).mod(P);
    	        		      	 	        	   	
    	        	
    	        	xnextP=(((alpha1.multiply(alpha1)).subtract(prevX)).subtract(x)).mod(P);
    	        	ynextP=(((x.subtract(xnextP)).multiply(alpha1)).subtract(r1)).mod(P); 
    			
    	        	System.out.println("P"+order+": ("+xnextP+","+ynextP+") ");
    	        	
    	        	prevX=xnextP;
    	        	prevY=ynextP;
    	        	    	        	
    	        	order++;
    	        	
    	       
    		}  //while loop ends
    	    
    	      
        		
        		System.out.println("order : "+order);
        		System.out.println();
     	 
     }
    	}	 //if loop ends
    			 
  }
	

