import java.util.*;
public class IB_IntersectingChordsInCircle {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.chordCnt(4));


    }
    public static class Solution {
        public int chordCnt(int A) {
            int dp[] = new int[A+1];
            dp[0]=1;
            dp[1] = 1;
            dp[2] = 2;
            int j =0;
            for(int i = 3;i<A+1;i++){
                j=2;
                while(j<=2*i){

                    dp[i]+=dp[i-(j/2)]*dp[(j/2)-1];
                    j+=2;
                }

            }


          return dp[A];
        }
    }


}
