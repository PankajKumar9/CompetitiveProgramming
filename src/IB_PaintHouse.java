import java.util.*;
public class IB_PaintHouse {
    public static void main(String args[]){

    }
    public class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            int[][] dp = new int[A.size()][3];
            dp[A.size()-1][0]=A.get(A.size()-1).get(0);
            dp[A.size()-1][1]=A.get(A.size()-1).get(1);
            dp[A.size()-1][2]=A.get(A.size()-1).get(2);

            for(int i = A.size()-2;i>=0;i--){
                dp[i][0]=A.get(i).get(0)+Math.min(dp[i][1],dp[i][2]);

                dp[i][1]=A.get(i).get(1)+Math.min(dp[i][0],dp[i][2]);

                dp[i][2]=A.get(i).get(2)+Math.min(dp[i][0],dp[i][1]);


            }
            int ans = Math.min(dp[0][0],dp[0][1]);
            return Math.min(ans,dp[0][2]);

        }
    }
}
