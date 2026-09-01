import java.util.Scanner;
public class heapsort{
    int size,capacity;
    int arr[];
    int i=size;
    heapsort(int n){
        arr=new int[n];
        size=0;
        capacity=n;
    }
    public void moveup(int i){
        while(i>0 && arr[(i-1)/2]>arr[i]){
            int temp=arr[i];
            arr[i]=arr[(i-1)/2];
            arr[(i-1)/2]=temp;
            i=(i-1)/2;
        }
    }
    public void insert(int data){
        if(size==capacity){
            System.out.println("Binary Heap Overflow");
        }
        else{
            arr[size]=data;
            i=size;
            size++;
            moveup(i);
            System.out.println(arr[i] + " is inserted into the Binary Heap");
        }
    }
    public void heapify(int n,int i){
        int parent=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<n && arr[left]<arr[parent]){
            parent=left;
        }
        if(right<n && arr[right]<arr[parent]){
            parent=right;
        }
        if(parent!=i){
            int temp=arr[i];
            arr[i]=arr[parent];
            arr[parent]=temp;
            heapify(n,parent);
        }
    }
    public void builder(){
        for(int i=size/2-1;i>=0;i--){
            heapify(size,i);
        }
    }
    public void sort(){
        builder();
        for(int i=size-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(i,0);
        }
        System.out.println("Sorting Successful!");
    }
    public void display(){
        System.out.println("The Binary Heap: ");
        for(int i=0;i<size;i++){
            System.out.println( arr[i] + " ");
        }
    }
    public static void main(String[] Args){
        int ch,data,x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Heap: ");
        x=sc.nextInt();
        heapsort bh= new heapsort(x);
        do{
            System.out.println("Menu\n" + "1.Insertion\n" + "2.Sort\n" + "3.Display\n"+"4.Exit\n" + "Enter your choice: ");
            ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter the value to be inserted: ");
                data=sc.nextInt();
                bh.insert(data);
                break;
                case 2: bh.sort();break;
                case 3: bh.display();break;
                case 4: System.out.println("Menu Exited!"); break;
                default: System.out.println("Invalid Case!");
            }
        }
        while(ch!=4);
        sc.close();
    }
}
