
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
        cout<<"The Tree with sorted values: \n";
        showrec(root);
    }
    void showrec(Node*root){
        if(root!=nullptr){
            showrec(root->left);
            cout<<root->data<<" \n";
            showrec(root->right);
        }
    }
    void del(int data){
        if(root==nullptr){
            cout<<"Tree is Empty!\n";
            return;
        }
        root=deleterec(root,data);
        cout<<"Node Deleted!";
    }
    Node*findMin(Node*root){
        while(root->left!=nullptr){
            root=root->left;
        }
        return root;
    }
    Node*deleterec(Node*root,int data){
        if(root==nullptr){
            cout<<"Tree is Empty!";
            return root;
        }
        if(data<root->data){
            root->left=deleterec(root->left,data);
        }
        else if(data>root->data){
            root->right=deleterec(root->right,data);
        }
        else{
            if(root->left==nullptr && root->right==nullptr){
                delete root;
                return nullptr;
            }
            else if(root->left==nullptr){
                Node*temp=root->right;
                delete root;
                return temp;
            }
            else if(root->right==nullptr){
                Node*temp=root->left;
                delete root;
                return temp;
            }
            else{
                Node*temp=findMin(root->right);
                root->data=temp->data;
                root->right=deleterec(root->right,temp->data);
            }
        }
        return root;
    }
    void search(int data){
        Node*curr=root;
        while(curr!=nullptr){
            if(data==curr->data){
                cout<<"Element found!\n";
                return;
            }
            else if(data<curr->data){
                curr=curr->left;
            }
            else{
                curr=curr->right;
            }
        }
        cout<<"Element not found!\n";
    }
};
int main(){
    binarytree bin;
    int ch,dt;
    do{
        cout<<"\nMenu\n";
        cout<<"1. Insertion\n"<<"2. Traversal\n"<<"3. Delete\n"<<"4. Search\n"<<"5. Exit\n"<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>dt; bin.insert(dt);break;
            case 2: bin.show();break;
            case 3: cout<<"Enter the value to be deleted: ";cin>>dt; bin.del(dt);break;
            case 4: cout<<"Enter the value to be searched: ";cin>>dt; bin.search(dt);break;
            case 5: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!\n";
        }
    }
    while(ch!=5);
    return 0;
}
