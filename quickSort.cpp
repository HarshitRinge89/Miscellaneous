#include <iostream>
#include <vector>
#include <utility>
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
    int partition(vector <int> & og,int start,int end){
        int pivot =og[end];
        int i=start-1;
        for(int j=start;j<og.size()-1;j++){
            if(og[j]<pivot){
                i++;
                swap(og[i],og[j]);
            }
        }
        swap(og[i+1],og[end]);
        return i+1;
    }
    void quickSort(vector<int>& og,int start,int end){
        if(start<end){
            int pi= partition(og,start,end);
            quickSort(og,start,pi-1);
            quickSort(og,pi+1,end);
        }
    }
    void Display(vector<int>& og){
        cout<<"\nThe Array: ";
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
    SS.quickSort(og,0,og.size()-1);
    SS.Display(og);
    return 0;
}
