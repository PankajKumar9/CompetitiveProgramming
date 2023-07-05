import java.util.*;
public class IB_KnapSack {
    public static void main(String[] args){

    }
    public static class Solution {
        public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
            int[][] dp = new int[A.size()+1][C+1];
            for(int j =0;j<dp[0].length;j++){
                dp[0][j]=0;
            }
            for(int i=0;i<dp.length;i++){
                dp[i][0]=0;
            }
            for(int i = 1;i<dp.length;i++){
                for(int j =1;j<dp[0].length;j++){
                    dp[i][j]=dp[i-1][j];
                    if(j<B.get(i-1)){

                        continue;
                    }
                    dp[i][j]= Math.max(dp[i][j],dp[i-1][j-B.get(i-1)]);


                }
            }
            return dp[A.size()][C];

        }
    }

}
