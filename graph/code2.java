import java.util.ArrayList;

public class code2{
    public static int  N=8;
    public static ArrayList<Integer>[]graph=new ArrayList[N];
    public static void construct(){
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<Integer>();
        }
        addedge(1,0);
        addedge(3,1);
        addedge(2,1);
        addedge(5,2);
        addedge(6,3);
        addedge(5,4);
        addedge(6,4);
        addedge(7,5);
        addedge(7,6);
    }
    public static void addedge(int u,int v){
        graph[u].add(v);
    }
    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i+" -> ");
            for(int e:graph[i])
            System.out.print(e+" ,");
            System.out.println();
        }
    }
    public static void topographic(){
        ArrayList<Integer>arr=new ArrayList<>();
        boolean[]vis=new boolean[N];
        for(int i=0;i<N;i++){
            if(!vis[i])
            topo(7,vis,arr);
        }
        for(int i=0;i<arr.size();i++)
        System.out.println(arr.get(i));
    }
    public static void topo(int src,boolean[]vis,ArrayList<Integer> arr){
        vis[src]=true;

        for(int e:graph[src]){
            if(!vis[e])
            topo(e,vis,arr);
        }
        arr.add(src);
    }
    public static void main(String []args){
        construct();
        display();
        topographic();
    }
}