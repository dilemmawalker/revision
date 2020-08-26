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
    public static void main(String[]args){
       decreasing(0,10);
    }
}