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
           while(n-->0){
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
           int[][]arr=new int[size][2];
           for(int i=0;i<size;i++){
               arr[i][0]=ar.get(i);
               arr[i][1]=map.get(ar.get(i));
           }
           if(ar.size()==1){
               System.out.println(0);
               continue;
           }
           Arrays.sort(arr,(int[]a,int[]b)->{
               return b[1]-a[1];
           });
           //
           for(int i=0;i<arr.length;i++)
           System.out.print(arr[i][0]+" ");
           System.out.println();
           //
           StringBuilder ans=new StringBuilder("");
           int ei=arr.length-1;
           while(ei!=0){
               for(int i=0;i<arr.length;i++){
                int s=arr[i][0];
                int val=arr[i][1];
                if(val==0){
                    ei=i;
                    break;
                }
                arr[i][1]--;
                ans.append(s);
               }
           }
        //    while(arr[0][1]!=0){
        //        int s=arr[i][0];
        //        int val=arr[i][1];
        //        if(i==0 && val==0)
        //        break;
        //        if(val==0)
        //        continue;
        //         ans.append(s);
        //         arr[i][1]--;
        //    }
           boolean flag=false;
           char ch=ans.charAt(ans.length()-1);
           int co=0;
           for(int i=ans.length()-2;i>=0;i--){
               char c=ans.charAt(i);
               if(c==ch)
               break;
               co++;
           }
           System.out.println(co);
       }
}
}