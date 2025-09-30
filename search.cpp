#include<iostream>
using namespace std;
int main(){
    int number,found=0,size;
    cout<<"Enter the length of array: ";
    cin>>size;
    int arr[size];
    for(int i=0;i<size;i++){
        cout<<"Enter element: ";
        cin>>arr[i];
    }
    cout<<"Enter the number to be searched : ";
    cin>> number;
    for (int i=0;i<size;i++){
        if (arr[i]==number){
            cout<<"The number is at index : "<<i;
            found++;
            break;
        } 
    }
    if (found==0){
        cout<<"The number is at index : -1 ";
    }   
    return 0;
}
