import java.util.ArrayList;
public class code{

         public static class edge{
            int v=0;
            int w=0;
            edge(int v,int w){
                this.v=v;
                this.w=w;
            }
        }
        public static int N=7;
        public static ArrayList<edge>[]graph=new ArrayList[N];
        // public static ArrayList<ArrayList<edge>>graph1=new ArrayList<>();
        public static void construct(){
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
            // graph1.add(new ArrayList<edge>());
        }
        addedge(0,1,10);
        addedge(0,3,10);
        addedge(1,2,10);
        addedge(2,3,40);
        addedge(3,4,2);
        addedge(4,5,2);
        addedge(4,6,3);
        addedge(5,6,8);
        addedge(2,5,10);
    }
    public static void addedge(int u,int v,int w){
        graph[u].add(new edge(v,w));
        graph[v].add(new edge(u,w));
    }
    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i+" -> ");
            for(edge e:graph[i])
            System.out.print("("+e.v+","+e.w+")"+" ,");
            System.out.println();
        }
    }
    public static void removeedge(int u,int v){
        int size=graph[u].size();
        for(int i=0;i<size;i++){
            if(graph[u].get(i).v==v){
            graph[u].remove(i);
            break;
            }
        }
        size=graph[v].size();
        for(int i=0;i<size;i++){
            if(graph[v].get(i).v==u){
                graph[v].remove(i);
                break;
            }
        }
    }
    public static void dfs(int idx,boolean []arr){
        System.out.println(idx);
        arr[idx]=true;
        for(int i=0;i<graph[idx].size();i++){
            int a=graph[idx].get(i).v;
            if(!arr[a]){
                dfs(a,arr);
            }
        }
    }
    public static int dfs_allpath(int idx,int dest,boolean []arr,String ans,int wt){
        if(idx==dest){
            System.out.println(ans+"@ "+wt);
        return 1;
        }
        // System.out.println(idx);
        arr[idx]=true;
        int c=0;
        for(int i=0;i<graph[idx].size();i++){
            int a=graph[idx].get(i).v;
            if(!arr[a]){
                c+=dfs_allpath(a,dest,arr,ans+a+" ",wt+graph[idx].get(i).w);
            }
        }
        arr[idx] =false;
        return c;
    }
    public static void removevertex(int u){
        int size=graph[u].size();
        for(int i=size-1;i>=0;i--){
            removeedge(u,graph[u].get(i).v);
        }
    }
    public static int hamiltonianpath(int src,boolean[]arr,String ans,int no){
        if(no==N-1){
            System.out.println(ans);
            return 1;
        }
        int c=0;
        arr[src]=true;
        for(edge e:graph[src]){
            if(!arr[e.v]){
                c+=hamiltonianpath(e.v,arr,ans+e.v+" ",no+1);
            }
        }
        arr[src]=false;
        return c;
    }
    public static void main(String[]args){
        construct();
        display();
        // removeedge(2,3);
        // removevertex(4);
        // display();
        boolean[]arr=new boolean[N];
        // dfs(0,arr);
        System.out.println(hamiltonianpath(2,arr,"",0));
    }
}