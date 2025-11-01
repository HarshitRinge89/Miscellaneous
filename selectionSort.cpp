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
    void selectionSort(vector<int>& og){
        for(int i=0;i<og.size()-1;i++){
            int min=i;
            for(int j=i+1;j<og.size();j++){
                if(og[j]<og[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=og[i];
                og[i]=og[min];
                og[min]=temp;
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
    SS.selectionSort(og);
    SS.Display(og);
    return 0;
}
