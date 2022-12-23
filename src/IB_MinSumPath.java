import java.util.*;
public class IB_MinSumPath {
    public static void main(String[] args){


    }

    public static class Solution {
        public int minPathSum(ArrayList<ArrayList<Integer>> A) {
            int dp[][] = new int[A.size()][A.get(0).size()];
            for(int i = dp.length-1;i>=0;i--){
                for(int j=dp[0].length-1;j>=0;j--){
                    if(i<dp.length-1){
                        dp[i][j]=dp[i+1][j];
                        if(j<dp[0].length){
                            dp[i][j]= Math.min(dp[i][j],dp[i][j+1]);
                        }
                        dp[i][j]+=A.get(i).get(j);
                    }else{
                        if(j<dp[0].length) {
                            dp[i][j] = dp[i][j + 1];
                        }
                        dp[i][j]+=A.get(i).get(j);
                    }



                }

            }


            return dp[0][0];
        }
    }


}
