import java.util.ArrayList;
import java.util.LinkedList;

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
        // addedge(1,6);
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
        for(int i=arr.size()-1;i>=0;i--)
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
    public static void khans(){
        LinkedList<Integer>arr=new LinkedList<>();
        LinkedList<Integer>ar1=new LinkedList<>();
        int c=0;
        int[]ar=new int[N];
        for(int i=0;i<N;i++){
            for(int e:graph[i]){
                ar[e]++;
            }
        }
        for(int i=0;i<N;i++)
        if(ar[i]==0){
        arr.addLast(i);
        c++;
        }

        while(arr.size()!=0){
            int a=arr.removeFirst();
            ar1.addLast(a);
            for(int e:graph[a]){
                if(--ar[e]==0){
                    arr.addLast(e);
                    c++;
                }
            }
        }
        if(c==N)
        System.out.println("true");
        else
        System.out.println("false");
        for(int i=0;i<ar1.size();i++)
        System.out.println(ar1.get(i));
    }
    public static boolean khans_d(int src,int []vis){
        if(vis[src]==1)
        return true;  //true means presence of cycle
        if(vis[src]==2)
        return false;

        System.out.println(src);
        boolean res=false;
        vis[src]=1;
        for(int e:graph[src])
        res=res||khans_d(e,vis);

        vis[src]=2;
        return res;
    }
    public static void khans_dfs(){
        int[]vis=new int[N];
        boolean res=false;
        for(int i=0;i<N;i++){
        if(vis[i]==0)
        res=res||khans_d(i,vis);
        }
        if(res)
        System.out.println("Cycle");
        else
        System.out.println("not cycle");
    }

    //union find
    public static int[]par=new int[N];
    public static int[]size=new int[N];
    public static void initialize_union_find(){
        for(int i=0;i<N;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    public static void mergeset(int a,int b){
        if(size[a]>size[b]){
            par[b]=a;
            size[a]+=size[b];
        }
        else{
            par[a]=b;
            size[b]+=size[a];
        }
    }
    public static int findpar(int vtx){
        if(par[vtx]==vtx)
        return vtx;

        return par[vtx]=findpar(par[vtx]);//path compression
    } 
    public static void display_union(){
        for(int i=0;i<N;i++)
        System.out.print(par[i]+" ");
        System.out.println();
        for(int i=0;i<N;i++)
        System.out.print(size[i]+" ");
    }
    public static void union_find(){
        initialize_union_find();
        for(int i=0;i<graph.length;i++){
            for(int e:graph[i])
            if(findpar(i)!=findpar(e))
           mergeset(findpar(e),findpar(i));
        }
        display_union();
    }

    public static void main(String []args){
        construct();
        // display();
        // topographic();
        // khans_dfs();
        union_find();
    }
}