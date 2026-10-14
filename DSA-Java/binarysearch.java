import java.util.Scanner;
public class binarysearch {
    public static void insert(int n,int[] arr){
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.println("Enter the Element: ");
            arr[i]=sc.nextInt();
        }
    }
    public static int sort(int n,int[] arr,int choice){
        int temp=0;
        if(choice==1){
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }   
        }
        else if(choice==2){
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(arr[j]<arr[j+1]){
                        temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }   
        }
        else{
            System.out.println("Invalid Choice!");
        }
        return choice;
    }
    public static void display(int n,int[] arr){
        System.out.println();
        System.out.print("The Array is: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void search(int n, int[] arr){
        Scanner sct= new Scanner(System.in);
        int mid=(n+1)/2;
        int start=0;
        if(n%2==0) mid=(n/2)-1;
        System.out.println("Enter the type of sorting");
        System.out.println("1. Ascending");
        System.out.println("1. Descending");
        int ch=sct.nextInt();
        System.out.println();
        System.out.println("Enter the target element: ");
        int target=sct.nextInt();
        sort(n, arr,ch);
        for(int i=start;i<n;i++){
            if(arr[i]==target){
                System.out.println("Element is at index: " + i);
            }
            if(ch==1){
                if(target>mid){
                    start=mid;
                    mid=n;
                }
                else if(target<mid){
                    n=mid;
                }
            }
            else if(ch==2){
                if(target>mid){
                    n=mid;
                }
                else if(target<mid){
                    start=mid;
                    mid=n;
                }
            }
            else{
                System.out.println("Invalid Choice!");
            }
        }
    }
    public static void main(String[] Args){
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Length of the array: ");
        n=sc.nextInt();
        int ch;
        int arr[]= new int[n];
        do{
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("Enter your choice: ");
            ch=sc.nextInt();
            switch(ch){
                case 1: insert(n,arr);break;
                case 2: display(n,arr);break;
                case 3: search(n,arr);break;
                default: System.out.println("Invalid Case! ");
            }
        }
        while(ch!=4);
        sc.close();
    }
}
