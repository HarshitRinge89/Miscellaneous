import java.util.Scanner;
public class Stack{
    static int top=-1;
    static int size=5;
    static int arr[]=new int[size];
    // public Stack(int cap) {
    //     size=cap;
    //     arr = new int[size];
    //     top = -1;
    // }
    public static void Push(int data) {
        if(top==size-1){
            System.out.println("Stack Overflow! ");
        }
        else{
            top++;
            arr[top]=data;
            System.out.println("Element Inserted! ");
        }
    }
    public static void Pop() {
        if(top==-1){
            System.out.println("Stack Underflow! ");
        }
        else{
            arr[top]=arr[top++];
            System.out.println("Element removed! ");
        }
    }
    public static void Peek() {
        if(top==-1){
            System.out.println("Stack Underflow! ");
        }
        else{
            System.out.println(arr[top]);
        }
    }
    public static void Display() {
        System.out.println("The Stack: ");
        for(int i=size-1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        int ch,data;
        do{
            System.out.println("Menu");
            System.out.println("1. Push ");
            System.out.println("2. Pop ");
            System.out.println("3. Peek ");
            System.out.println("4. Display ");
            System.out.println("5. Exit ");
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value to be Inserted: ");
                    data=sc.nextInt();
                    Push(data);
                    break;
                case 2: Pop();break;
                case 3: Peek();break;
                case 4: Display();break;
                case 5: System.out.println("Menu Exited");break;
                default: System.out.println("Invalid Choice ");
            }
        }
        while(ch!=5);
    }
}
