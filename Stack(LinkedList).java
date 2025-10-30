import java.util.Scanner;
public class Stack{
    class Node{
        int data;
        Node next;
        Node(){
            data=0;
            next=null;
        }
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node top=null;
    public void Push(int data){
        Node newnode = new Node(data);
        if (top == null){
            top = newnode;
            System.out.println("Element Inserted");
        }
        else{
            newnode.next=this.top;
            this.top=newnode;
            System.out.println("Element Inserted");
        }
    }
    public void Pop(){
        if(top== null){
            System.out.println("Stack Underflow!");
        }
        Node temp =top;
        top=top.next;
        temp=null;
        System.out.println("Element Deleted!");
    }
    public void Display(){
        Node node = top;
        if(top==null){
            System.out.println("Stack Underflow!");
        }
        System.out.println("The Stack: ");
        while (node!= null){
            System.out.println(node.data);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack L = new Stack();
        int ch,data;
        do{
            System.out.println("Menu");
            System.out.println("1. Push ");
            System.out.println("2. Pop ");
            System.out.println("3. Display ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value to be Inserted: ");
                    data=sc.nextInt();
                    L.Push(data);
                    break;
                case 2:L.Pop();break;
                case 3: L.Display();break;
                case 4: System.out.println("Menu Exited");break;
                default: System.out.println("Invalid Choice ");
            }
        }
        while(ch!=4);
        sc.close();
    }   
}
