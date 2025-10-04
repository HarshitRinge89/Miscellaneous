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
            return;
        }
        newNode->next=this->head;
        this->head=newNode;
    }
    void print(){
        Node* temp = head;
        if(head==NULL){
            cout<<"List Empty";
        }
        cout<<"Elements are: ";
        while(temp!=NULL){
            cout<<temp->data<<" ";
            temp=temp->next;
        }
    }
};
int main(){
    LinkedList list;
    list.insert(21);
    list.insert(12);
    list.insert(11);
    list.print();
    return 0;
}
