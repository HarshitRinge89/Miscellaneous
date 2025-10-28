import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
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
    public static void selectionSort(ArrayList<Integer> original){
        for(int i=0;i<original.size()-1;i++){
            int min=i;
            for(int j=i+1;j<original.size();j++){
                if(original.get(j)<original.get(min)){
                    min=j;
                }
            }
            if(min!=i){
                int temp=original.get(i);
                original.set(i,original.get(min));
                original.set(min,temp);
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
        insert(original);
        display(original);
        selectionSort(original);
        display(original);
        sc.close();
    }
}
