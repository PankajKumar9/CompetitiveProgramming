import java.util.*;
public class IB_LongestIncreasingSubsequence {
    public static void main(String[] args){


    }
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int lis(final List<Integer> A) {
            int[] dp = new int[A.size()];
            dp[A.size()-1]=1;
            int m =0;
            int M = 0;
            for(int i = A.size()-2;i>=0;i--){
                m=0;
                for(int j = i+1;j<A.size();j++){
                    if(A.get(j)>A.get(i)){
                        m= Math.max(m,dp[j]);
                    }
                }

                M = Math.max(M,m);
                dp[i]=m+1;
            }

         return M+1;
        }
    }
}
