package minhtran;
						// Bai Kieu Mang
import java.util.Scanner;

public class MyArrList {
int []a;
void nhap() { 
	@SuppressWarnings("resource")
	Scanner kb= new Scanner(System.in);
	System.out.print("nhap n:"); int n=kb.nextInt();
	a= new int[n];
	for(int i=0; i<n; i++)
	a[i] = (int) (Math.random()*100);
	}

	void in() { 
		System.out.println("\n Noi dung mang:");
		for(int i=0; i<a.length; i++) System.out.print(a[i]+ " ");
	}
	void chen(int x, int k) {
		int i=0,n= a.length;
		if(k<1|| k >n+1) System.out.print("\n vi tri chen ko hop le!");
		else {
		int []b; b= new int[n+1];
		for( i=0; i<k-1; i++) b[i]=a[i]; // mau xanh
		for(i=n; i>k-1; i--) b[i] =a[i-1]; // mau do
		b[k-1]=x; // bo gia tri x vao vi tri k
		a= b;
			}
	}
		void xoa(int k) {
			int i=0,n= a.length;
			if(k<1|| k >n) System.out.println("\n vi tri xoa ko hop le!");
			else {
			int []b; b= new int[n-1];
			for( i=0; i<k-1; i++) b[i]=a[i]; // mau xanh
			for( i=k-1; i<n-1; i++) b[i]=a[i+1]; // mau xanh
			a= b;
			}
			
		}
		int demle()
		{
		int d=0;
		for(int i=0; i<a.length; i++)
		if(a[i]%2!=0) d++;
		return d;
		
			}
		void xoaam()
			{
		int k=0;
		for(int i=0; i<a.length; i++) if(a[i]>=0) k++;
		int []b=new int[k];
		int j=0;
		for(int i=0; i<a.length; i++)
		if(a[i]>=0) b[j++]= a[i];
		a=b;
		
			}
		void xoay(int k)
			{
		for(int i=1; i<=k; i++)
			{
		int x=a[0];
		xoa(1);
		chen(x, a.length+1);
			}
		}
		void rev (int ll, int rr)
			{
		int i=ll-1, j=rr-1;
		while(i<j)
			{
		int t= a[i]; a[i]=a[j]; a[j]=t;
		i++; j--;
			}
		}
		void xoay1(int k)
		{
		rev(1, k); // O(k)
		rev(k+1, a.length); //O(n-k);
		rev(1, a.length); // O(n)
		}
		boolean tang()
		{
		int i=0;
		while(i<a.length-1 && a[i]<a[i+1]) i++;
		if(i<a.length-1) return false;
		return true;
		}
		
	
	
	public static void main(String[] args) {
		MyArrList m=new MyArrList();
		m.nhap(); m.in();
		m.chen(99, 5); m.in();
		m.xoa(5); m.in();
	}
}
