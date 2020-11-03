import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class code{
    public static Scanner scn=new Scanner(System.in);
    public static void increasing(int a,int b){
        if(a==b)
        return;

        System.out.print(a+" ");
        increasing(a+1,b);
    }
    public static void decreasing(int a,int b){                        
        if(a==b)
        return;

        decreasing(a+1,b);
        System.out.print(a+" ");
    }
    public static void evenodd(int a,int b){
        if(a==b)
        return;

        if(a%2==0)
        System.out.print(a+" ");
        evenodd(a+1,b);
        if(a%2!=0)
        System.out.print(a+" ");
        return;
    }
    public static int fact(int a,int b){
        if(a==b)
        return a;

        int c=1;
        c=fact(a+1,b);
        return c*a;
    }
    // public static void display(int vidx, int []arr){
    //     if(vidx==arr.length)
    //     return;

    //     System.out.print(arr[vidx]+" ");
    //     display(vidx+1,arr);
    // }
    public static boolean find(int vidx, int []arr,int a){
        if(vidx==arr.length)
        return false;

        if(a==arr[vidx])
        return true;
        boolean flag=false;
       flag= find(vidx+1,arr,a);
       return flag;
    }
    public static int max(int vidx,int []arr){
        if(vidx==arr.length)
        return 0;

        int a=0;
        return Math.max(arr[vidx],max(vidx+1,arr));
    }
    // public static ArrayList<String>aaa=new ArrayList<>();
    public static void subseq(String str,int idx,String ans){
        if(idx==str.length())
        {
           System.out.print(ans+" ");
            return;
        }

        subseq(str,idx+1,ans);
        subseq(str,idx+1,ans+str.charAt(idx));
    }

    public static ArrayList<String> subseq_ret(String str,int idx,String ans){
        if(idx==str.length())
        {
           ArrayList<String>arr=new ArrayList<>();
           arr.add(ans);
            return arr;
        }

        ArrayList<String>a=subseq_ret(str,idx+1,ans);
        ArrayList<String>b=subseq_ret(str,idx+1,ans+str.charAt(idx));
        ArrayList<String>ab=new ArrayList<>();
        ab.addAll(a);
        ab.addAll(b);
        return ab;
    }
    public static ArrayList<String> subseq_ret1(String str,int idx){
        if(str.length()==idx)
        {
           ArrayList<String>arr=new ArrayList<>();
           arr.add("");
            return arr;
        }

        ArrayList<String>a=subseq_ret1(str,idx+1);
        ArrayList<String>ab=new ArrayList<>();
        
        for(String s:a){
            ab.add(s);
            ab.add(str.charAt(idx)+s);
        }
        
        return ab;
    }
    
    public static ArrayList<String> permu(String str,int idx){
        if(idx==str.length()){
            ArrayList<String>a=new ArrayList<>();
            a.add("");
            return a;
        }

        ArrayList<String>arr=permu(str,idx+1);
        ArrayList<String>ans=new ArrayList<>();
        char ch=str.charAt(idx);
        for(String s:arr){
           for(int i=0;i<=s.length();i++){
               ans.add(s.substring(0,i)+ch+s.substring(i));
           }
        }
        return ans;
    }

    public static void permu_new(String str,int idx,String ans){
        if(idx==str.length()){
            System.out.print(ans+" ");
            return;
        }

        char ch=str.charAt(idx);
        for(int i=0;i<=ans.length();i++){
            permu_new(str,idx+1,ans.substring(0,i)+ch+ans.substring(i));
        }
    }
    public static void permu_new1(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String nstr=str.substring(0,i)+str.substring(i+1);
            permu_new1(nstr,ans+ch);
        }

    }
    public static void permu_new1_non_repeat(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            return;
        }
        boolean vis[]=new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String nstr=str.substring(0,i)+str.substring(i+1);
            if(!vis[ch-'a']){
                vis[ch-'a']=true;
                permu_new1_non_repeat(nstr,ans+ch);
            }
        }

    }
    public static String[] st={"yz",":;,","abc","def","ghi","jkl","mno","pqrs","uv","wx","*#@","+-*"};
    public static void keypad(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<st[str.charAt(0)-'0'].length();i++){
        char ch=st[str.charAt(0)-'0'].charAt(i);    
        keypad(str.substring(1),ans+ch);
        }
    }     
    public static void keypad_permu(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<st[str.charAt(0)-'0'].length();i++){
        char ch=st[str.charAt(0)-'0'].charAt(i);    
        for(int j=0;j<=ans.length();j++){

        keypad_permu(str.substring(1),ans.substring(0,j)+ch+ans.substring(j));
        }
        }
    }
    public static ArrayList<String> keypad_permu_ret(String str,String ans){
        if(str.length()==0){
           ArrayList<String>anss=new ArrayList<>();
           anss.add(ans);
            return anss;
        }
        ArrayList<String>ansss=new ArrayList<>();
        for(int i=0;i<st[str.charAt(0)-'0'].length();i++){
        char ch=st[str.charAt(0)-'0'].charAt(i);    
        for(int j=0;j<=ans.length();j++){

        ArrayList<String>a=keypad_permu_ret(str.substring(1),ans.substring(0,j)+ch+ans.substring(j));
        ansss.addAll(a);
        }
        }
        return ansss;
    }

    public static void keypad_permu_ret_without_dupli(String str,String ans){                                 
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        int vis=0;
        for(int i=0;i<str.length();i++){
           
            String s=st[str.charAt(i)-'0'];
            for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            int mask=1<<(ch-'a');
            if((vis & mask)==0){
                vis=vis|mask;
                keypad_permu_ret_without_dupli(str.substring(0,i)+str.substring(i+1),ans+ch);
            }
            }
        }
    }

    //keypad main
    public static void keypad_real(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch=str.charAt(0);
        if(ch=='1' && str.length()>=2){
            char chh=str.charAt(1);
            if(chh=='1'){
                for(int i=0;i<st[11].length();i++){
                    char c=st[11].charAt(i);    
                    keypad_real(str.substring(2),ans+c);
                }
            }
            if(chh=='0'){
                for(int i=0;i<st[10].length();i++){
                    char c=st[10].charAt(i);    
                    keypad_real(str.substring(2),ans+c);
                }
            }
        }
        for(int i=0;i<st[ch-'0'].length();i++){
            char c=st[ch-'0'].charAt(i);    
            keypad_real(str.substring(1),ans+c);
        }
    }
    public static ArrayList<String> keypad_2(String str){  
        if(str.length()==0){
            ArrayList<String>arr=new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String>ans=new ArrayList<>();
        ArrayList<String>a=keypad_2(str.substring(1));

        String s=st[str.charAt(0)-'0'];
        for(int ch=0;ch<s.length();ch++){
            for(String ss:a){
                ans.add(s.charAt(ch)+ss);
            }
        }
        return ans;
    }
    public static int multi(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
        return 1;
        }
        
        int c=0;
        if(sr+1<=er)
        c+=multi(sr+1,sc,er,ec,ans+"V");
        if(sc+1<=ec)
        c+=multi(sr,sc+1,er,ec,ans+"H");

        return c;
    }
    public static ArrayList<String> multi_ret(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
           ArrayList<String>arr=new ArrayList<>();
           arr.add(ans);
           return arr;
        }
        ArrayList<String>a=new ArrayList<>();
        if(sr+1<=er)
        a.addAll(multi_ret(sr+1,sc,er,ec,ans+"V"));
        if(sc+1<=ec)
        a.addAll(multi_ret(sr,sc+1,er,ec,ans+"H"));

        return a;
    }
    public static int multi_diag(int sr,int sc,int er,int ec,String ans,int[][]dp){
        if(sr==er && sc==ec){
            System.out.println(ans);
            dp[sr][sc]=1;
        return 1;
        }
        if(dp[sr][sc]!=0)
        return dp[sr][sc];
        
        int c=0;
        if(sr+1<=er)
        c+=multi_diag(sr+1,sc,er,ec,ans+"V",dp);
        if(sc+1<=ec)
        c+=multi_diag(sr,sc+1,er,ec,ans+"H",dp);
        if(sr+1<=er && sc+1<=ec)
        c+=multi_diag(sr+1,sc+1,er,ec,ans+"D",dp);

        return dp[sr][sc]=c;
    }
    public static int multi_diag_tab(int sr,int sc,int er,int ec,String ans,int[][]dp){
        for(sr=er;sr>=0; sr--){
            for(sc=ec;sc>=0;sc--){
        
                if(sr==er && sc==ec){
                    dp[sr][sc]=1;
                    continue;
                }

        int c=0;
        if(sr+1<=er)
        c+=dp[sr+1][sc];
        if(sc+1<=ec)
        c+=dp[sr][sc+1];
        if(sr+1<=er && sc+1<=ec)
        c+=dp[sr+1][sc+1];

        dp[sr][sc]=c;
            }}

        return dp[0][0];
    }

    public static int maze_multi(int sr,int sc,int er,int ec, String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=1;i<=er && sr+i<=er;i++)
        c+=maze_multi(sr+i,sc,er,ec,ans+"V"+i);
        for(int i=1;i<=ec && sc+i<=ec;i++)
        c+=maze_multi(sr,sc+i,er,ec,ans+"H"+i);
        for(int i=1;sr+i<=er && sc+i<=ec ;i++)
        c+=maze_multi(sr+i,sc+i,er,ec,ans+"D"+i);

        return c;
    }
    //direction array
    public static int[][]dir={{1,0},{0,1},{-1,0},{0,-1},{-1,1},{1,1},{1,-1},{-1,-1}};
    public static String[]ndir={"S","E","N","W","N-E","S-E","S-W","N-W"};
    public static int mazepath_4dir(int sr,int sc,int er,int ec,int[][]arr,String ans){
        if(sr==er && sc==ec){
            // System.out.println(ans);
            return 1;
        }
        arr[sr][sc]=1;
        int c=0;
        for(int i=0;i<4;i++){
            int x=sr+dir[i][0];
            int y=sc+dir[i][1];
            if(x<=er && y<=ec && x>=0 && y>=0 && arr[x][y]!=1)
            c+=mazepath_4dir(x,y,er,ec,arr,ans);
        }
        arr[sr][sc]=0;
        return c;
    }
    public static int mazepath_8dir(int sr,int sc,int er,int ec,int[][]arr,String ans){
        if(sr==er && sc==ec){
            // System.out.println(ans);
            return 1;
        }
        arr[sr][sc]=1;
        int c=0;
        for(int i=0;i<8;i++){
            int x=sr+dir[i][0];
            int y=sc+dir[i][1];
            if(x<=er && y<=ec && x>=0 && y>=0 && arr[x][y]!=1)
            c+=mazepath_8dir(x,y,er,ec,arr,ans);
        }
        arr[sr][sc]=0;
        return c;
    }
    public static int mazepath_8dir_multi(int sr,int sc,int er,int ec,int[][]arr,String ans){
        if(sr==er && sc==ec){
            // System.out.println(ans);
            return 1;
        }
        arr[sr][sc]=1;
        int c=0;

        for(int j=1;j<=er && j<=ec;j++)
        for(int i=0;i<8;i++){
            int x=sr+dir[i][0]*j;
            int y=sc+dir[i][1]*j;
            if(x<=er && y<=ec && x>=0 && y>=0 && arr[x][y]!=1)
            c+=mazepath_8dir_multi(x,y,er,ec,arr,ans);
        }
        arr[sr][sc]=0;
        return c;
    }

    public static int numIslands(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='1'){
                    c++;
                    arr[i][j]='0';
                    islands(arr,i,j);
                }
            }
        }
        return c;
    }
    public static void islands(char[][]arr,int r,int c){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<4;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(x>=0 && y>=0 && x<n && y<m && arr[x][y]=='1'){
                arr[x][y]='0';
                islands(arr,x,y);
            }
        }
    }

    public static void display(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static class mypair{
        int max=0;
        int min=1000000;
        String str="";
        String str2="";
        mypair(int max,int min,String str,String str2){
            this.max=max;
            this.min=min;
            this.str=str;
            this.str2=str2;
        }
    }
    public static mypair floodfill_height(int sr,int sc,int er,int ec,int[][]board){
        if(sr==er && sc==ec){
            return new mypair(0,0,"","");
        }

        board[sr][sc]=1;
        mypair max=new mypair(0,1000000,"","");
        for(int i=0;i<8;i++){
            int x=sr+dir[i][0];
            int y=sc+dir[i][1];
            if(x>=0 && y>=0 && x<=er && y<=ec && board[x][y]!=1){
                // board[x][y]=1;
                mypair nmax=floodfill_height(x,y,er,ec,board);
                if(max.max<nmax.max){
                    max.max=nmax.max;
                    max.str=ndir[i]+" "+nmax.str;
                }
                if(nmax.min<max.min){
                    max.min=nmax.min;
                    max.str2=ndir[i]+" "+nmax.str2;
                }
                // board[x][y]=0;
            }
        }
        board[sr][sc]=0;
        max.max++;
        max.min++;
        return max;
    }
    //coin change
    public static void coin_permu(int[]arr,int tar,String ans){
        if(tar<0)
        return ;
        if(tar==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            coin_permu(arr,tar-a,ans+" "+a);
        }
    }
    public static ArrayList<String> coin_permu1(int[]arr,int tar,String ans,boolean[]vis){
        if(tar==0){
            ArrayList<String>ar=new ArrayList<>();
            ar.add(ans);
            return ar;
        }

        ArrayList<String>aa=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            if(tar-a>=0 && vis[i]==false){
                vis[i]=true;
                aa.addAll(coin_permu1(arr,tar-a,ans+a,vis));
                vis[i]=false;
            }
        }
        return aa;
    }

    public static int combi_infi(int[]arr,int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=idx;i<arr.length;i++){
            int a=arr[i];
            if(tar-a>=0)
            c+=combi_infi(arr,tar-a,i,ans+a);
        }
        return c;
    }
    public static void combi_1coin(int[]arr,int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
        }

        for(int i=idx;i<arr.length;i++){
            int a=arr[i];
            if(tar-a>=0){
                combi_1coin(arr,tar-a,i+1,ans+a);
            }
        }
    }

    //subsequence
    public static int coin_permu_infi_subseq(int[]arr,int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx>=arr.length)
        return 0;

        int c=0;
        int a=arr[idx];
        if(tar-a>=0)
        c+=coin_permu_infi_subseq(arr,tar-a,0,ans+a);
        c+=coin_permu_infi_subseq(arr,tar,idx+1,ans);

        return c;
    }

    public static int coin_permu_one_subseq(int[]arr,int tar,int idx,String ans,boolean[]vis){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx>=arr.length)
        return 0;
        

        int c=0;
        if(tar-arr[idx]>=0 && vis[idx]==false){
            vis[idx]=true;
        c+=coin_permu_one_subseq(arr,tar-arr[idx],0,ans+arr[idx],vis);
            vis[idx]=false;
        }
        c+=coin_permu_one_subseq(arr,tar,idx+1,ans,vis);
        return c;
    }

    public static int coin_combi_infi_subseq(int[]arr,int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx>=arr.length)
        return 0;

        int c=0;
        if(tar-arr[idx]>=0)
        c+=coin_combi_infi_subseq(arr,tar-arr[idx],idx,ans+arr[idx]);
        c+=coin_combi_infi_subseq(arr,tar,idx+1,ans);

        return c;
    }

    public static int coin_combi_one_subseq(int[]arr,int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx>=arr.length)
        return 0;
        

        int c=0;
        if(tar-arr[idx]>=0)
        c+=coin_combi_one_subseq(arr,tar-arr[idx],idx+1,ans+arr[idx]);
        c+=coin_combi_one_subseq(arr,tar,idx+1,ans);
        return c;
    }
    //nqueen
    public static int queen(int box,int tnq,int qpsf,int idx,boolean[]vis,String ans){
        if(idx==vis.length){
            if(qpsf==tnq){
                System.out.println(ans);
                return 1;
            }
            else
            return 0;
        }

        int c=0;
        if(tnq-1>=0 && vis[idx]==false){
            vis[idx]=true;
            c+=queen(box-1,tnq,qpsf+1,0,vis,ans+"b"+idx+"q"+qpsf+" ");
            vis[idx]=false;
        }
        c+=queen(box+1,tnq,qpsf,idx+1,vis,ans);

        return c;
    }

    public static int queen_combi(int box,int tnq,int qpsf,int idx,boolean[]vis,String ans){
        if(idx==vis.length){
            if(qpsf==tnq){
                System.out.println(ans);
                return 1;
            }
            else
            return 0;
        }

        int c=0;
        if(tnq-1>=0){
            vis[idx]=true;
            c+=queen_combi(box-1,tnq,qpsf+1,idx+1,vis,ans+"b"+idx+"q"+qpsf+" ");
            vis[idx]=false;
        }
        c+=queen_combi(box+1,tnq,qpsf,idx+1,vis,ans);
        return c;
    }

    public static int queen_permu_rec(int box,int tnq,int qpsf,int idx,boolean[]vis,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=0;i<box;i++){
            if(!vis[i]){
                vis[i]=true;
                c+=queen_permu_rec(box,tnq,qpsf+1,0,vis,ans+"b"+i+"q"+qpsf+" ");
                vis[i]=false;
            }
        }
        return c;
    }

    public static int queen_combi_rec(int box,int tnq,int qpsf,int idx,boolean[]vis,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=idx;i<box;i++){
            c+=queen_combi_rec(box,tnq,qpsf+1,i+1,vis,ans+"b"+i+"q"+qpsf+" ");
        }
        return c;
    }
    public static int nqueen_1_permu(int n,int m,int tnq,int qpsf,int idx,boolean [][]vis,String ans){  
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=0;i<n*m;i++){
            int x=i/m;
            int y=i%m;
            if(!vis[x][y]){
            vis[x][y]=true;
            c+=nqueen_1_permu(n,m,tnq,qpsf+1,0,vis,ans+"("+x+","+y+")");
            vis[x][y]=false;
            }
        }
        return c;
    }

    //NQUEEN    
    public static int nqueen_combi(int n,int m,int tnq,int qpsf,int idx,boolean [][]vis,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        // if(idx>n*m)
        // return 0;

        int c=0;
        for(int i=idx;i<n*m;i++){
            int x=i/m;
            int y=i%m;
           
                boolean flag=false;
                for(int j=y-1;j>=0;j--){
                    if(vis[x][j])
                    flag=true;
                }
                for(int j=x-1;j>=0;j--){
                    if(vis[j][y])
                    flag=true;
                }
                for(int j=y-1,k=x-1;j>=0 && k>=0;j--,k--){
                    if(vis[k][j])
                    flag=true;
                }
                for(int j=x-1,k=y+1;j>=0 && k<m;j--,k++){
                    if(vis[j][k])
                    flag=true;
                }
                if(!flag){
                    vis[x][y]=true;
                    c+=nqueen_combi(n,m,tnq,qpsf+1,i+1,vis,ans+"("+x+","+y+") ");
                    vis[x][y]=false;
                }
        }
        return c;
    }

    public static int nqueen_permu(int n,int m,int tnq,int qpsf,int idx,boolean [][]vis,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        int c=0;
        for(int i=0;i<n*m;i++){
            int x=i/m;
            int y=i%m;
                if(!vis[x][y]){
                boolean flag=false;
                
                for(int j=0;j<8;j++){
                    for(int mag=1;mag<Math.max(n,m);mag++){
                    int r=x+mag*dir[j][0];
                    int col=y+mag*dir[j][1];
                        if(r>=0 && col>=0 && r<n && col<m){
                            if(vis[r][col]){
                                flag=true;
                                break;
                            }
                        }
                    }
                }
                if(!flag){
                    vis[x][y]=true;
                    c+=nqueen_permu(n,m,tnq,qpsf+1,i+1,vis,ans+"("+x+","+y+") ");
                    vis[x][y]=false;
                }
            }
        }
        return c;
    }

    public static int[]row;
    public static int[]col;
    public static int[]diag;
    public static int[]adiag;
    // public static int nqueen2(int n,int m,int tnq,int qpsf,int idx,String ans){
    //     if(qpsf==tnq){
    //         System.out.println(ans);
    //         return 1;
    //     }

    //     int c=0;
    //     for(int i=idx;i<n*m;i++){
    //         int x=i/m;
    //         int y=i%m;
    //         if(!row[x] && !col[y] && !diag[x-y+m-1] && !adiag[x+y]){
    //             row[x]=true;
    //             col[y]=true;
    //             diag[x-y+m-1]=true;
    //             adiag[x+y]=true;
    //             c+=nqueen2(n,m,tnq,qpsf+1,i+1,ans+"("+x+","+y+") ");
    //             row[x]=false;
    //             col[y]=false;
    //             diag[x-y+m-1]=false;
    //             adiag[x+y]=false;
    //         }
    //     }
    //     return c;
    // }

    // public static int nqueen2_permu(int n,int m,int tnq,int qpsf,int idx,String ans){
    //     if(qpsf==tnq){
    //         System.out.println(ans);
    //         return 1;
    //     }

    //     int c=0;
    //     for(int i=0;i<n*m;i++){
    //         int x=i/m;
    //         int y=i%m;
    //         if(!row[x] && !col[y] && !diag[x-y+m-1] && !adiag[x+y]){
    //             row[x]=true;
    //             col[y]=true;
    //             diag[x-y+m-1]=true;
    //             adiag[x+y]=true;
    //             c+=nqueen2_permu(n,m,tnq,qpsf+1,i+1,ans+"("+x+","+y+") ");
    //             row[x]=false;
    //             col[y]=false;
    //             diag[x-y+m-1]=false;
    //             adiag[x+y]=false;
    //         }
    //     }
    //     return c;
    // }
    public static int row1=0;
    public static int col1=0;
    public static int diag1=0;
    public static int adiag1=0;
    public static int nqueen3(int n,int m,int tnq,int qpsf,int idx,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=idx;i<n*m;i++){
            int x=i/m;
            int y=i%m;
            if(((row1 & (1<<x))==0) && ((col1 & (1<<y))==0) && ((diag1 & (1<<(x-y+m-1)))==0) && ((adiag1 & (1<<(x+y)))==0)){
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
                c+=nqueen3(n,m,tnq,qpsf+1,i+1,ans+"("+x+","+y+") ");
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
            }
        }
        return c;
    }
    public static int nqueen3_permu(int n,int m,int tnq,int qpsf,int idx,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }

        int c=0;
        for(int i=0;i<n*m;i++){
            int x=i/m;
            int y=i%m;
            if(((row1 & (1<<x))==0) && ((col1 & (1<<y))==0) && ((diag1 & (1<<(x-y+m-1)))==0) && ((adiag1 & (1<<(x+y)))==0)){
                row1 |=(1<<x);
                col1 |= (1<<y);
                diag1 |= (1<<(x-y+m-1));
                adiag1 |= (1<<(x+y));
                c+=nqueen3_permu(n,m,tnq,qpsf+1,i+1,ans+"("+x+","+y+") ");
                row1 &=~(1<<x);
                col1 &= ~(1<<y);
                diag1 &= ~(1<<(x-y+m-1));
                adiag1 &= ~(1<<(x+y));
            }
        }
        return c;
    }

    public static int nqueen4(int n,int m,int tnq,int qpsf,int idx,String ans){    //only by combination(when no. of queen==no. of houses(n))
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        if(idx>=n)
        return 0;

        int c=0;
        for(int i=0;i<m;i++){
            int x=idx;
            int y=i;
            if(((row1 & (1<<x))==0) && ((col1 & (1<<y))==0) && ((diag1 & (1<<(x-y+m-1)))==0) && ((adiag1 & (1<<(x+y)))==0)){
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
                c+=nqueen4(n,m,tnq,qpsf+1,idx+1,ans+"("+x+","+y+") ");
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
            }
        }
        return c;
    }

    public static int nqueen4_generic(int n,int m,int tnq,int qpsf,int idx,String ans){    //generic code using subsequence method in case no. of queens < n
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        if(idx>=n)
        return 0;

        int c=0;
        for(int i=0;i<m;i++){
            int x=idx;
            int y=i;
            if(((row1 & (1<<x))==0) && ((col1 & (1<<y))==0) && ((diag1 & (1<<(x-y+m-1)))==0) && ((adiag1 & (1<<(x+y)))==0)){
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
                c+=nqueen4_generic(n,m,tnq,qpsf+1,idx+1,ans+"("+x+","+y+") ");
                row1^=(1<<x);
                col1 ^= (1<<y);
                diag1 ^= (1<<(x-y+m-1));
                adiag1 ^= (1<<(x+y));
            }
        }
        c+=nqueen4_generic(n,m,tnq,qpsf,idx+1,ans);
        return c;
    }

    public static boolean is_safe_sudoku(int x,int y,int arr[][],int num){
        
        if((row[x] & (1<<(num)))!=0)
        return false;
        if((col[y] & (1<<(num)))!=0)
        return false;
        if((diag[((x/3)*3)+y/3] & (1<<(num)))!=0)
        return false;
        return true;
    }

    public static boolean sudoku(int[][]arr,int i,int j){
        if(i==arr.length){
            display(arr);
            return true;
        }

        boolean flag=false;
                if(arr[i][j]==-1) { 
                for(int k=1;k<10;k++){
                    boolean a=is_safe_sudoku(i,j,arr,k);
                    if(a){
                        arr[i][j]=k;
                        row[i]^=(1<<k);
                        col[j]^=(1<<k);
                        diag[(i/3)*3+j/3] ^=(1<<k);
                        if(j==arr[0].length-1)
                        flag=flag||sudoku(arr,i+1,0);
                        else
                        flag=flag||sudoku(arr,i,j+1);
                        arr[i][j]=-1;
                        row[i]^=(1<<k);
                        col[j]^=(1<<k);
                        diag[(i/3)*3+j/3]^=(1<<k);
                }
                }
            }
                else if(j==arr[0].length-1)
                flag=flag||sudoku(arr,i+1,0);
                else
                flag=flag||sudoku(arr,i,j+1);
        return flag;
    }

    public static HashSet<String>map;
    public static int wordbreak(String str,String ans,int idx){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }
        if(idx==str.length()+1){
            return 0;
        }

        int c=0;
        String s=str.substring(0,idx);
        if(map.contains(s)){
            c+=wordbreak(str.substring(idx),ans+s+" ",0);
        }
        c+=wordbreak(str,ans,idx+1);
        return c;
    }
    public static int crypto(String str,int[]arr,int idx,String str1,String str2,String str3,int bits){
        if(idx==str.length()){
            int num1=0;
            for(int i=0;i<str1.length();i++){
                char ch=str1.charAt(i);
                num1=(num1*10)+arr[ch-'a'];
            }
            int num2=0;
            for(int i=0;i<str2.length();i++){
                char ch=str2.charAt(i);
                num2=(num2*10)+arr[ch-'a'];
            }
            int num3=0;
            for(int i=0;i<str3.length();i++){
                char ch=str3.charAt(i);
                num3=(num3*10)+arr[ch-'a'];
            }
            if((num1+num2)==num3){
                System.out.println(num1);
                System.out.println(num2);
                System.out.println(num3);
                System.out.println();
                return 1;
            }
            return 0;
        }

        int c=0;
        char ch=str.charAt(idx);
        for(int i=0;i<=9;i++){
            int mask=(1<<i);
            if((bits & mask)==0){
                bits^=mask;
                arr[ch-'a']=i;
                c+=crypto(str,arr,idx+1,str1,str2,str3,bits);
                 arr[ch-'a']=0;
                bits^=mask;
            }
        }
        return c;
    }

    // public static void co(String str2,int[]arr){
    //     int num2=0;
    //         for(int i=0;i<str2.length();i++){
    //             char ch=str2.charAt(i);
    //             num2=(num2*10)+arr[ch-'a'];
    //         }
    //         System.out.println(num2);
    // }

    public static void crypto_arithmetic(String str1,String str2,String str3){
        String str=str1+str2+str3;
        int bits=0;
        String ans="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int mask=(1<<(ch-'a'));
            if((bits & mask)==0){
                ans+=ch;
                bits^=mask;
            }
        }
        int[]arr=new int[26];
        System.out.print(crypto(ans,arr,0,str1,str2,str3,0));
    }

    // public static int crossword()

    
    public static void main(String[]args){
        // int n=scn.nextInt();
        // int[]dp=new int[n+1];
    //    System.out.print(fact(1,n));
    // calls(n,dp);
    // int[]arr={1,2,34,5,6,7,5,4,3,6,70};
    // System.out.println(max(0,arr));
    ////wsdfghjkjhgfd
    // System.out.println(permu("abc",0,""));  
    //  System.out.println(keypad_2("8211"));
    // keypad_real("1152","");
    //
    // int[][]dp=new int[4][4];
    // mypair m=floodfill_height(0,0,3,3,dp);
    // System.out.println(m.max);
    // System.out.println(m.str);
    // System.out.println(m.min);
    // System.out.println(m.str2);
    // display(dp);
    // int[]arr={2,3,5,7};
    // int n=arr.length;
    // boolean[][]vis=new boolean[4][4];
    // int n=8;
    // int m=8;
        // row=new int[9];
        // col=new int[9];
        // diag=new int[9];
    //     adiag=new boolean[n+m-1];
    // System.out.println(nqueen4_generic(n,m,6,0,0,""));
    // combi_1coin(arr,10,0,"");
    // int[][]arr={
    // {1,5,-1,9,-1,-1,-1,-1,-1},
    // {2,-1,-1,-1,-1,3,-1,1,-1},
    // {-1,-1,-1,2,-1,-1,7,-1,4},
    // {3,-1,-1,-1,2,-1,8,-1,-1},
    // {-1,-1,8,-1,-1,-1,4,-1,-1},
    // {-1,-1,2,-1,8,-1,-1,-1,3},
    // {7,-1,4,-1,-1,1,-1,-1,-1},
    // {-1,8,-1,3,-1,-1,-1,-1,1},
    // {-1,-1,-1,-1,-1,4,-1,5,7}
    // };
         //ans=1 5 7 9 4 8 2 3 6 
            // 2 4 9 7 6 3 5 1 8 
            // 8 6 3 2 1 5 7 9 4 
            // 3 1 6 4 2 9 8 7 5 
            // 5 7 8 1 3 6 4 2 9 
            // 4 9 2 5 8 7 1 6 3 
            // 7 3 4 6 5 1 9 8 2 
            // 9 8 5 3 7 2 6 4 1 
            // 6 2 1 8 9 4 3 5 7 
    // for(int i=0;i<arr.length;i++){
    //     for(int j=0;j<arr[0].length;j++){
    //         if(arr[i][j]!=-1){
    //             row[i]^=(1<<arr[i][j]);
    //             col[j]^=(1<<arr[i][j]);
    //             diag[(i/3)*3+j/3]^=(1<<arr[i][j]);
    //         }
    //     }
    //  }
    // System.out.println(sudoku(arr,0,0));
    // map=new HashSet<String>();
    // map.add("i");
    // map.add("ilike");
    // map.add("like");
    // map.add("sam");
    // map.add("ilikesam");
    // System.out.println(wordbreak("ilikesam","",0));
    crypto_arithmetic("send","more","money");
    // int[]arr=new int[26];
    // arr[12]=3;
    // arr[14]=0;
    // arr[17]=6;
    // arr[4]=8;
    // co("more",arr);
    }
}