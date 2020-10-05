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
           PriorityQueue<int[]>pq=new PriorityQueue<>((int[]a,int[]b)->{
               return b[1]-a[1];
           });
        for(int i=0;i<size;i++){
            int val=ar.get(i);
            pq.add(new int[]{val,map.get(val)});
        }
           boolean flag=false;
           while(!flag){
               if(solve(size,pq,map,n)){
                   System.out.println(size);
                   flag=true;
                   break;
               }
               size--;
           }
           System.out.println(size);
       }
}
public static boolean solve(int size,PriorityQueue<int[]>que1,HashMap<Integer,Integer>que2,int n){
    int[]arr=new int[n];
    for(int i=0;i<n;i++){
        int a=arr[i];
        if(a!=0){
        que1.add(new int[]{a,que2.get(a)});
        que2.remove(a);
        }
        if(que1.size()==0)
        return false;
        
        int[]ar=que1.remove();
        if(ar[1]!=0){
        que2.put(ar[0],ar[1]-1);
        que1.remove(ar[0]);
        if(i+size<n)
        arr[i+size]=ar[0];
        }
        else return false;

    }
    return true;
}
}