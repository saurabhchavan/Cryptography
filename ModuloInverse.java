/*
 * @author Saurabh Chavan
 * @version 2.0
 * @name ModuloInverse
 * @date 5.13.2015
 */

package chinmay;
import java.math.*;

public class ModuloInverse  {
	
	
	private static final BigInteger non = new BigInteger("0");
	
	public BigInteger []cal=new BigInteger[1000];
	

	public BigInteger modulo(BigInteger x,BigInteger y){
		
		
		return x.mod(y);
		
	}
	
	public BigInteger quotient(BigInteger f,BigInteger g){
		
		return f.divide(g);
		
	}
	
	public BigInteger modInverseCalc(BigInteger []b,int len){
		
		int i=len-1;
		int j=len-2;
		int z=3;
		
		cal[len-1]=new BigInteger("0");
		cal[len-2]=new BigInteger("1");
		
		
		while(j != 0){
			
			cal[len-z]=cal[i].add(cal[j].multiply(b[j]));
			i--;
			j--;
			z++;
		}
		
		return cal[j];
			
	}
	
	public BigInteger inverseEO(int len,BigInteger numb,BigInteger P){
		
		if(len%2==0){ //for even
			
			return numb;
		}
		else{  //for odd
			
			return numb=P.subtract(numb);
	
		}
		
	}
	
	//public static void main(String[] args)  {
		
	public BigInteger inputCode(BigInteger x,BigInteger y){
		
		//Scanner s=new Scanner(System.in);
		
		int i,j,length1;
		BigInteger a,P,marray[],qarray[];
		i=2;
		j=1;
		BigInteger modInverse,Ptemp;
		boolean negFlag=false;
		
		 ModuloInverse m=new ModuloInverse();
		 //System.out.println("Enter the value of a and P");
         a=x;
         P=y;        
         Ptemp=P;
         marray=new BigInteger[1000];
         qarray=new BigInteger[1000];
         
         int res2=a.compareTo(BigInteger.ZERO);
         
         if(res2 == -1){
        	 
        	 a= a.multiply(new BigInteger("-1"));
        	 negFlag=true;
         }
         
         marray[0]=P;
         marray[1]=a;
         qarray[0]=non;
         
         BigInteger flag=new BigInteger("1");
         int res = a.compareTo(flag);
        
         
        while(res == 1){
        	
        	marray[i]=m.modulo(P,a);
        	qarray[j]=m.quotient(P,a);
        	P=a;
            a=marray[i];
            i++;
            j++;
            res = a.compareTo(flag);
         }
        
        qarray[j+1]=non;
        length1=i;    //length of marray
        modInverse=m.modInverseCalc(qarray,length1);

        
        if(negFlag){
        return ((m.inverseEO(length1,modInverse,Ptemp)).negate());
        
        }
        else{        	
        return m.inverseEO(length1,modInverse,Ptemp);
        }

	}
	
/*	public static void main(String[] args){
		
		ModuloInverse m=new ModuloInverse();
		BigInteger a=new BigInteger("58");
		BigInteger P=new BigInteger("77");
		//m.inputCode(a,P);
		System.out.println(m.inputCode(a,P));
		
	}
*/
	
}
