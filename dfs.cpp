#include<iostream>
#include<vector>
using namespace std;
class dfs{
    public:
    void DFSrec(int node,vector<int>adj[],vector<int>ans,vector<bool>visited){
        visited[0]=1;
        ans.push_back(node);
        for(int j=0;j<adj[node].size();j++){
            if(!visited[adj[node][j]]){
                DFSrec(adj[node][j],adj,ans,visited);
            }
        }
    }
    vector<int> dfsofgraph(int v,vector<int>adj[]){
        vector<int>ans;
        vector<bool>visited(v,0);
        DFSrec(0,adj,ans,visited);
        return ans;
    }
    void display(int vertex,vector<int>AdjList[]){
        for(int i=0;i<vertex;i++){
            cout<<i<<"->";
            for(int j=0;j<AdjList[i].size();j++){
                cout<<AdjList[i][j]<<" ";
            }
            cout<<endl;
        } 
    }
};
int main(){
    dfs SS;
    int vertex,edges;
    cout<<"Enter Vertex length: ";
    cin>>vertex;
    cout<<"Enter Edge length: ";
    cin>>edges;
    vector<int>AdjList[vertex];
    int u,v;
    for(int i=0;i<edges;i++){
        cin>>u>>v;
        AdjList[u].push_back(v);
        AdjList[v].push_back(u);
    }
    SS.display(vertex,AdjList);
    SS.dfsofgraph(vertex,AdjList);
    SS.display(vertex,AdjList);
}