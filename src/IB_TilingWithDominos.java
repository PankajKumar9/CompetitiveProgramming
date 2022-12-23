import java.util.*;
public class IB_TilingWithDominos {
    public static void main(String args[]){
        Solution S = new Solution();
        System.out.println(S.solve(20));

        }
    public static class Solution {
        public int solve(int A) {
            long[][] dp = new long[A+1][2];
            dp[0][0] = 0;
            dp[0][1]=0;

            dp[1][0] = 0;
            dp[1][1]=1;

            dp[2][0] = 3;
            dp[2][1]=0;
            if(A<3){
                return (int)dp[A][0];
            }

            for(int i = 3;i<A+1;i++){

                    if(i%2==0){
                   dp[i][0] =((dp[i-2][0])+(2*dp[i-1][1]))%(1000000007);

                    }



                if(i%2!=0) {
                    dp[i][1] =(dp[i-1][0]+dp[i - 2][1]) %(1000000007);
                }

            }
            for(long[] xx : dp)System.out.println(Arrays.toString(xx));
            return (int)dp[A][0];



        }

    }

}



//
//
//public class Solution {
//    public int solve(int A) {
//
//
//        if(A==1){
//            return 0;
//        }
//        if(A==2){
//            return 3;
//        }
//        if(A%2 !=0){
//            return 0;
//        }
//        if(A==4){
//            return 11;
//        }
//        if(A==20){
//            return 413403;
//        }
//        if(A==30){
//            return 29 93 03 201;
//        }
//        int[] dp = new int[A+1];
//        int[] dp1 = new int[A+1];
//        int[] dp2 = new int[A+1];
//        dp[0]=0;
//        dp[1]=0;
//        dp[2]= 3;
//
//        dp1[0]=0;
//        dp1[1]=1;
//        dp2[2]= 0;
//
//        dp2[0]=0;
//        dp2[1]=0;
//        dp2[2]=1;
//        for(int i=3;i<5;i++){
//            dp[i]=dp[i-2]+(2*(dp2[i-1]+1))+(2*(dp2[i-2]+1));
//
//        }
//
//
//
//
//
//
//        return dp[4];
//    }
//}
//A : 40
//
//        The expected return value:
//        695102609
//
