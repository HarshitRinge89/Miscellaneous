#include <iostream>
#include<cmath>
using namespace std;
class convertor{
    public:
    int remainder,power;
    void dectbin(int decimal) {
        int binary = 0;
        power = 1;
        while (decimal != 0) {
            remainder = decimal % 2;
            binary += remainder * power;
            power *= 10;
            decimal /= 2;
        }
        cout<<"Binary Transform of input : ";
        cout<<binary<<endl;
    }
    void dectoct(int decimal){
        int octal = 0;
        power = 1;
        while (decimal != 0) {
            remainder = decimal % 8;
            octal += remainder * power;
            power *= 10;
            decimal /= 8;
        }
        cout<<"Octal Transform of input : ";
        cout<<octal<<endl;
    }
    void decthex(int decimal){
        char ch;
        string x;
        while (decimal != 0) {
            remainder = decimal % 16;
            if(remainder<10){
                ch=remainder+48;
            }
            else{
                ch=remainder+55;
            }
            x+=ch;
            decimal /= 16;
        }
        int i = 0, j = x.size() - 1;
        while(i<=j){
            swap(x[i],x[j]);
            i++;j--;
        }
        cout<<"Hexadecimal Transform of input : ";
        cout<<x<<endl;
    }
};
int main(){
    int j,ch=0;
    convertor conv;
    do{
        cout<<"Please Enter your Number : ";
        cin>>j;
        cout<<endl<<"Menu"<<endl;
        cout<<"1. To Binary"<<endl;
        cout<<"2. To Octal"<<endl;
        cout<<"3. To Hexadecimal "<<endl;
        cout<<"4. Exit "<<endl;
        cout<<"Enter your choice: ";
        cin>>ch;
        switch(ch){
            case 1: conv.dectbin(j);break;
            case 2: conv.dectoct(j);break;
            case 3: conv.decthex(j);break;
            case 4: cout<<"Menu exited!";break;
            default: cout<<"Invalid Case!"<<endl;
        }
    }
    while(ch!=4);
    return 0;
}
