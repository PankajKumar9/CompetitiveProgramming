import java.util.*;
public class IB_FlipArray {
    public static void main(String args[]){
        int[] a = { 8, 4, 5, 7, 6, 2 };
        List<Integer> x = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            x.add(a[0]);
        }
        Solution s = new Solution();
        int r = s.solve(x);
        System.out.println(r);

    }
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int solve(final List<Integer> A) {
            int a[] = new int[A.size()];
            int sum = 0;
            for(int i = 0;i<A.size();i++){
                sum+=A.get(i);
                a[i]= A.get(i);
            }
            int dp[][] = new int[A.size()+1][(sum/2)+1];
            for(int i =0;i<dp.length;i++){
                for(int j =1;j<dp[0].length;j++){
                    dp[i][j]= A.size()+1;
                }
            }
            for(int i = 1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    dp[i][j]=dp[i-1][j];
                    if(A.get(i-1)>j){
                        continue;
                    }
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-A.get(i-1)]);

                }


            }
            for(int[] ae : dp){
                System.out.println(Arrays.toString(ae));
            }
            return dp[dp.length-1][dp[0].length-1];




        }
    }

}
