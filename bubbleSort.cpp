#include <iostream>
#include <vector>
using namespace std;
class Sort{
    public:
    void insert(vector<int>& og){
        string x="";
        string ip="n";
        int y;
        do{
            cout<<"Enter Array Element: ";
            cin>>y;
            cout<<"Do you want to enter more elements (y/n)?";
            cin>>ip;
            og.push_back(y);
        }
        while(ip=="y" || ip=="Y");
    }
    void BubbleSort(vector<int>& og){
        for(int i=0;i<og.size()-1;i++){
            for(int j=0;j<og.size()-i-1;j++){
                og[j]=og[j]+og[j+1];
                og[j+1]=og[j]-og[j+1];
                og[j]=og[j]-og[j+1];
            }
        }
        cout<<"\nAfter Sorting\n";
    }
    void Display(vector<int>& og){
        cout<<"The Array: ";
        for(int i=0;i<og.size();i++){
            cout<<og[i]<<" ";
        }
    }
};
int main(){
    Sort SS;
    vector<int> og;
    SS.insert(og);
    SS.Display(og);
    SS.BubbleSort(og);
    SS.Display(og);
    return 0;
}
