import java.util.ArrayList;
import java.util.LinkedList;
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
        // addedge(2,5,10);
        // addedge(6,7,10);
        // removeedge(6,7);
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
        bfs5(0);//
    }
}