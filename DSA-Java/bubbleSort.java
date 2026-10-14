import java.util.ArrayList;
import java.util.Scanner;
public class bubbleSort {
    static Scanner sc= new Scanner(System.in);
    public static void insert(ArrayList<Integer> original){
        char x= 'y';
        while(Character.toLowerCase(x) == 'y'){
            System.out.println("Enter the element: ");
            int y= sc.nextInt();
            original.add(y);
            System.out.println("Do you want to enter More?(y/n): ");
            x=sc.next().charAt(0);
        }
    }
    public static void bubbleSort(ArrayList<Integer> original){
        for(int i=0;i<original.size()-1;i++){
            boolean sorted=false;
            for(int j=0;j<original.size()-i-1;j++){
                if(original.get(j) > original.get(j+1)){
                    int temp=original.get(j);
                    original.set(j,original.get(j+1));
                    original.set(j+1,temp);
                    sorted=true;
                }
            }
            if(sorted==false){
                break;
            }
        }
        System.out.println("\nAfter Sorting");
    }
    public static void display(ArrayList<Integer> original){
        System.out.println("\nThe Array is: ");
        for(int i=0;i<original.size();i++){
            System.out.print(original.get(i) + " ");
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> original = new ArrayList<>();
        int choice;
        do{
            System.out.println("Menu\n 1. Insert\n 2.Display\n 3.Sort\n 4. Exit\n Enter your Choice: " );
            choice=sc.nextInt();
            switch (choice) {
                case 1: insert(original);break;
                case 2: display(original);break;
                case 3: bubbleSort(original);break;
                case 4: System.out.println("Menu Exited! ");break;
                default: System.out.println("Invalid Choice! ");break;
            }
        }
        while (choice!=4);
        sc.close();
    }
}
