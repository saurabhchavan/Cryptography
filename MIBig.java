
import java.util.Scanner;
import java.math.*;

public class MIBig  {
	
	
	private static final BigInteger non = new BigInteger("0");
	
	public BigInteger []cal=new BigInteger[100];
	

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
	
	public static void main(String[] args)  {
		
		
		Scanner s=new Scanner(System.in);
		
		int i,j,length1;
		BigInteger a,P,marray[],temp,qarray[];
		i=2;
		j=1;
		BigInteger modInverse,Ptemp,atemp;
		
		 MIBig m=new MIBig();
		 //System.out.println("Enter the value of a and P");
         a=new BigInteger(args[0]);
         P=new BigInteger(args[1]);        
         Ptemp=P;
         atemp=a;
         marray=new BigInteger[100];
         qarray=new BigInteger[100];
         
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
        System.out.println(Ptemp);
        modInverse=m.modInverseCalc(qarray,length1);
        System.out.println("a = "+atemp);
        System.out.println("P = "+Ptemp);
        System.out.println(atemp +"^(-1)mod"+Ptemp+" = "+m.inverseEO(length1,modInverse,Ptemp));


	}

}
