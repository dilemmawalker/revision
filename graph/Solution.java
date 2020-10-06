import java.util.*;
import java.io.*;
public class Solution{
    public static Scanner scn=new Scanner(new InputStreamReader(System.in));
    public static void main(String[]args){
       int t=scn.nextInt();
       while(t-->0){
        HashMap<Integer,Integer>map=new HashMap<>();
        ArrayList<Integer>ar=new ArrayList<>();
           int n=scn.nextInt();
           int n1=n;
           while(n1-->0){
               int a=scn.nextInt();
                if(!map.containsKey(a)){
                    ar.add(a);
                    map.put(a,1);
                }
                else{
                    map.put(a,map.get(a)+1);
                }
           }
           int size=ar.size();
        //    int[][]arr=new int[size][2];
        //    for(int i=0;i<size;i++){
        //        arr[i][0]=ar.get(i);
        //        arr[i][1]=map.get(ar.get(i));
        //    }
           if(ar.size()==1){
               System.out.println(0);
               continue;
           }
        //    Arrays.sort(arr,(int[]a,int[]b)->{
        //        return b[1]-a[1];
        //    });
           //
        //    for(int i=0;i<arr.length;i++)
        //    System.out.print(arr[i][0]+" ");
        //    System.out.println();
           //
           
           boolean flag=false;
           int min=0;
           int max=n;
           int mid=0;
        //    while(min!=max){
           
        //         mid=(min+max+1)/2;
        //        if(solve(mid,map,n,ar)){
        //            min=mid;
        //        }
        //        else
        //        max=mid-1;
        //    }
        //
        //
        int n2=n;
        while(!flag){
            if(solve(n2,map,n,ar)){
                break;
            }
            n2--;
        }
        //
        //
           System.out.println(n2-1);
       }
}
public static boolean solve(int size,HashMap<Integer,Integer>map,int n,ArrayList<Integer>arrr){
    PriorityQueue<int[]>que1=new PriorityQueue<>((int[]a,int[]b)->{
        return b[1]-a[1];
    });
    HashMap<Integer,Integer>que2=new HashMap<>();
 for(int i=0;i<arrr.size();i++){
     int val=arrr.get(i);
     int b=map.get(val);
     que1.add(new int[]{val,b});
     que2.put(val,b);
 }

    int[]arr=new int[n];
    for(int i=0;i<n;i++){
        int a=arr[i];
        if(a!=0){
            int b=que2.get(a);
        que1.add(new int[]{a,b});
        if(b-1!=0)
        que2.put(a,b-1);
        }
        if(que1.size()==0)
        return false;
        
        int[]ar=que1.remove();
        if(ar[1]!=0){
        que2.put(ar[0],ar[1]-1);
        // que1.remove(ar[0]);
        if(i+size<n)
        arr[i+size]=ar[0];
        // else
        // return false;
        }
        else return false;

    }
    return true;
}
}