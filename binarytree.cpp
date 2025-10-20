#include <iostream>
using namespace std;
class Node{  
    public:
    int data;
    Node*left;
    Node*right;
    Node(){
        data=0;
        left=NULL;
        right=NULL;
    }
    Node(int data){
        this->data=data;
        this->left=NULL;
        this->right=NULL;
    }
};
class binarytree{
    Node*root;
    public:
    binarytree(){
        root=NULL;
    }    
    void insert(int data){
        root= insertrec(root,data);
    }
    Node*insertrec(Node*root,int data){
        if(root==nullptr){
            root=new Node(data);
            return root;
        } 
        if(data<root->data){
            root->left=insertrec(root->left,data);
        }
        else if(data>root->data){
            root->right=insertrec(root->right,data);
        }
        return root;
    }
    void show(){
        cout<<"The Tree with sorted values: ";
        showrec(root);
    }
    void showrec(Node*root){
        if(root!=nullptr){
            showrec(root->left);
            cout<<root->data<<" \n";
            showrec(root->right);
        }
        cout<<" ";
    }
    // void del(){
    //     deleterec(root);
    // }
    // Node*deleterec(Node root){
    //     Node*temp;
    //     if(root==nullptr){
    //         cout<<"Tree is Empty!";
    //     }
    //     if(root->left==nullptr && root->right==nullptr){
    //         delete root;
    //         cout<<"Node Deleted!";
    //         return nullptr;
    //     }
    //     else if(root->left==nullptr){
    //         temp=root->right;
    //         delete temp;
    //         cout<<"Node Deleted!";
    //         return temp;
    //     }
    //     else if(root->right==nullptr){
    //         temp=root->left;
    //         delete temp;
    //         cout<<"Node Deleted";
    //         return temp;
    //     }
    //     while (Node->left!=nullptr){
    //         root=root->left;
            
    //     }
        
    //     return temp;
    // }
};
int main(){
    binarytree bin;
    int ch,dt;
    do{
        cout<<"\nMenu\n";
        cout<<"1. Insertion \n"<<"2. Traversal \n"<<"4. Exit \n"<<"Enter your choice: ";
        //"3. Delete \n"<<
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>dt; bin.insert(dt);break;
            case 2: bin.show();break;
            // case 3: bin.del();break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!\n";
        }
    }
    while(ch!=4);
    return 0;
    }
