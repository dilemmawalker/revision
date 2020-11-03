import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class prob1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[]args){
        int n=scn.nextInt();
        while(n-->0){
            int a=scn.nextInt();
            for(int i=a;i>=1;i--){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}