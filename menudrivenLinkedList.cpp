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
    Node *head;
    public:
    LinkedList(){
        head=NULL;
    }
    void insert(int data){
        Node *newNode = new Node(data);
        if(head== NULL){
            head=newNode;
            cout<<"Element Inserted"<<endl;
            return;
        }
        cout<<"Element Inserted"<<endl;
        newNode->next=this->head;
        this->head=newNode;
    }
    void traversal(){
        Node* temp = head;
        if(head==NULL){
            cout<<"List Empty! ";
            return;
        }
        cout<<"Elements are: ";
        while(temp!=NULL){
            cout<<temp->data<<" ";
            temp=temp->next;
        }
    }
    void del(){
        if(head==nullptr){
            cout<<"List is Empty";
        }
        Node*temp=head;
        head=head->next;
        delete temp;
        cout<<"Element Deleted";
    }
};
int main(){
    int ch,data,n;
    LinkedList list;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Insertion "<<endl;
        cout<<"2. Deletion "<<endl;
        cout<<"3. Traversal "<<endl;
        cout<<"4. Exit "<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; list.insert(data);break;
            case 2: list.del();break;
            case 3: list.traversal();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
}
