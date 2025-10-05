#include <iostream>
using namespace std;
class Node{
    public:
    int data;
    Node* next;
    Node(){
        data=0;
        next=NULL;
    }
    Node(int data){
        this->data=data;
        this->next=NULL;
    }
};
class LinkedList{
    Node*top;
    public:
    LinkedList(){
        top=NULL;
    }
    void push(int data){
        Node *newNode = new Node(data);
        if(top== NULL){
            top=newNode;
            cout<<"Element Inserted"<<endl;
            return;
        }
        cout<<"Element Inserted"<<endl;
        newNode->next=this->top;
        this->top=newNode;
    }
    void display(){
        Node* temp = top;
        if(top==NULL){
            cout<<"Stack Underflow! ";
            return;
        }
        cout<<"Stack is: "<<endl;
        while(temp!=NULL){
            cout<<temp->data<<endl;
            temp=temp->next;
        }
    }
    void pop(){
        if(top==nullptr){
            cout<<"List is Empty";
        }
        Node*temp=top;
        top=top->next;
        delete temp;
        cout<<"Top Element removed";
    }
    void peek(){
        cout<<"The Top is: "<<top->data<<endl;
    }
};
int main(){
    int ch,data,n;
    LinkedList list;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Push "<<endl;
        cout<<"2. Pop "<<endl;
        cout<<"3. Display "<<endl;
        cout<<"4. Peek "<<endl;
        cout<<"5. Exit "<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; list.push(data);break;
            case 2: list.pop();break;
            case 3: list.display();break;
            case 4: list.peek();break;
            case 5: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=5);
}
