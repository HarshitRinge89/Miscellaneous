#include <iostream>
#include <utility>
using namespace std;
class binaryheap{
    int* arr;
    int size=0;
    int capacity;
    int i=size;
    public:
    binaryheap(int n){
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
    void heapify(int i){
        int parent=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<size && arr[left]>arr[parent]){
            parent=left;
        }
        else if(right<size && arr[right]> arr[parent]){
            parent=right;
        }
        if(parent!=i){
            swap(arr[i],arr[parent]);
            heapify(parent);
        }
    }
    void del(){
        if(size==0){
            cout<<"The Binary Heap Underflow!\n";
            return;
        }
        cout<<endl<<arr[0]<<" is deleted from the Heap\n";
        arr[0]=arr[size-1];
        size--;
        if(size==0){
            cout<<"The Binary Heap Underflow!\n";
        }
        heapify(i);
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
    binaryheap bh(x);
    do{
        cout<<"\nMenu\n"<<"1. Insert \n"<<"2. Delete \n"<<"3. Display \n"<<"4. Exit \n"<<"Enter your choice: \n";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; bh.insert(data);break;
            case 2: bh.del();break;
            case 3: bh.display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
    return 0;
}
