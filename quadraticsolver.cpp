#include <iostream>
#include <cmath>
using namespace std;
class quadratic{
    public:
    double a,b,c,D= ((pow(b,2)) - (4*a*c));
    double qroot1(double a,double b,double c){
        double r1=((-b + (sqrt(D)))/(2*a));return r1;}
    double qroot2(double a,double b,double c){
        double r2=((-b - (sqrt(D)))/(2*a));return r2;}
    double iroot1(double a,double b,double c){
        double ir1=((-b)/(2*a));return ir1;}
    double iroot2(double a,double b,double c){
        double ir2=((-b)/(2*a));return ir2;}
    double imagine1(double a,double b,double c){
        double imaginary=((sqrt(D))/2*(a));return imaginary;}
    double imagine2(double a,double b,double c){
        double imaginary=((sqrt(D))/2*(a));return imaginary;}
    int quad(){
        cout<<"Enter the Quadratic Equation: "<<endl;
        cout<<"Enter Coefficient at power 2: ";cin>>a;
        cout<<"Enter coefficient at power 1: ";cin>>b;
        cout<<"Enter Coefficient at power 0: ";cin>>c;
        cout<<"The roots of Given equation : ";
        if(D<0){
            double ir1=iroot1(a,b,c),ir2=(a,b,c);
            double i1=imagine1(a,b,c),i2=imagine2(a,b,c);
            cout<<"The roots of Given equation : ";
            cout<<ir1<<" + "<<i1<<" i" <<" and "<<ir2<<" - "<<i2<<" i ";
        }
        else{cout<<qroot1(a,b,c)<<" and "<<qroot2(a,b,c);}
        return 0;
    }
};
