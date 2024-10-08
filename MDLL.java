package minhtran;
				DSLK DOI
import java.util.Scanner;

import minhtran.DNode.MDLL;

class DNode{
	int data;
	DNode prev, next;
	DNode(int x) {data=x; prev=next=null;}
	DNode(int x, DNode t, DNode s){
		data=x; prev=t; next=s;
		if (t!=null) t.next=this;
		if(s!=null) s.prev=this;
		
}
	// phuong thuc String toString
	public String toString() {
		return "<---"+data+"--->";
		
		
	}
public class MDLL {

	DNode head,tail;
		
	void nhap() {
		Scanner kb= new Scanner(System.in);
		int x; head=tail=null;
		while(true)
		{
		
			System.out.print("nhap so x(<>0) them vao danh sach: ");
			x=kb.nextInt();
			if(x<=0) break;
			if(head==null) head=tail=new DNode(x);
			else {tail.next = new DNode(x, tail, null); tail=tail.next;}
		
		}
	}
	void innguoc() {
		DNode p = tail;
		System.out.println("\n In danh sach theo chieu nguoc:\n ");
		while(p!=null) {System.out.print(p); p=p.prev;}
	}
	


	void in() {
		DNode p=head;
		System.out.println("Noi dung danh sach doi");
		while (p!=null) {System.out.print(p); p=p.next;}
	}
	void xoad() {
		if(head==null)
			System.out.print("\n danh sach rong khong xoa duoc:\n");
		else if(head==tail)head=tail=null;
		else {head=head.next; head.prev=null;}
	}
	void xoac() {
		if(head==null)
			System.out.print("danh sach rong khong xoa duoc");
		else if(head==tail)head=tail=null;
		else {tail=tail.prev; tail.next=null;}
	}
	int tong() {
		int k=0;
		DNode p=head;
		while(p!=null) {k=k+p.data;p=p.next;}
		return k;
	}
	
	public static void main(String[] args) {
		MDLL LL = new MDLL();
		LL.nhap();
		LL.in();
		LL.innguoc();
		LL.xoad();
		LL.xoac();
		
		
		System.out.println("\n Tong cac not= "+ LL.tong());
		System.out.print("\n XONG");
	}

	}






