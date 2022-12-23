import java.util.*;
public class IB_MinJumpsArray {
    public static void main(String[] args){
        int[] a = {33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 };
        Solution s = new Solution();
        ArrayList<Integer> x = new ArrayList<>();
        for(int i : a){
            x.add(i);
        }
        s.jump(x);

    }
    public static class Solution {
        public int jump(ArrayList<Integer> A) {
            int[] dp = new int[A.size()];

            dp[0]=0;
            int k = 0;
            for(int i = 0;i<A.size();i++){
                if(i!=0 && dp[i]<1){
                    return -1;
                }
                int N = Math.min(i+A.get(i),A.size()-1);

                for(int j = k+1;j<=N;j++){
                    if(dp[j]==0){
                        dp[j]=dp[i]+1;
                    }else{
                        dp[j]=Math.min(dp[i]+1,dp[j]);
                    }


                }
                if(N==A.size()-1){
                    return dp[A.size()-1];
                }
                k= N;




            }
            return dp[A.size()-1];
        }
    }

}
