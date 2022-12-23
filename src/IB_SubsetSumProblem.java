import java.util.*;
public class IB_SubsetSumProblem {
    public static void main(String[] args){
        int[] a = new int[]{ 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45, 63, 58};
        ArrayList<Integer> x = new ArrayList<>();
        for(int i : a){
            x.add(i);
        }
        int b = 38;
        Solution s = new Solution();
        System.out.println(s.solve(x,b));
    }

    public static class Solution {
        public int solve(ArrayList<Integer> A, int B) {
            boolean dp[][] = new boolean[A.size()+1][B+1];
            dp[0][0]= true;
            for(int i = 1;i<A.size()+1;i++){
                dp[i][0]= true;
            }
            for(int i = 1;i<A.size()+1;i++){
                for(int j = 1;j<B+1;j++){
                    if(dp[i-1][j]){
                        dp[i][j]= true;
                        continue;
                    }
                    if(j<A.get(i-1)){
                        continue;
                    }
                    if(dp[i-1][j-A.get(i-1)]){
                        dp[i][j]= true;
                    }

                }

            }
            for(boolean[] bx: dp){System.out.println(Arrays.toString(bx));}
            if(dp[A.size()][B]){
                return 1;
            }





            return 0;
        }
    }
}
