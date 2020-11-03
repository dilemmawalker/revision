import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class prob2{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int t=scn.nextInt();
       
        while(t-->0){
            int count=0;
            int n=scn.nextInt();
            int m=scn.nextInt();
            if(n==1 && m==1){
                String am=scn.next();
                System.out.println(0);
                continue;
            }
            for(int i=0;i<n-1;i++){
                String str=scn.next();
                char ch=str.charAt(m-1);
                if(ch=='R')
                count++;
            }
            String str=scn.next();
            for(int i=0;i<m;i++){
                char ch=str.charAt(i);
                if(ch=='D')
                count++;
            }
            System.out.println(count);
        }
    }
}