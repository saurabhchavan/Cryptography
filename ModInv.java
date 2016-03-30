import java.util.*;
import java.math.*;
public class ModInv {
	final static BigInteger z = new BigInteger("0");
	final static BigInteger ONE = new BigInteger("1");
	
	public static void main(String[] args) {

		BigInteger b,n,bInv;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the value of the base :");
		b=sc.nextBigInteger();
		System.out.println("Please enter the value of the modulo :");
		  n=sc.nextBigInteger();
		 bInv = modInv(b, n);
		
		if (bInv != null) {
		
			System.out.println("The inverse is "+bInv);
		
		}
		else
			System.out.println("There is no inverse");
	}
	
	public static BigInteger modInv(BigInteger value, BigInteger n) {
		BigInteger b0 = value;
		BigInteger n0 = n;
		BigInteger t0 = z;
		BigInteger t = ONE;
		BigInteger q = n.divide(b0);
		BigInteger r = n0.subtract(q.multiply(b0));	
		while (r.compareTo(z) > 0) {			
			BigInteger temp = t0.subtract(q.multiply(t));	
			if (temp.compareTo(z) > 0)
			  temp = temp.mod(n);
			if (temp.compareTo(z) < 0)
			  temp = n.subtract(temp.negate().mod(n));		
			t0 = t;
			t = temp;
			n0 = b0;
			b0 = r;
			q = n0.divide(b0);
			r = n0.subtract(q.multiply(b0));
		}		
		System.out.println("GCD is "+b0);
		if (!b0.equals(ONE))
			return null;		
		else
		 	return t.mod(n);
	}
}