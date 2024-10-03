package Mystack;

import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node (int x){
        data = x;
        next = null;
    }

    Node(int x, Node t){
        data = x;
        next = t;
    }
    public String toString(){
        return data + "-->";
    }

}
    public class dslk{
        Node head;

        void nhapds(){
            int x;
            Node cuoi = null;
            head = null;
            @SuppressWarnings("resource")
            Scanner kb = new Scanner(System.in);
            while(true){
                System.out.print("\n Nhap so x (x>0): ");
                x = kb.nextInt(); if(x<=0) break;
                Node t = new Node(x);
                if(head==null) head = cuoi = t; else {cuoi.next=t;cuoi=t;}

            }
        }
        int tongds(Node L){
            if(L==null) return 0;
            else return L.data+tongds(L.next);
        }
        int tongds_dq() {return tongds(head);
        }
        int dem(Node L){
            int k=0;
            Node p= head;
            while(p!=null){k++; p=p.next;}
            return k;
        }
        int dem_dq(){
            return dem(head);
        }
        void in(){
            System.out.print("\n Noi dung danh sach: \n\t===>");
            Node p = head; while(p!=null) {System.out.print(p);
                p=p.next;
            }
            System.out.println("null\n");
        }
        void incuoi(Node L){
            if(L==null) System.out.print("danh sach rong");
            else if(L.next==null) System.out.print(L.data);
            else incuoi(L.next);
        }
        void incuoi_dq() {incuoi(head);}
    
        int demle(Node L){
            if(L==null) return 0;
            else if(L.data%2!=0) return 1 + demle(L.next);
            else return demle(L.next);
        }
        int demle_dq() {return demle(head);}

        public static void main(String[] args){
            dslk L = new dslk();
            L.nhapds();
            L.in();
            System.out.print("\n So not trong danh sach la: "+L.dem_dq());
            System.out.print("\n Not cuoi trong danh sach la:");
            L.incuoi_dq();
            System.out.print("\n Tong cac phan tu trong danh sach la: "+L.tongds_dq());
            System.out.print("\n Tong so not le trong danh sach la: "+L.demle_dq());
            System.out.print("\n XONG!!!"); 
            }
        }
