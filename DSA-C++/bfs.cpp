#include<iostream>
#include<vector>
#include<queue>
using namespace std;
class bfs{
    public:
    vector<int> bfsofgraph(int v,vector<int>adj[]){
        queue<int>q;
        q.push(0);
        vector<bool>visited(v,0);
        visited[0]=1;
        vector<int>ans;
        int node;
        while(!q.empty()){
            node=q.front();
            q.pop();
            ans.push_back(node);
            for(int j=0;j<adj[node].size();j++){
                int neigh=adj[node][j];
                if(!visited[neigh]){
                    visited[neigh]=true;
                    q.push(neigh);
                }
            }
        }
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
    bfs SS;
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
    vector<int> result=SS.bfsofgraph(vertex,AdjList);
    cout<<"\nBFS Traversal: ";
    for(int x : result){
        cout<<x<<" ";
    }
    cout<<endl;
    return 0;
}