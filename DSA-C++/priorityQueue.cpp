#include <iostream>
#include <bits/stdc++.h>
const int size=5;
using namespace std;
class priorirtyQueue{
    priority_queue <int , vector<int>, greater<int> > p;
    public:    
    void Enqueue(int data){ 
        p.push(data);
        cout<<"Data Inserted! ";
    }
    void Dequeue(){
        if(p.empty){
            cout<<"Queue is Empty! "<<endl;
        }
        else{
            p.pop();
            cout<<"Element deleted! ";
        }
    }
    void Display(){
        priority_queue<int> temp(p);
        if(p.empty){
            cout<<"Queue is Empty";
        }
        else{
            cout<<"The Queue : ";
            while(!temp.empty){
                cout<<temp.top()<<" ";
                temp.pop();
            }
        }
    }
    void topelement(){
        cout<<"The Top Element: "<<p.top();
    }
};
int main(){
    Queue q;
    int ch,data;
    do{
        cout<<endl<<"Menu"<<endl;
        cout<<"1. Enqueue "<<endl;
        cout<<"2. Dequeue "<<endl;
        cout<<"3. Display the Queue "<<endl;
        cout<<"4. Exit Menu"<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: cout<<"Enter the value to be inserted: ";cin>>data; q.Enqueue(data);break;
            case 2: q.Dequeue();break;
            case 3: q.Display();break;
            case 4: q.topelement();break;
            case 5: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=5);
}