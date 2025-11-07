import java.util.Scanner;
public class binaryheap{
    int size,capacity;
    int arr[];
    int i=size;
    binaryheap(int n){
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
    public void heapify(int i){
        int parent=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<size && arr[left]<arr[parent]){
            parent=left;
        }
        else if(right<size && arr[right]<arr[parent]){
            parent=right;
        }
        if(parent!=i){
            int temp=arr[i];
            arr[i]=arr[parent];
            arr[parent]=temp;
            heapify(parent);
        }
    }
    public void del(){
        if(size==0){
            System.out.println("Binary Heap Underflow!");
        }
        System.out.println(arr[0] + " is deleted from the Heap");
        arr[0]=arr[size-1];
        size--;
        if(size==0){
            System.out.println("Binary Heap Underflow!");
        }
        heapify(i);
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
        binaryheap bh= new binaryheap(x);
        do{
            System.out.println("Menu\n" + "1.Insertion\n" + "2.Deletion\n" + "3.Display\n"+"4.Exit\n" + "Enter your choice: ");
            ch=sc.nextInt();
            switch(ch){
                case 1: System.out.println("Enter the value to be inserted: ");
                data=sc.nextInt();
                bh.insert(data);
                break;
                case 2: bh.del();
                case 3: bh.display();
                case 4: System.out.println("Menu Exited!"); break;
                default: System.out.println("Invalid Case!");
            }
        }
        while(ch!=4);
        sc.close();
    }
}
