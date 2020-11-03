import java.util.*;
import java.io.*;
public class d{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][]arr=new int[n][m];
        for(int i=0;i<n;i++){
           String str=scn.next();
           for(int j=0;j<m;j++){
               char ch=str.charAt(j);
               arr[i][j]=ch-'a';
           }
        }
        int count=0;
        count=n*m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count+=bfs(arr,i,j);
            }
        }
        System.out.println(count);
    }
    public static int[][]dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static  class pair{
        int a=0;
        int b=0;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public static int bfs(int[][]arr,int i,int j){
        LinkedList<pair>que=new LinkedList<pair>();
        int n=arr.length;
        int m=arr[0].length;
        boolean[][]vis=new boolean[n][m];
        que.addLast(new pair(i,j));
        int level=0;
        boolean flag=true;
        while(que.size()!=0 ){
            int size=que.size();
            while(size-->0){
                pair rvtx=que.removeFirst();
                for(int k=0;k<4;k++){
                    int r=rvtx.a+dir[k][0];
                    int c=rvtx.b+dir[k][1];
                    if(r>=0 && c>=0 && r<n && c<m && arr[rvtx.a][rvtx.b]==arr[r][c]){
                        if(!vis[r][c]){
                            vis[r][c]=true;
                        que.addLast(new pair(r,c));
                        }
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
            }
            if(!flag)
            break;

            level++;
        }
        return level;
    }
}