import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class bfs {
    public ArrayList<Integer> bfsofgraph(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,ArrayList<Boolean> visited){
        Queue<Integer> q = new LinkedList<>();
        visited.set(node,true);
        q.add(node);
        while(!q.isEmpty()){
            node=q.poll();
            ans.add(node);
            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j);
                if(!visited.get(neigh)){
                    visited.set(neigh,true);
                    q.add(neigh);
                }
            }
        }
        return ans;
    }
    public static void display(int vertex,ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<vertex;i++){
            System.out.print(i + "->" + " ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
        }
    }

    public static void main(String[] args) {
        bfs SS = new bfs();
        Scanner sc = new Scanner(System.in);
        int vertex,edges;
        System.out.println("Enter Vertex Length: ");
        vertex=sc.nextInt();
        System.out.println("Enter Edge Length: ");
        edges=sc.nextInt();
        ArrayList<ArrayList<Integer>> AdjList= new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i=0; i<vertex; i++){
            AdjList.add(new ArrayList<>());
            visited.add(false);
        }
        int u,v;
        for(int i=0;i<edges;i++){
            u=sc.nextInt();
            v=sc.nextInt();
            AdjList.get(u).add(v);
            AdjList.get(v).add(u);
        }
        display(vertex,AdjList);
        SS.bfsofgraph(0,AdjList,ans,visited);
        display(vertex, AdjList);
        System.out.println("BFS Traversal: " + ans);
        sc.close();
    }
}
