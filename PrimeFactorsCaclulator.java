import java.util.*;

public class PrimeFactorsCaclulator{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Integer> primeFactorsCalculator(int num) {
        int i,temp = num;
        List <Integer> factors = new ArrayList<Integer>();
        for (i = 2; i <= temp; i++) {
            if (temp % i == 0) {
                temp=temp/i;
                factors.add(i);     
                i--;
            }
        }
        return factors;
    }
    public static void main(String args[]) {
    	@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
    	System.out.print("Please enter the number to calculate factors :");
    	int n=sc.nextInt();
    	System.out.printf("Prime factors of number "+n +" are : " + primeFactorsCalculator(n-1));
    }
}