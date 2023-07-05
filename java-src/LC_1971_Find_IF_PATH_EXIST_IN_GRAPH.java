import java.util.*;
import java.io.*;

public class LC_1971_Find_IF_PATH_EXIST_IN_GRAPH {
    public static void main(String[] args) throws Exception {
            //test case
        int n = 1;
        int[][] edges = new int[][]{};
        int s = 0;
        int d = 0;
        System.out.println(validPath(n, edges, s, d));
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length==0){
            return false;
        }
        var adj = edgesToAdjList(edges);
        int[] dis = new int[adj.size()];
        for(int i = 0;i<dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[source] = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(source);
        int u ;
        while(Q.size() != 0){
                u = Q.poll();
                for(int i : adj.get(u)){
                    if(dis[i]==Integer.MAX_VALUE){
                        if(i == destination){
                            return true;
                        }
                        Q.add(i);
                        dis[i]= dis[u]+1;

                    }

                }

        }
        


        
        
        
        return false;
    }
    public static ArrayList<ArrayList<Integer>> edgesToAdjList(int[][] edges){
        System.out.println("Length of edges array is "+edges.length);
        if (edges.length ==0){
            return new ArrayList<ArrayList<Integer>>();
        }
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;

        for(int i = 0;i<edges.length;i++){
            for(int j=0;j<2;j++){
                if(edges[i][j]>max1){
                    max1 = edges[i][j] ;
                }
                if(edges[i][j]<min1){
                    min1 = edges[i][j] ;
                }

            }

        }
        ArrayList<ArrayList<Integer>> sol =new ArrayList<>();
        for(int i =0;i<max1+1;i++){
            sol.add(new ArrayList<Integer>());

        }
        for(int i = 0;i<edges.length;i++){
            sol.get(edges[i][0]).add(edges[i][1]);
            sol.get(edges[i][1]).add(edges[i][0]);

        }
        return sol;

    }
}
