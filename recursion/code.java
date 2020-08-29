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
    
    public static void main(String[]args){
        // int n=scn.nextInt();
        // int[]dp=new int[n+1];
    //    System.out.print(fact(1,n));
    // calls(n,dp);
    // int[]arr={1,2,34,5,6,7,5,4,3,6,70};
    // System.out.println(max(0,arr));
    ////wsdfghjkjhgfd
    // System.out.println(permu("abc",0,""));  
    // permu_new1_non_repeat("aba","");
    keypad_permu("02","");
    }
}