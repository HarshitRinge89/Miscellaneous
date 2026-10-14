#include <iostream>
const int size=5;
using namespace std;
class Queue{
    int arr[size];
    int front,rear;
    public:    
    Queue(){
        front=-1;
        rear=-1;
    }    
    void Enqueue(){
        int choice,data;
        cout<<"1.Front\n"<<"2.Rear\n"<<"Enter your choice: ";cin>>choice;
        cout<<"Enter the value to be inserted: ";cin>>data;
        if(choice==1){
            if(front==0){
                cout<<"Queue is Full at front! "<<endl;
            }
            else if(front==-1){
                front=rear=0;
                arr[front]=data;
            }
            else{
                front--;
                arr[front]=data;
                cout<<"Data Inserted! ";
            }
        }
        else if(choice==2){
            if(rear==size-1){
                cout<<"Queue is Full! "<<endl;
            }
            else if(front==-1){
                front=rear=0;
                arr[rear]=data;
            }
            else{
                rear++; 
                arr[rear]=data;
                cout<<"Data Inserted! ";
            }
        }
        else{
            cout<<"Invalid End!\n";
        }
    }
    void Dequeue(){
        int choice,data;
        cout<<"1.Front\n"<<"2.Rear\n"<<"Enter your choice: ";cin>>choice;
        cout<<"Enter the value to be Deleted: ";cin>>data;
        if(choice==1){
            
            if(front==-1){
                cout<<"Queue is Empty! "<<endl;
            }
            else{
                // arr[front]=NULL;
                front++;
                cout<<"Element deleted! ";
            }
        }
        else if(choice==2){    
            if(front==-1 || front>rear){
                cout<<"Queue is Empty! "<<endl;
            }
            else{
                // arr[front]=NULL;
                rear--;
                cout<<"Element deleted! ";
            }
        }
        else{
            cout<<"Invalid End\n";
        }
        if(front>rear){
            front=rear=-1;
        }
    }
    void Display(){
        if(front==-1){
            cout<<"Queue is Empty";
        }
        else{
            cout<<"The Queue : ";
            for(int i=front;i<=rear;i++){
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
        cout<<"1. Enqueue \n"<<"2. Dequeue \n"<<"3. Display the Queue \n"<<"4. Exit Menu\n"<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: q.Enqueue();break;
            case 2: q.Dequeue();break;
            case 3: q.Display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
}
