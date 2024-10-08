import java.util.Scanner;

class TNode{
    int data;
    TNode left, right;
    TNode(int x) {data=x;left=right=null;}
    TNode(int x, TNode ll, TNode rr)
    {
        data=x;left=ll;right=rr;
    }
}

public class MyBST {
    TNode root; 
    TNode insertBST(int x, TNode T){
        if(T==null) T=new TNode(x);
        else if(x==T.data) System.out.print("da co"+x+"trong cay\n");
        else if(x<T.data) T.left = insertBST(x,T.left);
        else T.right = insertBST(x,T.right);
        return T;
    }   
    void insertBST(int x) {root = insertBST(x,root);}
        
    void nhapcayBST(){
        root = null;
        @SuppressWarnings("resource")
        Scanner kb = new Scanner(System.in); int x = 0;
        while(true){
            System.out.print("nhap x <>0: "); x= kb.nextInt();
            if(x==0) break;
            insertBST(x);
        }
    }
    void trungTu(TNode T){
        if(T!=null){
            trungTu(T.left);
            System.out.println(" "+T.data);
            trungTu(T.right);
        }

    }
    void duyetTrungtu(){
        System.out.print("trung tu: ");trungTu(root);
    }
    boolean timBST(int x, TNode T){
        if(T==null) return false;
        else if(T.data==x) return true;
        else if(x<T.data) return timBST(x, T.left);
        else return timBST(x, T.right);
    }
    boolean search(int x) {return timBST(x, root);}

    public static void main(String[] args){
        MyBST T = new MyBST();
        T.nhapcayBST();
        T.duyetTrungtu();
        T.insertBST(5);

    }
}