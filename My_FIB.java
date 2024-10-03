package minhtran;

import java.math.BigInteger;
public class My_FIB {
	long fib(int n) {
		
	if(n==0|| n==1) return 1;
	else return fib(n-1)+fib(n-2);
}
	long fib1(int n) 
	{
		long[]f;
		f=new long[n+1];
		f[0]=f[1]=1;
		for(int i=2;i<=n;i++) f[i] =f[i-1]+f[i-2];
		return f[n];
	}
	BigInteger fib3(int n) {
		BigInteger f0,f1,f2;
		f0=BigInteger.ONE; f1 = BigInteger.ONE;
		for(int i=2;i<=n;i++) { f2=f1.add(f0);f0=f1; f1=f2;}
		return f1;
	}




	public static void main(String[] args) {
		My_FIB m=new My_FIB(); int n = 180;
		System.out.print("\n So tho tren dao thang thu"+n+"="+m.fib1(n));
	
		

	}

	}
