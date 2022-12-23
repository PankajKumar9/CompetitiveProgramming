import java.util.*;
import java.io.*;

public class IB_WaterFlow {
    public static class Solution {

        public String stringAL(ArrayList<Integer> x){
            StringBuilder sb = new StringBuilder();
            for(Integer t : x){
                sb.append(t.toString()+" ");
            }
            if(x.size()== 0){
                return "null";
            }
            return sb.toString();
        }

        public  ArrayList<Integer>[] DirectedAdj(int[][] edges,int n,boolean index0) {
            ArrayList<Integer>[] al = new ArrayList[n]; 

            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
                for(int[] i : edges) {
                    if(index0){
                    al[i[0]].add(i[1]);
                   }else{
                        al[i[0]-1].add(i[1]-1);
                  
                    }
         
                }

            return al;
     
     
     
        }
        public  ArrayList<Integer>[] unDirectedAdj(int[][] edges,int n,boolean index0 ) {
            if(n==-1){
                int max = -1;
                for(var t : edges){
                    if(t[0]>max){
                        max = t[0];
                    }
                    if(t[1]>max){
                        max = t[1];
                    }
                }
                    n=max;

            }
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
            for(var i : edges) {
                if(index0){
                al[i[0]].add(i[1]);
                al[i[1]].add(i[0]);}else{
                    al[i[0]-1].add(i[1]-1);
                    al[i[1]-1].add(i[0]-1);  
                }
     
            }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
        public  ArrayList<Integer>[] revDirectedAdj(int[][] edges,int n,boolean index0) {
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
                for(var i : edges) {
                    if(index0){
                    al[i[1]].add(i[0]);
                   }else{
                        al[i[1]-1].add(i[0]-1);
                  
                    }
         
                }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
    //Here goes our solutiom func
    }








    public static void main(String[] args) throws Exception {
        System.out.println("It is a really good day to code");

        int mat[][] = {
                {11, 20, 5, 18, 9, 4},
                {16, 2, 3, 11, 12, 17},
                {15, 1, 17, 2, 9, 20},
                {9, 5, 2, 15, 14, 20},
                {19, 19, 1, 9, 8, 8},
                {9, 14, 9, 4, 8, 2},
                {11, 18, 14, 15, 10, 17},
                {16, 12, 1, 10, 20, 17},
                {19, 4, 5, 9, 5, 10},
                {10, 3, 16, 6, 14, 4},
                {4, 8, 15, 4, 9, 1},
                {19, 19, 1, 17, 19, 2},
                {10, 19, 10, 18, 13, 3},
        };
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        for(int i = 0;i<mat.length;i++){
            t = new ArrayList<>();
            for(int j = 0;j<mat[0].length;j++){
                t.add(mat[i][j]);
            }

            x.add(t);
        }





        System.out.println(solve(x));



    }
    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        boolean[][] vis = new boolean[N][M];
        int [][]path = new int[N][M];
        boolean[][] ans1 = new boolean[N][M];
        boolean[][] ans2 = new boolean[N][M];
        for(int i = 0;i<N;i++){
            ans1[i][0] = true;
            ans2[i][M-1]= true;
        }
        for(int j = 0;j<M;j++){
            ans1[0][j] = true;
            ans2[N-1][j]= true;
        }
        //ans1 and 2 jo h vo directly connected h abhi toh ;
        Stack<Integer[]> st = new Stack<>();

        Integer[] curr;


        for(int i = 0;i<N;i++){

            vis[i][0] = true;
            st.add(new Integer[]{i,0});
        }
        for(int j = 0;j<M;j++){

            vis[0][j] = true;
            st.add(new Integer[]{0,j});

        }


        while(!st.empty()){
            curr = st.pop();

            ans1[curr[0]][curr[1]] = true;
            if(curr[0]>0){
                if(!vis[curr[0]-1][curr[1]]){
                    if(A.get(curr[0]-1).get(curr[1])>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]-1][curr[1]]= true;
                        st.push(new Integer[]{curr[0]-1,curr[1]});
                    }

                }

            }
            //2
            if(curr[0]<N-1){
                if(!vis[curr[0]+1][curr[1]]){
                    if(A.get(curr[0]+1).get(curr[1])>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]+1][curr[1]]= true;
                        st.push(new Integer[]{curr[0]+1,curr[1]});
                    }

                }

            }
            //3
            if(curr[1]>0){
                if(!vis[curr[0]][curr[1]-1]){
                    if(A.get(curr[0]).get(curr[1]-1)>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]][curr[1]-1]= true;
                        st.push(new Integer[]{curr[0],curr[1]-1});
                    }

                }

            }
            if(curr[1]<M-1){
                if(!vis[curr[0]][curr[1]+1]){
                    if(A.get(curr[0]).get(curr[1]+1)>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]][curr[1]+1]= true;
                        st.push(new Integer[]{curr[0],curr[1]+1});
                    }

                }

            }





        }//while loop doine


        st = new Stack<>();
        vis = new boolean[N][M];


        for(int i = 0;i<N;i++){

            vis[i][M-1]= true;
            st.add(new Integer[]{i,M-1});

        }
        for(int j = 0;j<M;j++){

            vis[N-1][j]= true;
            st.add(new Integer[]{N-1,j});
        }










        while(!st.empty()){
            curr = st.pop();
            ans2[curr[0]][curr[1]] = true;
            if(curr[0]>0){
                if(!vis[curr[0]-1][curr[1]]){
                    if(A.get(curr[0]-1).get(curr[1])>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]-1][curr[1]]= true;
                        st.push(new Integer[]{curr[0]-1,curr[1]});
                    }

                }

            }
            //2
            if(curr[0]<N-1){
                if(!vis[curr[0]+1][curr[1]]){
                    if(A.get(curr[0]+1).get(curr[1])>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]+1][curr[1]]= true;
                        st.push(new Integer[]{curr[0]+1,curr[1]});
                    }

                }

            }
            //3
            if(curr[1]>0){
                if(!vis[curr[0]][curr[1]-1]){
                    if(A.get(curr[0]).get(curr[1]-1)>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]][curr[1]-1]= true;
                        st.push(new Integer[]{curr[0],curr[1]-1});
                    }

                }

            }
            if(curr[1]<M-1){
                if(!vis[curr[0]][curr[1]+1]){
                    if(A.get(curr[0]).get(curr[1]+1)>=A.get(curr[0]).get(curr[1])){
                        vis[curr[0]][curr[1]+1]= true;
                        st.push(new Integer[]{curr[0],curr[1]-1});
                    }

                }

            }





        }//while loop doine




        int count =0;
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){

                if(ans1[i][j] && ans2[i][j]){
                    count++;
                }
        ans1[i][j] = ans1[i][j] && ans2[i][j];


            }

        }


        return count;


    }
    public static  void PrintMatrix(boolean[][] x){
        for(boolean[] a : x){
            System.out.println(Arrays.toString(a));
       }
    }
}
