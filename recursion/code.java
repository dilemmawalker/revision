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
    public static int calls(int n,int[]dp) { // n=5
        if (n <= 1) {
            System.out.println("base: " + n);
            return dp[n]=n + 1;
        }
        // if(dp!=0)
        // return dp[n];

        int count = 0;

        System.out.println("Pre: " + n);
        count += calls(n - 1);

        System.out.println("In: " + n);
        
        for(int i=0;i<1000000;)
        i++;
        count += calls(n - 2);
        System.out.println("Post: " + n);

        return dp[n]=count + 3;
    }
    public static void main(String[]args){
        int n=scn.nextInt();
        int[]dp=new int[n+1];
    //    System.out.print(fact(1,n));
    calls(n,dp);
    }
}