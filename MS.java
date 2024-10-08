package Mystack;
			//danh sach dat

import java.util.Scanner;

class Node{

	int data;
	Node next;
	Node(int x){
		data=x;
		next=null;
	}
	Node(int x,Node t){
		data=x;
		next=t;
	}
	public String toString() {
		return data+" ";
	}

	
		
	}
	

public class MS {
	Node top;
	void Push(int x)
	
	{top=new Node(x,top);}
   void nhap() {
	   int x;
	   @SuppressWarnings("resource")
	Scanner kb=new Scanner(System.in);
	   while(true) {
		   System.out.print("\n nhap 1 so<>0 de them vao NX: ");
		   x=kb.nextInt();
		   if(x==0)break;
		   Push(x);
	   }
	   System.out.print("\n da them xong");
   }
   void in() {}

	public static void main(String[] args) {
		
        MS s=new MS();
        s.nhap();
        s.in();
	}
}
