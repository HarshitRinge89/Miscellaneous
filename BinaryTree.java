import java.util.Scanner;

class Node{
    int data;Node left,right;
    public Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class BinaryTree {
    Node root;
    public BinaryTree() {
        root = null;
    }
    public void insert(int data){
        root=insertRec(root,data);
    }
    private Node insertRec(Node root,int data){
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }
    public void show(){
        System.out.println("The Tree with sorted values: ");
        showRec(root);
    }
    public void showRec(Node root){
        if(root!=null){
            showRec(root.left);
            System.out.print(root.data + " ");
            showRec(root.right);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        int ch,data;
        do{
            System.out.println("Menu");
            System.out.println("1. Insert ");
            System.out.println("2. Show ");
            System.out.println("3. Exit ");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value to be Inserted: ");
                    data=sc.nextInt();
                    tree.insert(data);
                    break;
                case 2: tree.show();break;
                case 4: System.out.println("Menu Exited");break;
                default: System.out.println("Invalid Choice ");
                sc.close();
            }
        }
        while(ch!=3);
    }
}
