import java.util.Scanner;
public class Queue{
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
    Node front=null;
    Node rear=null;
    public void Enqueue(int data){
        Node newnode = new Node(data);
        if (front == null){
            front = rear = newnode;
            System.out.println("Element Inserted");
        }
        else{
            rear.next=newnode;
            this.rear=newnode;
            System.out.println("Element Inserted");
        }
    }
    public void Dequeue(){
        if(front== null){
            System.out.println("Queue is Empty!");
        }
        Node temp =front;
        front=front.next;
        temp=null;
        System.out.println("Element Deleted!");
    }
    public void Display(){
        Node node = front;
        if(front==null){
            System.out.println("Queue is Empty!");
        }
        System.out.println("The Queue: ");
        while (node!= null){
            System.out.println(node.data);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue L = new Queue();
        int ch,data;
        do{
            System.out.println("Menu");
            System.out.println("1. Enqueue ");
            System.out.println("2. Dequeue ");
            System.out.println("3. Display ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value to be Inserted: ");
                    data=sc.nextInt();
                    L.Enqueue(data);
                    break;
                case 2:L.Dequeue();break;
                case 3: L.Display();break;
                case 4: System.out.println("Menu Exited");break;
                default: System.out.println("Invalid Choice ");
            }
        }
        while(ch!=4);
        sc.close();
    }   
}
