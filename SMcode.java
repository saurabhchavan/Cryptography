import java.util.Scanner;
import java.math.*;


public class SMcode {
	
	public int i=0;
    public int j,res,res1,res2;
    public BigInteger u,P,m,saved_val;
	
    
    public BigInteger []marray=new BigInteger[1000];
    public BigInteger []barray=new BigInteger[1000];
    public BigInteger []uarray=new BigInteger[1000];
    public BigInteger []Aarray=new BigInteger[1000];
	
	
	public void computeSM(BigInteger u,BigInteger P,BigInteger m){
		
		marray[0]=m;
		barray[0]=m.mod(new BigInteger("2"));
		uarray[0]=u;
		Aarray[0]=new BigInteger("1");
		
		BigInteger flag=new BigInteger("1");
        res = marray[i].compareTo(flag); //res is 0 when both bigint same
				
		while(res != 0){
			
			
			marray[i+1]=(marray[i].subtract(barray[i])).divide(new BigInteger("2"));
			
			barray[i+1]=marray[i+1].mod(new BigInteger("2"));
			
			BigInteger s=uarray[i].multiply(uarray[i]);
			uarray[i+1]=s.mod(P);
			
			
			
			
			if(i==0){
				
				BigInteger flag1=new BigInteger("0");
				int res1=barray[0].compareTo(flag1);
				
				if(res1 != 0){
					
				Aarray[0]=(uarray[0]).mod(P);
				
				}	
			}
			
			BigInteger flag2=new BigInteger("0");
			res2=barray[i+1].compareTo(flag2);
			
			
			
			if(res2==0){
				
				Aarray[i+1]=Aarray[i];
			}
			else{
			
				Aarray[i+1]=(Aarray[i].multiply(uarray[i+1])).mod(P);
			
			}
		
			
			i++;
			res=marray[i].compareTo(flag);
		    
	}
		j=i;
		System.out.println("The value for "+u+"^"+m+"mod"+P+" = "+Aarray[i]);
		
		System.out.println("The value for M is = "+uarray[i]);
		
		System.out.print("The binary value for "+m+" is = ");
		
		saved_val=Aarray[i];
		
		while(j >= 0){
			
			System.out.print(barray[j]);
			j--;
		}
	}
	
	
	public static void main(String[] args) {
				
		BigInteger u,P,m;
	    SMcode sq=new SMcode();
	    
	    u=new BigInteger("8291982323");
		P=new BigInteger("11006947387");
		m=new BigInteger("7337825040");
		
		sq.computeSM(u,P,m);		
		
		
		
    }
}	


