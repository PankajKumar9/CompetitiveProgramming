import java.util.*;
public class IB_IncreasingPathInMatrix {
    public static void main(String args[]){
        int[][] a = new int[][]{
                {92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68},
        {100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45, 63, 58},
        {38, 60, 24, 42, 30, 79, 17, 36, 91, 43, 89, 7, 41, 43, 65, 49, 47},
        {6, 91, 30, 71, 51, 7, 2, 94, 49, 30, 24, 85, 55, 57, 41, 67, 77},
        {32, 9, 45, 40, 27, 24, 38, 39, 19, 83, 30, 42, 34, 16, 40, 59, 5},
        {31, 78, 7, 74, 87, 22, 46, 25, 73, 71, 30, 78, 74, 98, 13, 87, 91},
        {62, 37, 56, 68, 56, 75, 32, 53, 51, 51, 42, 25, 67, 31, 8, 92, 8},
        {38, 58, 88, 54, 84, 46, 10, 10, 59, 22, 89, 23, 47, 7, 31, 14, 69}};

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            ArrayList<Integer> x = new ArrayList<>();
            for(int j : a[i]){
                x.add(j);
            }
            A.add(x);



        }
        Solution s = new Solution();
        int ans  = s.solve(A);

    }

    public static class Solution {

        public int solve(ArrayList<ArrayList<Integer>> A) {
            boolean[][] vis = new boolean[A.size()][A.get(0).size()];

            int[][] cache = new int[A.size()][A.get(0).size()];






            for(int i =A.size()-1;i>=0;i--){
                for(int j=A.get(0).size()-1;j>=0;j--){

                    if(i<A.size()-1){

                        if(j<A.get(i).size()-1){
                            if(A.get(i).get(j+1)>A.get(i).get(j)){

                                cache[i][j]=cache[i][j+1]+1;

                            }
                            if(A.get(i+1).get(j)>A.get(i).get(j)){
                                cache[i][j]=Math.max(cache[i][j],cache[i+1][j]+1);
                            }

                        }else{
                            if(A.get(i+1).get(j)>A.get(i).get(j)){
                                cache[i][j]=cache[i+1][j]+1;
                            }
                        }



                    }else{
                        if(j<A.get(i).size()-1){
                            if(A.get(i).get(j+1)>A.get(i).get(j)){

                                cache[i][j]=cache[i][j+1]+1;

                            }else{
                                cache[i][j]=0;
                            }


                        }else{
                            cache[i][j]= 1;
                        }



                    }


                    if(i!=A.size()-1 && j !=A.get(i).size()-1){
                        if(cache[i][j]==1){
                            cache[i][j]=0;
                        }

                    }

                }

            }
            for(int[] asd: cache)System.out.println(Arrays.toString(asd));

            if(cache[0][0]==0){
                return -1;
            }

            return cache[0][0];
        }
    }

}
