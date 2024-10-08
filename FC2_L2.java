package minhtran;

import java.util.Scanner;
import java.util.Random;
		//Cac kieu mang trong Mang Java
@SuppressWarnings("unused")
public class FC2_L2 {
	int[]A;
	void nhapmang() {
		@SuppressWarnings("resource")
		Scanner kb=new Scanner(System.in);
		System.out.println("nhap so phan tu mang:");
		int n=kb.nextInt();   A=new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("nhap so thu"+(i+1)+":");
			A[i]=kb.nextInt();
		}
		
	}
	
	// sinh mang tu dong
	void sinhmang(int n) {
		Random rd = new Random(1);
		A = new int[n];
		for(int i=0;i<n;i++)
			A[i]=rd.nextInt();
		
	}
	void inmang() {
		System.out.print("\n Noi dung mang:\n");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		
	}
	void giai1(int x) {
		// sap xep mang
		for(int i=0;i<A.length-1;i++)
			for(int j=i+1;j<A.length;j++)
				if(A[i]>A[j]) { int t=A[i]=A[j];A[j]=t;}
		// so sanh
				int vt=1;
				for(int i=0;i<A.length;i++) if(A[i]<x)vt++;else break;
				System.out.println("\n Vi tri cua x neu nhu o trong day sap xep la:"+vt);
			}
	
		void giai2(int x) {
			int vt=1;
			for(int i=0;i<A.length;i++)
				if(A[i]<x)vt++;
			System.out.println("\n Vi tri cua x neu nhu o trong day xap sep la:"+vt);
		}
		

	public static void main(String[] args) {
		FC2_L2 m= new FC2_L2();
		m.sinhmang(100000);
		//m.inmang();
		m.giai1(15);
		m.giai2(100000000);

		}
	}

	



