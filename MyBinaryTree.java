package Mystack;
            // chuong trinh dem cay
class TNode{
    int data;
TNode left;
TNode right;

TNode (int x) { data= x; left =right = null;}
TNode (int x, TNode ll, TNode rr)
{
data= x; left =ll; right = rr;
}
}

public class MyBinaryTree {
TNode root;

void taocayT(){
    TNode A = new TNode(7, new TNode(2), new TNode(6));
    TNode B = new TNode(5, null,new TNode(9));
    root = new TNode(5, A, B);
}
void taocayT1(){
  
    TNode A = new TNode(7,new TNode(1), new TNode(6));
    TNode B = new TNode(1,null,new TNode(8));
    root=new TNode(1,A,B);
}

void duyet1(TNode T){
if(T!=null){
    System.out.print("tien tu: "+T.data);
    duyet1(T.left);
    duyet1(T.right);
}
}
void duyettientu(){duyet1(root);}


void duyet2(TNode T) {
    if(T!= null) {
    System.out.println("trung tu: " + T.data);
    duyet2(T.right);
    duyet2(T.left);
    }
    }
    void duyettrungtu() { duyet2(root); }

    void duyet3(TNode T){
        if(T!= null){
            System.out.println("hau tu: " + T.data);
            duyet3(T.left);
            duyet3(T.right);
        }
    }
    void duyethautu(){duyet3(root);}

    int tong(TNode T){
        if(T==null) return 0;
        else return T.data + tong(T.left) + tong(T.right);
    }
    int tongnot() {return tong(root);}

    int sumLeTree(TNode root){
        if(root==null) {
        	return 0;
        }
        
        	int sum = 0;
        if(root.data%2!=0){
            sum= root.data;
        }
        return sum+ sumLeTree(root.left)+ sumLeTree(root.left);
        
    }
    int insumLeTree() {return sumLeTree(root);}
   
public static void main(String[] args) {
    MyBinaryTree T= new MyBinaryTree();
T.taocayT();
T.duyettientu();
T.duyettrungtu();
T.duyethautu();
T.tongnot();

System.out.println("\n So not trong cay la: " + T.tongnot());
System.out.println("\n So not le trong cay la:" + T.sumLeTree(T.root));
    System.out.println("xong");
}
    
}
