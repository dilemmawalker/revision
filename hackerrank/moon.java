import java.util.Scanner;
import java.util.ArrayList;
public class moon{
    public static Scanner scn=new Scanner(System.in);
    public static int[]par;
    public static int[]size;
    public static void main(String[]args){
        int n=scn.nextInt();
        int p=scn.nextInt();
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
        par[i]=i;
        }
        for(int i=0;i<p;i++){
            int a=scn.nextInt();
            int b=scn.nextInt();
            int u=getparent(a);
            int v=getparent(b);
            if(u!=v){
                merge(u,v);
            }
        }
        ArrayList<Integer>ar=new ArrayList<>();
        long total=0;
        for(int i=0;i<n;i++){
            if(getparent(i)==i){
                ar.add(size[i]);
                total+=size[i];
            }
        }
        int s=ar.size();
        long val=0;
        for(int i=0;i<s;i++){
            int a=ar.get(i);
            total=total-a;
            val+=a*total;
        }
        System.out.println(val);
    }
    public static int getparent(int vtx){
        if(par[vtx]==vtx)
        return vtx;

        return par[vtx]=getparent(par[vtx]);
    }
    public static void merge(int a,int b){
        if(size[a]>size[b]){
            par[b]=a;
            size[a]+=size[b];
        }
        else{
            par[a]=b;
            size[b]+=size[a];
        }
    }
}