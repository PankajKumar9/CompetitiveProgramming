import java.util.*;
import java.io.*;

public class LC_0797_AllPathsFromSourceToTarget {
    public static void main(String[] args) throws Exception {
        //Brute force solution needed 
        System.out.println("It is a really good day to code");
        //for every j lets keep an AL of path and append those everytime we hit one ;
        int[][] graphs = new int[][]{{1,2},{3},{3},{}};
        var x = allPathsSourceTarget(graphs);
        for(var i : x){
            System.out.print("New path ");
            for(Integer j : i){
            System.out.print(" " + j);
            }

        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = sol(graph,0);
         for(var x : paths){
             Collections.reverse(x);
         }
         return paths;
         
     }
     
     public static List<List<Integer>> sol(int[][] graph,int x) {
         ArrayList<Integer> temp = new ArrayList<>();
         //pats from x ka ek static bana lenge kuch toh 
         List<List<Integer>> paths = new ArrayList<List<Integer>>();
        for(Integer i : graph[x]){
 
            
          paths.addAll(sol(graph,i)) ;
            
            
        }
         for(var t : paths){
             t.add(x);
         }
         if (paths.size()==0 && x ==graph.length-1){
        temp = new ArrayList<>();
             temp.add(x);
             paths.add(temp);
             
         }
         return paths;
         
         
         
         
     }

}