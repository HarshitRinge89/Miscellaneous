import java.util.Scanner;
public class Queue{
    static int size=5;
    static int arr[]=new int[size];
    static int front=0;
    static int rear=0;
    public static void Enqueue(int data) {
        if(rear==size){
            System.out.println("Queue is Full ! ");
        }
        else{
            arr[rear]=data;
            rear++;
            System.out.println("Element Inserted! ");
        }
    }
    public static void Dequeue() {
        if(front==size){
            System.out.println("Queue is Empty! ");
        }
        else{
            front++;
            System.out.println("Element removed! ");
        }
    }
    public static void Display() {
        System.out.println("The Queue: ");
        for(int i=front;i<size;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        int ch,data;
        do{
            System.out.println("Menu");
            System.out.println("1. Enqueue ");
            System.out.println("2. Dequeue ");
            System.out.println("3. Display ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value to be Inserted: ");
                    data=sc.nextInt();
                    Enqueue(data);
                    break;
                case 2: Dequeue();break;
                case 3: Display();break;
                case 4: System.out.println("Menu Exited");break;
                default: System.out.println("Invalid Choice ");
                sc.close();
            }
        }
        while(ch!=4);
    }
}
