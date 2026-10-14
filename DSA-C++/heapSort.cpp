#include <iostream>
#include <utility>
using namespace std;
class heapsort{
    int* arr;
    int size=0;
    int capacity;
    int i=size;
    public:
    heapsort(int n){
        arr= new int[n]; 
        capacity=n;
    }
    void insert(int data){
        if(size==capacity){
            cout<<"The Binary Heap Overflow! \n";
            return;
        }
        arr[size]=data;
        i=size;
        size++;
        while ((i>0 && arr[(i-1)/2]<arr[i])){
            swap(arr[i],arr[(i-1)/2]);
            i=(i-1)/2;
        }
        cout<<endl<<arr[i]<<" is inserted in the Binary Heap\n";

    }
    void heapify(int n,int i){
        int parent=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<n && arr[left]>arr[parent]){
            parent=left;
        }
        if(right<n && arr[right]> arr[parent]){
            parent=right;
        }
        if(parent!=i){
            swap(arr[i],arr[parent]);
            heapify(n,parent);
        }
    }
    void buildmaxheap(){
        for(int i=size/2-1;i>=0;i--){
            heapify(size,i);
        }
    }
    void sort(){
        buildmaxheap();
        for (int i=size-1;i>=0;i--){
            swap(arr[i],arr[0]);
            heapify(i,0);
        }
    }
    void display(){
        cout<<"The Binary Heap: ";
        for(int i=0;i<size;i++){
            cout<<arr[i]<<" ";
        }
    }
};
int main(){
    int x,data,ch;
    cout<<"Enter size of Heap: ";
    cin>>x;
    heapsort bh(x);
    do{
        cout<<"\nMenu\n"<<"1. Insert \n"<<"2. sort \n"<<"3. Display \n"<<"4. Exit \n"<<"Enter your choice: \n";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; bh.insert(data);break;
            case 2: bh.sort(); break;
            case 3: bh.display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
    return 0;
}
