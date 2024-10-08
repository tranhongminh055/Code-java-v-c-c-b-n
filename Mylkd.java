package Mystack;
import java.util.Scanner;
				danh sach lien ket 
import org.w3c.dom.Node;

@SuppressWarnings("unused")
class node {
	int data;
	node next;

	node(int x) {
		data = x;
		next = null;
	}

	node(int x, node t) {
		data = x;
		next = t;
	}

	public String toString() {
		String t = " " + data + "-->";
		return t;
	}
}



public class Mylkd {
	node head;

	// NHAP DANH SACH LIEN KET
	void nhap() {
		head = null;
		node cuoi = null;
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		int x;
		while (true) {
			System.out.println("Nhap so x (x>0): ");
			x = kb.nextInt();
			if (x <= 0)
				break;
			node t = new node(x);
			if (head == null)
				head = cuoi = t;
			else {
				cuoi.next = t;
				cuoi = t;
			}
		}
	}

	// IN DANH SACH LIEN KET 
	void in() {
		System.out.print("\n Noi dung danh sach ==> ");
		node p = head;
		while (p != null) {
			System.out.print(p);
			p = p.next;
		}
		System.out.println("null");
	}
	void xoak(int k) {
		if(k<1||head==null) 
			System.out.print("\n Danh sach rong, khong xoa duoc");
		else if(k==1)head=head.next;
		else {
			int vt=1;node p=head;
			while (p!=null && vt<k-1) {vt++;p=p.next;}
			if(p==null||p.next==null)
				System.out.println("\nvi tri xoa khong hop le!");
			else p.next=p.next.next;
		}
		
	}

	// TINH TONG CAC PHAN TU TRONG DANH SACH
	int tong() {
		int k = 0;
		node p = head;
		while (p != null) {
			k = k + p.data;
			p = p.next;
		}
		return k;
	}

	// IN NOT THU k TRONG DANH SACH
	void ink(int k) {
		node p = head;
		int vt = 1;
		while (p != null && vt < k) {
			vt++;
			p = p.next;
		}
		if (p == null)
			System.out.print("Danh sach khong du phan tu");
		else
			System.out.print(p.data);
	}
	

	// HAM MAIN
	public static void main(String[] args) {
		Mylkd L = new Mylkd();
		L.nhap();
		L.in();
		System.out.print("\n Tong so cac phan tu trong danh sach la: " + L.tong());
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.print("\n Nhap so k (k>1): ");
		int k = kb.nextInt();
		System.out.print("\n Node thu " + k + " trong danh sach: ");
		L.ink(k);
		System.out.print("\n Nhap so bat ki de xoa khoi danh sach");
		int k1 = kb.nextInt();
		System.out.print("\n Danh sach rong, khong xoa duoc");
		L.xoak(k1);
		System.out.println("\nvi tri xoa khong hop le!");
		@SuppressWarnings("unused")
		int y = kb.nextInt();
		L.in();
		
	}
}

