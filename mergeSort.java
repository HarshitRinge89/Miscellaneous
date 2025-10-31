import java.util.ArrayList;
import java.util.List;
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
    private static void merge(ArrayList<Integer> original,int left,int mid,int right){
        ArrayList<Integer> larr = new ArrayList<>();
        ArrayList<Integer> rarr = new ArrayList<>();;
        for(int i=left;i<=mid;i++){
            larr.add(original.get(i));
        }
        for(int i=mid+1;i<=right;i++){
            rarr.add(original.get(i));
        }
        int i=0,j=0;
        int k=left;
        while(i<larr.size() && j<rarr.size()){
            if(larr.get(i)<=rarr.get(j)){
                original.set(k, larr.get(i));
                i++;
            }
            else {
                original.set(k, rarr.get(j));
                j++;
            }
            k++;
        }
        while(i<larr.size()){
            original.set(k, larr.get(i));
            i++;
            k++;
        }
        while(j<rarr.size()){
            original.set(k, rarr.get(j));
            j++;
            k++;
        }
    }
    public static void mergeSort(ArrayList<Integer> original,int left,int right){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mergeSort(original,left,mid);
        mergeSort(original, mid+1, right);
        merge(original, left, mid, right);
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
        mergeSort(original,0,original.size()-1);
        display(original);
        sc.close();
    }
}
