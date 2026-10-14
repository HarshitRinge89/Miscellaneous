#include <iostream>
using namespace std;
class Node{
    public:
    int data;
    Node*next;
    Node(){
        data=0;
        next=NULL;
    }
    Node(int data){
        this->data=data;
        this->next=NULL;
    }
};
class Queue{
    Node *front,*rear;    
    public:
    Queue(){
        front=NULL;
    }
    void enqueue(int data){
        Node *newNode = new Node(data);
        if(front== NULL){
            front=rear=newNode;
            rear->next=front;
            cout<<"Element Inserted"<<endl;
        }
        else{
            rear->next=newNode;
            rear=newNode;
            rear->next=front;
            cout<<"Element Inserted"<<endl;
        }
    }
    void display(){
        Node* temp = front;
        if(front==NULL){
            cout<<"Queue is Empty! ";
        }
        cout<<"Queue : ";
        do{
            cout<<temp->data<<" ";
            temp=temp->next;
        }
        while(temp!=front);
    }
    void dequeue(){
        Node*prev;
        if(front==nullptr){
            cout<<"Queue is Empty";
        }
        Node*temp=front;
        front=front->next;
        rear->next=front;
        delete temp;
        cout<<"Element Deleted";
    }
};
int main(){
    int ch,data,n;
    Queue q;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Enqueue "<<endl;
        cout<<"2. Dequeue "<<endl;
        cout<<"3. Display "<<endl;
        cout<<"4. Exit "<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; q.enqueue(data);break;
            case 2: q.dequeue();break;
            case 3: q.display();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
}
