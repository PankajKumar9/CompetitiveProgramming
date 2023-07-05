import java.util.*;
public class IB_LengthOfLongestSubsequence {
    public static void main(String args[]){
        Solution x = new Solution();
        List<Integer> A = new ArrayList<Integer>();
        int[] a = {1, 11, 2, 10, 4, 5, 2, 1};
        for(int i = 0;i<a.length;i++){
            A.add(a[i]);
        }

        System.out.println(x.longestSubsequenceLength(A));
    }
    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int longestSubsequenceLength(final List<Integer> A) {
            if(A.size()<3){
                return 0;
            }
            int dp1[] = new int[A.size()];
            int dp2[] = new int[A.size()];
            for(int i = 0;i<A.size();i++){
                dp1[i]=1;
                dp2[i]=1;
            }
            //1=> inc , 2 => dec
            for(int i =A.size()-2;i>=0;i--){
                int max2 =0;
                for(int j =i+1;j<A.size();j++){
                        if(A.get(j)<A.get(i)){
                                max2 = Math.max(max2,dp2[j]);
                        }
                }
                dp2[i]= max2+1;
            }
            for(int i =1;i<A.size();i++){
                int max1 = 0;
                for(int j=0;j<i;j++){
                    if(A.get(j)<A.get(i)){
                        max1 = Math.max(max1,dp1[j]);
                    }

                }
                dp1[i]= max1+1;

            }
            int max = dp1[0]+dp2[0];
            for(int i = 1;i<A.size();i++){
                max = Math.max(max,dp1[i]+dp2[i]);
            }
            return max-1;



        }
    }
}
