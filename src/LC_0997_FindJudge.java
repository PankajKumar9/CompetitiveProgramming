import java.util.*;
import java.io.*;

public class LC_0997_FindJudge {
    public static void main(String[] args) throws Exception {
        System.out.println("It is a really good day to code");
        int[][] trust = new int[][]{{1,2},{2,3}};
        System.out.println(findJudge(3, trust));
    }
    public static int findJudge(int n, int[][] trust) {

        if(trust.length == 0){
            if(n ==1){
                return 1;
            }
            return -1;
            
        }
        var x = edgesToAdjList(trust);
        var y = revAdj(trust);
        for(int i = 0; i < x.size(); i++) {
           
           if(x.get(i).size() == n-1 && y.get(i).size()==0){
            return i+1;
           }


        }
            return -1;
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
           // sol.get(edges[i][0]-1).add(edges[i][1]-1);
            sol.get(edges[i][1]-1).add(edges[i][0]-1);

        }
        return sol;

    }
         public static  ArrayList<ArrayList<Integer>> revAdj(int[][] edges){
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
           // sol.get(edges[i][1]-1).add(edges[i][0]-1);

        }
        return sol;

    }

}
