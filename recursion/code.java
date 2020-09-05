import java.util.Scanner;
import java.util.ArrayList;

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
    public static void display(int vidx, int []arr){
        if(vidx==arr.length)
        return;

        System.out.print(arr[vidx]+" ");
        display(vidx+1,arr);
    }
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
    int[][]dp=new int[4][4];
    mypair m=floodfill_height(0,0,3,3,dp);
    System.out.println(m.max);
    System.out.println(m.str);
    System.out.println(m.min);
    System.out.println(m.str2);
    // display(dp);
    }
}