import java.util.Scanner;
import java.util.ArrayList;
public class hopping{

    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int n=scn.nextInt();
        ArrayList<Integer>[]graph=new ArrayList[n+1];
        ArrayList<Integer>[]ngraph=new ArrayList[n+1];     //reversed  
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
            ngraph[i]=new ArrayList<Integer>();
        }
        int[]dp1=new int[n+1];
        int[]dp2=new int[n+1];
        int n1=n-14;
        int count=1;
        int count2=1;
        while(n1-->0){
            int a=scn.nextInt();
            if(a==1){
                graph[count].add(++count);
                ngraph[++count2].add(count2-1);
            }
            else{
                graph[++count].add(count-1);
                ngraph[count2].add(++count2);
            }
        }
        boolean[]vis1=new boolean[n+1];
        boolean[]vis2=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis1[i]){
                vis1[i]=true;
                bfs(i,vis1,graph,dp1);
            }
        }
        for(int i=1;i<=n;i++){
            if(!vis2[i]){
                vis2[i]=true;
                bfs(i,vis2,ngraph,dp2);
            }
        }
        int q=scn.nextInt();
        boolean flag=true;
        while(q-->0){
            char ch=scn.next().charAt(0);
            if(ch=='U'){
                if(flag)
                flag=false;
                else
                flag=true;
            }else{
                int a=scn.nextInt();
                if(flag){
                    System.out.println(dp1[a]);
                }else{
                    System.out.println(dp2[a]);
                }
            }
        }
    }
    public static int bfs(int src,boolean[]vis,ArrayList<Integer>[]graph,int[]dp){
        vis[src]=true;
        int c=0;
        if(dp[src]!=0)
        return dp[src];
        for(int e:graph[src]){
            c+=bfs(e,vis,graph,dp);
        }
        return dp[src]=c+1;
    }
}