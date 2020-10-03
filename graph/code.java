import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
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
        addedge(0,1,4);
        addedge(0,3,10);
        addedge(1,2,3);
        addedge(2,3,5);
        addedge(3,4,2);
        addedge(4,5,1);
        addedge(4,6,6);
        addedge(5,6,8);
        // addedge(2,5,10);
        // addedge(6,7,10);
        // removeedge(6,7);
    }
    public static void addedge(int u,int v,int w){
        graph[u].add(new edge(v,w));
        graph[v].add(new edge(u,w));
    }
    public static void display(ArrayList<edge>[]graph){
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
    public static int hamiltonianpath(int src,boolean[]arr,String ans,int no,int insrc){
        if(no==N-1){
            System.out.println(ans+src);
            for(edge e:graph[src]){
                if(e.v==insrc){
                    System.out.println("Hamiltonian Cycle:"+ ans+src);
                    break;
                }
            }
            return 1;
        }
        int c=0;
        arr[src]=true;
        for(edge e:graph[src]){
            if(!arr[e.v]){
                c+=hamiltonianpath(e.v,arr,ans+src+" ",no+1,insrc);
            }
        }
        arr[src]=false;
        return c;
    }
    public static void compo(int src,boolean[]arr){

        arr[src]=true;
        for(edge e:graph[src]){
            if(!arr[e.v]){
                compo(e.v,arr);
            }
        }
    }
    public static void noofcompo(){
        boolean[]arr=new boolean[N];
        int c=0;
        for(int i=0;i<N;i++){
            if(!arr[i]){
                c++;
                compo(i,arr);
            }
        }
        System.out.println(c);
    }
    public static void bfs(int src){    //basic bfs
        boolean[]vis=new boolean[N];
        int cycle=0;
        LinkedList<Integer>que=new LinkedList<>();
        que.addLast(src);
        while(que.size()!=0){
            int a=que.removeFirst();
            if(vis[a])
            cycle++;
            vis[a]=true;
            System.out.println(a);
            for(edge e:graph[a]){
                if(!vis[e.v])
                que.addLast(e.v);
            }
        }
        System.out.println("Cycle "+cycle);
    }
    public static void bfs2(int src){   //using null pointer
        boolean[]vis=new boolean[N];
        LinkedList<Integer>que=new LinkedList<>();
        que.add(src);
        que.add(-1);
        int level=0;
        int cycle=0;
        while(que.size()!=1){
            int a=que.removeFirst();
            if(a==-1){
            level++;
            que.addLast(-1);
            continue;
            }
            else{
                if(vis[a]){
                cycle++;
                continue;
                }
                vis[a]=true;
                System.out.println(a);
            }
            for(edge e:graph[a]){
                if(!vis[e.v])
                que.add(e.v);
            }
        }
        System.out.println("Cycle :"+cycle);
        System.out.println("Level :"+level);
    }
    public static class pair{
        int val=0;
        int lev=0;
        pair(int val,int lev){
            this.val=val;
            this.lev=lev;
        }
    }
    public static void bfs3(int src){   //using pair class
        boolean[]vis=new boolean[N];
        LinkedList<pair>que=new LinkedList<>();
        que.addLast(new pair(src,0));
        int level=0;
        int cycle=0;
        while(que.size()!=0){
            pair a=que.removeFirst();
            level=Math.max(level,a.lev);
            if(vis[a.val]){
                cycle++;
                continue;
            }
            vis[a.val]=true;
            System.out.println(a.val);
            for(edge e:graph[a.val]){
                if(!vis[e.v])
                que.addLast(new pair(e.v,a.lev+1));
            }
        }
        System.out.println("Cycle :"+cycle);
        System.out.println("Level :"+level);
    }
    public static void bfs4(int src){  //for non-cycle 
        boolean[]vis=new boolean[N];
        LinkedList<pair>que=new LinkedList<>();
        que.addLast(new pair(src,0));
        int level=0;
        int cycle=0;
        while(que.size()!=0){
            pair a=que.removeFirst();
            level=Math.max(level,a.lev);
            // if(vis[a.val]){
            //     cycle++;
            //     // continue;
            // }
            vis[a.val]=true;
            System.out.println(a.val);
            for(edge e:graph[a.val]){
                if(!vis[e.v]){
                    vis[e.v]=true;
                que.addLast(new pair(e.v,a.lev+1));
                }
            }
        }
        System.out.println("Cycle :"+cycle);
        System.out.println("Level :"+level);
    }
    public static void bfs5(int src){   //using 2 for loop
        LinkedList<Integer>que=new LinkedList<>();
        boolean[]vis=new boolean[N];
        int level=0;
        int cycle=0;
        que.addLast(src);
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int a=que.removeFirst();
                if(vis[a]){
                    cycle++;
                    continue;
                }
                vis[a]=true;
                System.out.println(a);
                for(edge e:graph[a]){
                    if(!vis[e.v])
                    que.addLast(e.v);
                }
            }
            level++;
        }
        System.out.println("Cycle :"+cycle);
        System.out.println("Level :"+level);
    }
    public class Solution {
        int[][]dir={{0,-1},{1,0},{0,1},{-1,0}};
        public void wallsAndGates(int[][] arr) {
            int n =arr.length;
            int m=arr[0].length;
            LinkedList<Integer>que=new LinkedList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==0){
                        que.addLast(i*m+j);
                    }
                }
            }
            int level=1;
            while(que.size()!=0){
                int size=que.size();
                while(size-->0){
                    int a=que.removeFirst();
                    for(int i=0;i<4;i++){
                        int r=a/m+dir[i][0];
                        int c=a%m+dir[i][1];
                        if(r>=0 && c>=0 && r<n && c<m && arr[r][c]==2147483647){
                            arr[r][c]=level;
                            que.addLast(r*m+c);
                        }
                    }
                }
                level++;
            }
        }
    }
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
    public static void kruskal(int[][]arr){
        ArrayList<edge>[]ngraph=new ArrayList[N];
        for(int i=0;i<N;i++)
        ngraph[i]=new ArrayList<>();

        Arrays.sort(arr,(int[]a,int[]b)->{
            return a[2]-b[2];
        });

        
        for(int []ar:arr){
            int a=findpar(ar[0]);
            int b=findpar(ar[1]);
            if(a!=b){
                ngraph[ar[0]].add(new edge(ar[1],ar[2]));
                ngraph[ar[1]].add(new edge(ar[0],ar[2]));
                mergeset(a,b);
            }
        }
        display(ngraph);
    }
    public static class dpair{
        int src=0;
        int p=0;
        int w=0;
        int wsf=0;
        dpair(int src,int p,int w,int wsf){
            this.src=src;
            this.p=p;
            this.w=w;
            this.wsf=wsf;
        }
    }
    public static void dijkstra(int src){
        ArrayList<edge>[]dgraph=new ArrayList[N];
        boolean[]vis=new boolean[N];
      PriorityQueue<dpair>que=new PriorityQueue<>((dpair a,dpair b)->{
          return a.wsf=b.wsf;
      });
      for(int i=0;i<N;i++)
      dgraph[i]=new ArrayList<edge>();
      que.add(new dpair(src,-1,0,0));
      while(que.size()!=0){
        dpair rvtx=que.remove();
        if(vis[rvtx.src])
        continue;
        vis[rvtx.src]=true;
        if(rvtx.p!=-1){
            dgraph[rvtx.p].add(new edge(rvtx.src,rvtx.w));
        }
        for(edge e:graph[rvtx.src]){
            if(!vis[e.v])
            que.add(new dpair(e.v,rvtx.src,e.w,e.w+rvtx.wsf));
        }
      }
      display(dgraph);
    }
    public static void prims(){
        ArrayList<edge>[]pgraph=new ArrayList[N];
        PriorityQueue<dpair>pq=new PriorityQueue<>((dpair a,dpair b)->{
           return a.w-b.w;
        });
        for(int i=0;i<N;i++)
        pgraph[i]=new ArrayList<>();
        boolean []vis=new boolean[N];
        pq.add(new dpair(0,-1,0,0));
        while(pq.size()!=0){
            dpair rvtx=pq.remove();
            if(vis[rvtx.src])
            continue;

            vis[rvtx.src]=true;
            if(rvtx.p!=-1)
            pgraph[rvtx.p].add(new edge(rvtx.src,rvtx.w));

            for(edge e:graph[rvtx.src]){
                if(!vis[e.v])
                pq.add(new dpair(e.v,rvtx.src,e.w,0));
            }
        }
        display(pgraph);
    }
    public static class pair_new{
        int dis=0;
        int rank=0;
        pair_new(int dis,int rank){
            this.dis=dis;
            this.rank=rank;
        }
    }
    public static int count_arti=0;
    public static void articulation_point(){
         pair_new[]data=new pair_new[N];
        for(int i=0;i<N;i++){
            data[i]=new pair_new(0,0);
        }
        arti(0,data,0,new boolean[N]);
        System.out.println("No. of Articulation Points: "+count_arti);
    }
    public static int coo=0;
    public static void arti(int src,pair_new []data,int idx,boolean []vis){

        data[src].dis=coo;
        data[src].rank=coo++;
        vis[src]=true;
        boolean flag=false;
        for(edge e:graph[src]){
            if(!vis[e.v]){
            arti(e.v,data,idx+1,vis);
            data[src].rank=Math.min(data[src].rank,data[e.v].dis);
            if(data[src].dis<=data[e.v].rank)
            flag=true;
            }
        }
        
        if(flag)
        count_arti++;
    }
   

    public static void main(String[]args){
        construct();
        // display();
        // removeedge(2,3);
        // removevertex(4);
        // display();
        // boolean[]arr=new boolean[N];
        // dfs(0,arr);
        // System.out.println(hamiltonianpath(2,arr,"",0,2));
        // noofcompo();
        // bfs5(0);
        // initialize_union_find();
        // int[][]arr={{0,1,10},{0,3,10},{1,2,10},{2,3,10},{3,4,2},{4,5,2},{4,6,3},{5,6,8}};
        // kruskal(arr);
        // dijkstra(3);
        // prims();
        articulation_point();
    }
}