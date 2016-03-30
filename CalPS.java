/*
 * @author Saurabh Chavan
 * @version 2.0
 * @name ECC table
 * @date 5.13.2015
 */

package saurabh;
import java.math.*;

public class CalPS extends ModuloInverse{

	BigInteger y,a,b,P,r1,r2,new_x,new_y,d,d1,alpha,alpha1,x2P,y2P,xnextP,ynextP,x,prevX,prevY,j,temp,f1;
	int exponent;
	int order=1;
	int count=0;

	public void computePoints(BigInteger a,BigInteger b,BigInteger P){
    	
    	int p = P.intValue();
    	exponent=(p+1)/4;  
    	
start:  for(x=BigInteger.ZERO;(x.intValue())<p;x=x.add(new BigInteger("1"))){
    		
	      		
    		 y=(((x.pow(3)).add(a.multiply(x))).add(b)).mod(P);
    		 r1=(y.pow(exponent)).mod(P);
    	     r2=(P.subtract(r1)).mod(P);    		 
    		 new_x=(r1.pow(2)).mod(P);
    		 new_y=(r2.pow(2)).mod(P);
    		 temp=r1;
    		   	
    		 if(y.equals(new_x) && y.equals(new_y)){
    		     			 ModuloInverse m=new ModuloInverse();

    		                  //2p calculation;  
    		     	         System.out.print("P1: ("+x+","+r1+") "); // x r2
    		     			 
    		     			 f1= r1.multiply(new BigInteger("2")); //  2 into yp
    		     			 order++;	 		 
    		     			 d=m.inputCode(f1,P);		 	 
    		     			 alpha = (((x.pow(2)).multiply(new BigInteger("3")).add(a)).multiply(d)).mod(P);

    		     			 x2P=((alpha.multiply(alpha)).subtract(x.add(x))).mod(P);
    		     			 y2P=(((x.subtract(x2P)).multiply(alpha)).subtract(r1)).mod(P); 
    		     			 order++;
    		     			 System.out.print(" P2: ("+x2P+","+y2P+") ");
    		     			 
    		     			   prevX=x2P;
    		     			   prevY=y2P;
    		     	
    		     			   
    		     			  // 3P,4P
    		     	    while(!(prevX.compareTo(x)==0 && prevY.compareTo(r2)==0)) {    			
    		     		
    		     	        	BigInteger f2=x.subtract(prevX);
    		     	        	
    		     	        	d1=m.inputCode(f2,P);
    		     	        	alpha1 =((r1.subtract(prevY)).multiply(d1)).mod(P);
    		     	        		      	 	        	   	
    		     	        	
    		     	        	xnextP=(((alpha1.multiply(alpha1)).subtract(prevX)).subtract(x)).mod(P);
    		     	        	ynextP=(((x.subtract(xnextP)).multiply(alpha1)).subtract(r1)).mod(P); 
    		     			
    		     	        	System.out.print("  P"+order+": ("+xnextP+","+ynextP+") ");
    		     	        	
    		     	        	prevX=xnextP;
    		     	        	prevY=ynextP;
    		     	        	    	       
    		     	        	order++;
    		     	        	
    		     	       
    		     		}  //while loop ends
    		     	    
    		     	      
    		         		
    		         		System.out.print(" order : "+order);
    		         		order=1;
    		         		System.out.println();
    		         		
    		         		//for result2
    		         		
    		         	r1=r2;	
    		         	r2=temp;
    		         	
  		                  //2p calculation;  
  		     	         System.out.print("P1: ("+x+","+r1+") "); // x r2
  		     			 
  		     			 f1= r1.multiply(new BigInteger("2")); //  2 into yp
  		     			 order++;	 		 
  		     			 d=m.inputCode(f1,P);		 	 
  		     			 alpha = (((x.pow(2)).multiply(new BigInteger("3")).add(a)).multiply(d)).mod(P);

  		     			 x2P=((alpha.multiply(alpha)).subtract(x.add(x))).mod(P);
  		     			 y2P=(((x.subtract(x2P)).multiply(alpha)).subtract(r1)).mod(P); 
  		     			 order++;
  		     			 System.out.print(" P2: ("+x2P+","+y2P+") ");
  		     			 
  		     			   prevX=x2P;
  		     			   prevY=y2P;
  		     	
  		     			   
  		     			  // 3P,4P
  		     	    while(!(prevX.compareTo(x)==0 && prevY.compareTo(r2)==0)) {    			
  		     		
  		     	        	BigInteger f2=x.subtract(prevX);
  		     	        	
  		     	        	d1=m.inputCode(f2,P);
  		     	        	alpha1 =((r1.subtract(prevY)).multiply(d1)).mod(P);
  		     	        		      	 	        	   	
  		     	        	
  		     	        	xnextP=(((alpha1.multiply(alpha1)).subtract(prevX)).subtract(x)).mod(P);
  		     	        	ynextP=(((x.subtract(xnextP)).multiply(alpha1)).subtract(r1)).mod(P); 
  		     			
  		     	        	System.out.print("  P"+order+": ("+xnextP+","+ynextP+") ");
  		     	        	
  		     	        	prevX=xnextP;
  		     	        	prevY=ynextP;
  		     	        	    	        	
  		     	        	order++;
  		     	        	
  		     	       
  		     		}
  		     	    
  		     	            System.out.print(" order : "+order);
	         		        order=1;
	         	         	System.out.println();
	         	         	continue start;
    		      	 
    		      }
    			 
    	}
 }
    
    
    public static void main(String[] args){
    	
    	//Scanner src =new Scanner()
    	CalPS cp=new CalPS();
    	                    
    	                       //a                     //b             //P
      	cp.computePoints(new BigInteger("2"),new BigInteger("9"),new BigInteger("23"));
    	
    	
    }
	
	
	
}
