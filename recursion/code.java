import java.util.Scanner;
import java.util.ArrayList;

public class code{
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
    public static void main(String[]args){
       System.out.print(fact(1,5));
    }
}