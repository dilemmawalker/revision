import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    public static long[]par;
    public static long findparent(long vtx){
        if(par[(int)vtx]==vtx)
        return vtx;

        return par[(int)vtx]=findparent(par[(int)vtx]);
    }
    public static void roadsAndLibraries(long n, long lib, long road, long[][] arr) {

        if(lib<=road){
            System.out.println(n*lib);
            return;
        }

        par=new long[(int)n+1];
        for(long i=0;i<=n;i++)
        par[(int)i]=i;
        // boolean[]vis=new boolean[n+1];
        long m=arr.length;
        long cost=0;
       for(long i=0;i<m;i++){
        long u=arr[(int)i][0];
        long v=arr[(int)i][1];
            long a=findparent(u);
            long b=findparent(v);
            if(a!=b){
            par[(int)a]=b;
            cost=cost+road;
            }
       }
       for(long i=1;i<=n;i++){
        if(par[(int)findparent(i)]==i)
        cost=cost+lib;
       }
       System.out.println(cost);
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args){
        long q=scn.nextLong();
        while(q-->0){
            long n=scn.nextLong();
            long m=scn.nextLong();
            long lib=scn.nextLong();
            long road=scn.nextLong();
            long[][]arr=new long[(int)m][2];
            for(long i=0;i<m;i++){
                arr[(int)i][0]=scn.nextLong();
                arr[(int)i][1]=scn.nextLong();
            }
            roadsAndLibraries(n,lib,road,arr);
        }
    }
}
