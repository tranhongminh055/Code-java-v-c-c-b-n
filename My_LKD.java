package minhtran;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	Node(int x) {data=x; next = null;}
	Node(int x, Node t) {data=x; next = t;}
	public String toString() { return data + "-->";}
	
}

public class My_LKD {
	Node head;
	void nhap() {
		
		head = null;
		Node cuoi = null;
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in); int x;
		while(true) {
			System.out.println("Nhap so x (x>0) : "); x=kb.nextInt();
			if (x<=0) break;
			Node t= new Node(x);
			if (head==null) head = cuoi = t;
			else {cuoi.next=t; cuoi=t;}
		}
	}
	
	int dl() {
		int k=0;
		Node p=head; while(p!=null) {if (p.data%2!=0) k++; p=p.next;}
		return k;
		
		}
		int dem() {
			int k=0;
			Node p= head;
			while(p!=null) {k++; p=p.next;}
			return k;
			
		}
		int tong() {
			int k=0;
			Node p= head;
			while(p!=null) {k=k+p.data;p=p.next;}
			return k;
			
		}
		int max() {
			int k;
			if(head==null) k=0;else k=head.data;
			Node p=head;
			while(p!=null) {if(k<p.data)k=p.data;p=p.next;}
			return k;
			
		}
		void in() {
			System.out.print("\n Noi dung danh sach:\n\t ===>");
			Node p= head; while(p!=null) {System.out.print(p); p=p.next;}
			System.out.println("null");
			
		}
		void append(int x) {
			Node t=new Node(x);
			if(head==null)head=t;
			else
			{
				Node p=head;while(p.next!=null)p=p.next;
				p.next=t;
			}
		}

	public static void main(String[] args) {
		My_LKD L = new My_LKD(); L.nhap(); L.in();
		System.out.println("\n So phan tu le trong danh sach la:" + L.dl());
		System.out.println("\n So not trong danh sach la:" + L.dem());
		System.out.println("\n Tong cac phan tu trong danh sach la:" + L.tong());
		System.out.println("\n So lon nhat trong danh sach la:" + L.max());
		
		

	}

}
