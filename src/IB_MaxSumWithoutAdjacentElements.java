import java.util.*;
public class IB_MaxSumWithoutAdjacentElements {
    public static void main(String args[]){


    }
    public static  class Solution {
        public int adjacent(ArrayList<ArrayList<Integer>> A) {
            int N = A.get(0).size();
            if(N==0){
                return 0;
            }
            if(N==1){
                N = A.get(0).get(0);
                N = Math.max(N,A.get(1).get(0));
                return N;
            }


            int[][] dp = new int[2][N];
            dp[0][N-1] = A.get(0).get(N-1);
            dp[1][N-1] = A.get(1).get(N-1);
            dp[0][N-2] = A.get(0).get(N-2);
            dp[1][N-2] = A.get(1).get(N-2);

            for(int i = N-3;i>=0;i--){
                dp[0][i]=Math.max(dp[0][i+2],dp[1][i+2])+A.get(0).get(i);
                dp[1][i]=Math.max(dp[0][i+2],dp[1][i+2])+A.get(1).get(i);

            }
            int max = dp[0][0];
            max = Math.max(max,dp[0][1]);
            max = Math.max(max,dp[1][1]);
            max = Math.max(max,dp[1][0]);
            return max;



        }
    }


}


