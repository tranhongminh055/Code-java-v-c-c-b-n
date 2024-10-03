package Mystack;

import java.util.Random;
import java.util.Scanner;

public class manghaichieu {
	int [][]a; int m,n;//m là số hàng n là số cột
	void nhap() {
		try (Scanner kb = new Scanner(System.in))
        {
			System.out.println("Nhap so hang:"); m=kb.nextInt();
			System.out.println("Nhap so cot:"); n=kb.nextInt();
		}
		a=new int[m][n]; Random rd = new Random();
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=rd.nextInt(1000);
	}
	void in() {
		for(int i=0;i<m;i++)
		{
			System.out.println("\n");
			for(int j=0;j<n;j++)
				//system.out.println(" " + a [i][j]);
				System.out.format("%5d",a[i][j]);
		}
	}
	void maxdong() {
		for(int i=0;i<m;i++)
		{
			int md=a[i][0];
			for(int j=1;j<n;j++)
				if(a[i][j]>md)
					md= a[i][j];
			System.out.print("\n max dong"+i+"="+md);
		}
	}
	void TB_LE()
	{
		for (int j=0;j<n;j++)
		{
			double d=0,s=0;
			for (int i=0;i<m;i++)
				if(a[i][j] %2!=0) {d++;s+=a[i][j];}
		if(d==0) System.out.println("\n TB le cot"+j+"=0");
		else System.out.println("\n TB le cot "+j+"=" +s/d);
			}
	}
	void xoay()
	{
		for(int i=0;i<m;i++)
		{
			int l=0,r = n-1;
			while(l<r) {int t = a[i][l];a[i][l]=a[i][r];
			a[i][r]=t;l++;r--;
			}
		}
	}
	public static void main (String[] args) {
		manghaichieu m= new manghaichieu();
		m.nhap();m.in();
		m.maxdong();m.in();
		m.TB_LE();m.in();
		m.xoay();m.in();
	System.out.print("\n XONG!");
	}
}