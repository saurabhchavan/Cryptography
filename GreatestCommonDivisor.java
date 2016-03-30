import java.util.*;
import java.math.*;
public class GreatestCommonDivisor{
public static long Gcd(Long c1, Long c2)
{
   return BigInteger.valueOf(c1).gcd(BigInteger.valueOf(c2)).longValue();
}
public static void main(String args[]) 
{
	   Long s,s1,s2;
	   @SuppressWarnings("resource")
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Please enter the first number :");
	   s1 = sc.nextLong();
	   System.out.println("Please enter the second number :");
	   s2 = sc.nextLong();
	   s= Gcd(s1,s2);
	   System.out.println("Prime factors of number are:"+s);
}
}