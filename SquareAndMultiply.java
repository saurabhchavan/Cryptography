import java.util.*;
import java.math.*;

class SquarenMultiply
{
@SuppressWarnings("deprecation")
public static void main(String args[])
{
	BigInteger b,e,p,a;
	Scanner sc=new Scanner(System.in);

System.out.println("Please enter the value of the base :");
b=sc.nextBigInteger();

System.out.println("Please enter the value of the exponent :");
e=sc.nextBigInteger();

System.out.println("Please enter the value of the p :");
p=sc.nextBigInteger();

System.out.println("Output of Square and Multiply :"+SquareAndMultiply(b,e,p));

}

public static BigInteger SquareAndMultiply(BigInteger b,BigInteger e,BigInteger p)
{
BigInteger var2= new BigInteger("2");
BigInteger var1= new BigInteger("1");

if(e.compareTo(var1)==0)
{
BigInteger res;
res=b.mod(p);
return res;
}
else
{
List<BigInteger> mList = new ArrayList<BigInteger>();
List<BigInteger> bList = new ArrayList<BigInteger>();



mList.add(e);
bList.add(e.mod(var2)); BigInteger b1;

while(true)
{
e=e.divide(var2);
b1=e.mod(var2);
bList.add(b1);
mList.add(e);

if(e.compareTo(var1)==0){break;}
}
System.out.println("M List"+mList);
System.out.println("B List"+bList);


int size=mList.size();

BigInteger uArr[]=new BigInteger[size];

uArr[0]=b;
for(int i=1;i<size;i++)
{
b=(b.pow(2)).mod(p);
 uArr[i]=b;
}

BigInteger aArr[]=new BigInteger[size];
BigInteger bArr[] =bList.toArray(new BigInteger[bList.size()]);
if(bArr[0].compareTo(var1)==0){aArr[0]=uArr[0];}
else aArr[0]=var1;

for(int i=1;i<size;i++)
{
if(bArr[i].compareTo(var1)==0)
aArr[i]=(aArr[i-1].multiply(uArr[i])).mod(p);

else 
aArr[i]=aArr[i-1];
}

return(aArr[size-1]);

}
}
}

