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
            cout<<"Queue is Full! "<<data<<" must wait!";
        }
        else{
            front=0;
            rear=(rear+1)%size; 
            arr[rear]=data;
            cout<<endl<<"User "<<data<<" Joined the Queue! ";
        }
    }
    void Dequeue(){
        if(front==-1){
            cout<<"Queue is Empty & Nobody to Serve! "<<endl;
        }
        else{
            if(front==rear){
                front=rear=-1;
            }
            else{
                cout<<"User "<<arr[front]<<" got their Ticket and left the Queue! ";
                front=(front+1)%size;
            }
        }
    }
    void Display(){
        if(front==-1){
            cout<<"Queue is Empty & Nobody to Serve!";
        }
        else{
            cout<<"The Queue : ";
            int i=front;
            while(true){
                cout<<arr[i]<<" ";
                if(i==rear)break;
                i=(i+1)%size;
            }
            cout<<endl;
        }
    }
};
int main(){
    Queue q;
    int ch,data;
    do{
        cout<<endl<<"Ticket Distribution Simulation"<<endl;
        cout<<"1. Enqueue "<<endl;
        cout<<"2. Dequeue "<<endl;
        cout<<"3. Display the Queue "<<endl;
        cout<<"4. Exit Menu"<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter you ID: ";cin>>data; q.Enqueue(data);break;
            case 2: q.Dequeue();break;
            case 3: q.Display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
}
