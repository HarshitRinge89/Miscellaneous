#include <iostream>
const int size=5;
using namespace std;
class Queue{
    int arr[size];
    int front,rear;
    public:    
    Queue(){
        front,rear=-1;
    }    
    void Enqueue(int data){ 
        if(rear==size-1){
            cout<<"Queue is Full! "<<endl;
        }
        else{
            rear++; 
            arr[rear]=data;
            front=arr[0];
            cout<<"Data Inserted! ";
        }
    }
    void Dequeue(){
        if(front==-1 || front>rear){
            cout<<"Queue is Empty! "<<endl;
        }
        else{
            // arr[front]=NULL;
            front++;
            cout<<"Element deleted! ";
        }
    }
    void Display(){
        if(front==-1){
            cout<<"Queue is Empty";
        }
        else{
            cout<<"The Queue : ";
            for(int i=front-1;i<=rear;i++){
                cout<<arr[i]<<" ";
            }
        }
    }
};
int main(){
    Queue q;
    int ch,data;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Enqueue "<<endl;
        cout<<"2. Dequeue "<<endl;
        cout<<"3. Display the Queue "<<endl;
        cout<<"4. Exit Menu"<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; q.Enqueue(data);break;
            case 2: q.Dequeue();break;
            case 3: q.Display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
}
