#include <iostream>
using namespace std;
class Node{
    public:
    int data;
    Node* next;
    Node* prev;
    Node(){
        data=0;
        next=prev=NULL;
    }
    Node(int data){
        this->data=data;
        this->next=NULL;
        this->prev=NULL;
    }
};
class LinkedList{
    Node *head,*tail;
    public:
    LinkedList(){
        head=tail=NULL;
    }
    void insert(int data){
        Node *newNode = new Node(data);
        int choice;
        cout<<"Select the end to insert New Node: \n";
        cout<<"1. Front-End\n";
        cout<<"2. Back-End\n";
        cin>>choice;
        if(head==NULL){
            head=tail=newNode;
            return;
        }
        if(choice==1){
            newNode->next=this->head;
            head->prev=newNode;
            this->head=newNode;

        }
        else if(choice==2){
            tail->next=newNode;
            newNode->prev=tail;
            this->tail=newNode;
        }
        else{
            cout<<"Invalid Choice!\n";
            return;
        }
        cout<<"Element Inserted\n";
    }
    void traversal(){
        Node*temp;
        if(head==NULL || tail==NULL){
            cout<<"List Empty!\n";
            return;
        }
        temp = head;
        cout<<"Elements are: ";
        while(temp!=NULL){
            cout<<temp->data<<" ";
            temp=temp->next;
        }
        cout<<endl;
    }
    void del(){
        Node*temp;
        int choice;
        cout<<"Select the end to delete Node: \n";
        cout<<"1. Front-End\n";
        cout<<"2. Back-End\n";
        cin>>choice;
        if(head==NULL){
            cout<<"List is Empty!\n";
            return;
        }
        if(head==tail){
            delete head;
            head=tail=NULL;
            cout<<"Element Deleted\n";
            return;
        }
        if(choice==1){
            temp=head;
            head=head->next;
            head->prev=NULL;
        }
        else if(choice==2){
            temp=tail;
            tail=tail->prev;
            tail->next=NULL;
        }
        else{
            cout<<"Invalid Choice!\n";
            return;
        }
        delete temp;
        cout<<"Element Deleted\n";
    }
};
int main(){
    int ch,data,n;
    LinkedList list;
    do{
        cout<<"\nMenu\n";
        cout<<"1. Insertion \n"<<"2. Deletion \n"<<"3. Traversal \n"<<"4. Exit \n"<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; list.insert(data);break;
            case 2: list.del();break;
            case 3: list.traversal();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!\n";
        }
    }
    while(ch!=4);
}
