import java.util.Scanner;
import java.util.*;
public class Solution{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int n=scn.nextInt();
        ArrayList<Integer>arr=new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        HashSet<Integer>map1=new HashSet<>();
        HashSet<Integer>map2=new HashSet<>();
        boolean square=false;
        boolean rect1=false;
        boolean rect2=false;
       while(n-->0){
           int a=scn.nextInt();
           if(!map.containsKey(a)){
           arr.add(a);
           map.put(a,1);
           }else{
               map.put(a,map.get(a)+1);
           }
           if(map.get(a)==4){
           map1.remove(a);
           map2.add(a);
           }
           else if(map.get(a)==2)
           map1.add(a);
       }

       int q=scn.nextInt();
       while(q-->0){
           int a=scn.nextInt();
           if(a>0){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
                if(map.get(a)==4){
                    map1.remove(a);
                    map2.add(a);
                }
                else if(map.get(a)>=2){
                    map1.add(a);
                }
              }
              else{
              map.put(a,1);
              arr.add(a);
              }
           }
           else{
            a=a*(-1);
            map.put(a,map.get(a)-1);
            if(map.get(a)==3){
                map2.remove(a);
                map1.add(a);
            }
            else if(map.get(a)==1){
                map1.remove(a);
            }
            else if(map.get(a)==0){
                map.remove(a);
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)==a){
                        arr.remove(i);
                        break;
                    }
                }
            }
           }
       if(map2.size()>=2){
           System.out.println("YES");
       }
       if(map2.size()==1){
           int b=map2.iterator().next();
        //    map2.add(b);
            int size=map.get(b);
            if(size>=8)
        System.out.println("YES");
        else if(size>=6){
            if(map1.size()>=1)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
        else{//4 or 5
            if(map1.size()>=2)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
    else
    System.out.println("NO");
    }
}
}