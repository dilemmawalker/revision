import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class hopping{

    public static Scanner scn=new Scanner(new InputStreamReader(System.in));
    public static void main(String[]args){
        int n=scn.nextInt();
        ArrayList<Integer>[]graph=new ArrayList[n+1];
        // ArrayList<Integer>[]ngraph=new ArrayList[n+1];     //reversed  
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
            // ngraph[i]=new ArrayList<Integer>();
        }
        int[]dp1=new int[n+1];
        int[]dp2=new int[n+1];
        int n1=n-1;
        int count=1;
        int count2=1;
        while(n1-->0){
            int a=scn.nextInt();
            if(a==1){
                graph[count].add(++count);
                // ngraph[++count2].add(count2-1);
            }
            else{
                graph[++count].add(count-1);
                // ngraph[count2].add(++count2);
            }
        }
        boolean[]vis1=new boolean[n+1];
        // boolean[]vis2=new boolean[n+1];
        
        for(int i=1;i<=n;i++){
            if(!vis1[i]){
                LinkedList<Integer>que=new LinkedList<>();
                que.addLast(i);
                bfs(i,vis1,graph,dp1,que,dp2,i);
            }
        }
        // for(int i=1;i<=n;i++){
        //     if(!vis2[i]){
        //         bfs(i,vis2,ngraph,dp2);
        //     }
        // }
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
    public static int bfs(int src,boolean[]vis,ArrayList<Integer>[]graph,int[]dp,LinkedList<Integer>que,int[]dp2,int osrc){
        vis[src]=true;
        int c=0;
        int co=0;
        if(dp[src]!=0){
            int rvtx=que.removeFirst();
            // if(dp2[rvtx]==0)
            // dp2[rvtx]=dp[src]+1;
            // else
            dp2[rvtx]+=dp[src];
        return dp[src];
        }
        for(int i=0;i<graph[src].size();i++){
            int e=graph[src].get(i);
            que.addLast(e);
            co=bfs(e,vis,graph,dp,que,dp2,osrc);
            c+=co;
            //
            if(i+1>=graph[src].size())
            break;
            if(src==osrc)
            que.addLast(osrc);
            int rvtx=que.removeFirst();
            if(dp2[rvtx]==0)
            dp2[rvtx]=co+1;
            else
            dp2[rvtx]+=co;
        }
        if(que.size()!=0){
        int m=que.removeFirst();
        if(dp2[m]!=0)
        dp2[m]=co+dp2[m];
        else
        dp2[m]=co+1;
        }
        return dp[src]=c+1;
    }
}