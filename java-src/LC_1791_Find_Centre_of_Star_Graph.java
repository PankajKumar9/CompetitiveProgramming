import java.util.*;
import java.io.*;
//worp
//notion
//
public class LC_1791_Find_Centre_of_Star_Graph {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
    }
    public static int findCenter(int[][] edges) {
        var adj = edgesToAdjList(edges);
        for(int i = 0;i<adj.size();i++){
            if(adj.get(i).size()==adj.size()-1){
                return i+1;
            }
        }


        return 0;
    }
    public static ArrayList<ArrayList<Integer>> edgesToAdjList(int[][] edges){
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
        for(int i =0;i<max1;i++){
            sol.add(new ArrayList<Integer>());

        }
        for(int i = 0;i<edges.length;i++){
            sol.get(edges[i][0]-1).add(edges[i][1]-1);
            sol.get(edges[i][1]-1).add(edges[i][0]-1);

        }
        return sol;

    }
}
