import java.util.*;

public class IB_TusharParty {
    public static void main(String args[]){
        int a[] = {665, 154, 269, 501, 998, 992, 904, 763, 254, 591, 869, 843, 683, 708, 410, 88, 352, 566, 497, 252, 486, 565, 115, 585, 414, 864, 23, 389, 308};
   int b[] ={1, 586, 973, 418, 573, 193, 416, 566, 815, 179, 538, 406, 766, 381, 807, 194, 510, 894, 264, 76, 111, 515, 281, 675, 630, 865, 807, 213, 887, 914, 520, 433, 501};
    int c[] = { 493, 570, 792, 404, 985, 77, 219, 883, 334, 343, 649, 714, 151, 561, 942, 763, 825, 737, 592, 340, 18, 267, 688, 601, 75, 900, 488, 988, 421, 639, 208, 632, 209};
        List<Integer> A = new ArrayList<Integer>() ;
        List<Integer> B = new ArrayList<Integer>() ;
        List<Integer> C = new ArrayList<Integer>() ;
        for(int i = 0;i<a.length;i++){
            A.add(a[i]);
        }
        for(int i = 0;i<b.length;i++){
            B.add(b[i]);
        }
        for(int i = 0;i<c.length;i++){
            C.add(c[i]);
        }
        Solution st = new Solution();
       int ans=  st.solve(A,B,C);
       System.out.println(ans);
    }
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
            int Cx = 0;
            for(Integer itsx : A){
                if(itsx>Cx){
                    Cx=itsx;
                }
            }
            int[][] dp = new int[B.size()+1][Cx+1];
            for(int i =0;i<dp.length;i++){
                for(int j =1;j<dp[0].length;j++){
                    dp[i][j]= 10000000;

                }


            }
            for(int i =1;i<dp.length;i++){
                for(int j =1;j<dp[0].length;j++){
                    dp[i][j]= dp[i-1][j];
                    if(B.get(i-1)>j){
                        continue;
                    }
                    dp[i][j]= Math.min(dp[i][j],C.get(i-1)+dp[i-1][j-B.get(i-1)]);
                    dp[i][j]= Math.min(dp[i][j],C.get(i-1)+dp[i][j-B.get(i-1)]);

                }


            }
            int sum =0;
            for(Integer ds : A){
                sum+= dp[dp.length-1][ds];
            }
            return sum;

        }
    }

}
