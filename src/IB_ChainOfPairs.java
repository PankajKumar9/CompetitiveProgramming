import java.util.*;
public class IB_ChainOfPairs {
    public static void main(String args[]){

int[][] A = {{5,24},{39,60},{15,28},{27,40},{50,90}};


        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }
                if(o1[0]>o2[0]){
                    return -1;
                }
                if(o1[1]>o2[1]){
                    return 1;
                }
                return -1;
            }
        });

        for(int[] x : A ){
            System.out.println(Arrays.toString(x));
        }
        Solution s = new Solution();
        A=new int[][]{{10,20},{1,2}};
       int ans =  s.solve(A);
       System.out.println(ans);

    }
    public static class Solution {
        public int solve(int[][] A) {


            int dp[] = new int[A.length];
            dp[A.length-1]=1;
            for(int i = A.length-2;i>=0;i--){
                int max = 0;
                for(int j = i+1;j<dp.length;j++){
                    if(A[j][0]>A[i][1]){
                        if(dp[j]>max){
                            max = dp[j];
                        }

                    }
                }
                dp[i]= max+1;

            }
            int max = 0;
            for(int xd : dp){
                if(xd>max){
                    max = xd;
                }
            }
            return max;



        }
    }

}
