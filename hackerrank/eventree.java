import java.util.Scanner;
import java.util.ArrayList;
public class eventree{
    public static Scanner scn=new Scanner(System.in);
    public static ArrayList<Integer>[]graph;
    public static void main(String[]args){
        int n=scn.nextInt();
        int e=scn.nextInt();
        int e1=e;
        graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        graph[i]=new ArrayList<Integer>();
        while(e1-->0){
        int a=scn.nextInt();
        int b=scn.nextInt();
        graph[a].add(b);
        graph[b].add(a);
        }
        boolean[]vis=new boolean[n+1];
        vis[1]=true;
        bfs(1,vis);
        System.out.println(count);
    }
    public static int count=0;
    public static int bfs(int src,boolean[]vis){
        int c=0;
        int co=0;
        for(int e:graph[src]){  
            if(!vis[e]){
                vis[e]=true;
                c=bfs(e,vis);
                if(c%2==0){
                    // removeedge(e,src);
                    count++;
                    // return 0;    
                }
                else
                co+=c;
            }
        }       
        return co+1;
    }
    // public static void removeedge(int u,int v){
    //     for(int i=0;i<graph[u].size();i++){
    //         if(graph[u].get(i)==v)
    //         graph[u].remove(i);
    //     }
    //     for(int i=0;i<graph[v].size();i++){
    //         if(graph[v].get(i)==u)
    //         graph[v].remove(i);
    //     }
    // }
}