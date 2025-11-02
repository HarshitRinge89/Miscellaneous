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
    private static int partition(ArrayList<Integer> og,int start,int end){
        int pivot=og.get(end);
        int i=start-1;
        for(int j=start;j<=og.size()-1;j++){
            if(og.get(j)<pivot){
                i++;
                int temp=og.get(i);
                og.set(i,og.get(j));
                og.set(j,temp);
            }
        }
        int temp=og.get(i+1);
        og.set(i+1,og.get(end));
        og.set(end,temp);
        return i+1;
    }
    public static void quickSort(ArrayList<Integer> original,int start,int end){
        if(start<end){
            int pi=partition(original, start, end);
            quickSort(original, start,pi-1);
            quickSort(original, pi+1,end);
        }
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
        quickSort(original,0,original.size()-1);
        display(original);
        sc.close();
    }
}
