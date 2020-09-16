import java.util.ArrayList;
public class code{
    public static void main(String[]args){
        construct();
        display();
    }
         public static class edge{
            int v=0;
            int w=0;
            edge(int v,int w){
                this.v=v;
                this.w=w;
            }
        }
        public static int N=7;
        public static ArrayList<edge>[]graph=new ArrayList[N];
        // public static ArrayList<ArrayList<edge>>graph1=new ArrayList<>();
        public static void construct(){
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
            // graph1.add(new ArrayList<edge>());
        }
        addedge(0,1,10);
        addedge(0,3,10);
        addedge(1,2,10);
        addedge(2,3,40);
        addedge(3,4,2);
        addedge(4,5,2);
        addedge(4,6,3);
        addedge(5,6,8);
    }
    public static void addedge(int u,int v,int w){
        graph[u].add(new edge(v,w));
        graph[v].add(new edge(u,w));
    }
    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i+" -> ");
            for(edge e:graph[i])
            System.out.print("("+e.v+","+e.w+")"+" ,");
            System.out.println();
        }
    }

}