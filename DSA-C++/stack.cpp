#include <iostream>
const int size=5;
using namespace std;
class Stack{
    int arr[size];
    int top;
    public:    
    Stack(){
        top=-1;
    }    
    void Push(int data){ 
        if(top==size-1){
            cout<<"Stack Overflow! "<<endl;
        }
        else{ 
            top++;
            arr[top]=data;
            cout<<"Data Inserted! ";
        }
    }
    void Pop(){
        if(top==-1){
            cout<<"Stack Underflow! "<<endl;
        }
        else{
            arr[top]=NULL;
            cout<<"Top element deleted! ";
        }
    }
    void Peek(){
        if(top==-1){
            cout<<"Stack Underflow! "<<endl;
        }
        else{
            cout<<"The Top Element: "<<arr[top];
        }
    }
    void Display(){
        cout<<"The Stack : ";
        for(int i=size-1;i>=0;i--){
            cout<<arr[i]<<" ";
        }
    }
};
int main(){
    Stack s;
    int ch,data;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Push "<<endl;
        cout<<"2. Pop "<<endl;
        cout<<"3. Peek "<<endl;
        cout<<"4. Display the Stack "<<endl;
        cout<<"5. Exit Menu"<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";
            cin>>data; 
            s.Push(data);break;
            case 2: s.Pop();break;
            case 3: s.Peek();break;
            case 4: s.Display();break;
            case 5: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=5);
}
