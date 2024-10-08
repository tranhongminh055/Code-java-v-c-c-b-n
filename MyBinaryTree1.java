package minhtran;
                //dem phan tu cay
class TNode{
    int data;
    TNode left, right;

    TNode(int x){
        data = x;
        left = right = null;
    }

    TNode(int x, TNode ll, TNode rr){
        data = x;
        left = ll;
        right = rr;

    }
}

public class MyBinaryTree1 {
        TNode root;
        
        void taocayT3(){
            TNode a = new TNode(2, new TNode(8, null, new TNode(6)), new TNode(7));
            TNode b = new TNode(5, new TNode(4), a);
            TNode c= new TNode(1, null, new TNode(9, new TNode(0), null));
            root = new TNode(3, b, c);
        }
    
        void inla(TNode T){
            if (T != null)
            if (T.left == null && T.right == null)
                System.out.print(" "+ T.data);
                else{
                    inla(T.left);
                    inla(T.right);
                }
           }
        void inla(){
            System.out.println("\n Cac not trong cay: ");
            inla(root);
         }
        int tongn(TNode T){
            if (T == null || (T.left == null && T.right == null))
                return 0;
                else {
                    // System.out.prin(" " + T.data);
                    return T.data + tongn(T.left) + tongn(T.right);
                }
          }
        void tongnottrong(){
            System.out.println("\n tong cac not trong (inner): " + tongn(root));
            }
        int tong1c(TNode T){
            if(T==null) return 0;
            else
                if(T.left == null && T.right != null)
                    return T.data + tong1c(T.right);
            else
                if(T.left != null && T.right == null)
                    return T.data + tong1c(T.left);
            else return tong1c(T.right) + tong1c(T.left);
            }
            void tong1con(){
                System.out.println("Tong cac not 1 con = "+tong1c(root));
            }
            int cao(TNode T){
                if(T==null) return 0;
                else return 1 + Math.max(cao(T.left), cao(T.right));
            }
            void cao(){
                System.out.println("\n chieu cao cay la "+ cao(root));
            }
            int sn(TNode T){
                if(T==null) return 0;
                else return 1 + sn(T.left) + sn(T.right);
            }
            void sn(){
                System.out.println("\n so not trong cay la " + sn(root));
            }
            boolean timx(int x, TNode T){
                if(T==null) return false;
                else
                    if(T.data==x) return true;
                    else
                        if(timx(x, T.left)==false) return timx(x, T.right);
                        else return true;
            }
            void timx(int x){
                if(timx(x, root)) System.out.println("\n co x trong cay");
                else System.out.println("\n KHONG CO X TRONG CAY");
            }
            public static void main(String[] args){
                MyBinaryTree1 T = new MyBinaryTree1();
                T.taocayT3();
                T.inla();
                T.tongnottrong();
                T.tong1con();
                T.cao();
                T.sn();
                int x = 5;
                T.timx(x);
            }
        }
    


