import java.math.*;
import java.util.Scanner;


public class SquareAMultiply {
	@SuppressWarnings("resource")
	public static BigInteger modExp(BigInteger base, BigInteger exp, BigInteger num) {
		
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		BigInteger two = one.add(one);	
		if (exp.equals(zero))
			return one;
		if (exp.equals(one))
			return base.mod(num);
			
		if (exp.mod(two).equals(zero)) {
			
			BigInteger ans = modExp(base, exp.divide(two), num);
			
				return (ans.multiply(ans)).mod(num);
		}	
			return (base.multiply(modExp(base,exp.subtract(one),num))).mod(num);
	}
	
	public static void main(String args[])
	{
		BigInteger b,e,n;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	System.out.println("Please enter the value of the base :");
	b=sc.nextBigInteger();
	System.out.println("Please enter the value of the exponent :");
	e=sc.nextBigInteger();
	System.out.println("Please enter the value of the p :");
	n=sc.nextBigInteger();
	System.out.println("Output of Square and Multiply :"+modExp(b,e,n));
				
	}
}
