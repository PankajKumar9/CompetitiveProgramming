import java.util.*;
public class IB_UniquePathsInGrid {
    public static void main(String[] args){
        Solution S = new Solution();
        ArrayList<Integer> x = new ArrayList<>();
        x.add(0);
        x.add(1);
        ArrayList<ArrayList<Integer>> y = new ArrayList<>();
        y.add(x);
        S.uniquePathsWithObstacles(y);

    }
    public static class Solution {
        public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
            int dp[][] = new int[A.size()][A.get(0).size()];
            for(int i = dp.length-1;i>=0;i--){
                for(int j=dp[0].length-1;j>=0;j--){
                    dp[i][j]=0;
                    if(A.get(i).get(j)==1){

                        continue;
                    }
                    if(i<dp.length-1){

                            //dp[i][j]=dp[i+1][j];

                            dp[i][j]+=dp[i+1][j];


                        if(j<dp[0].length-1){

                                //dp[i][j]=dp[i+1][j];

                                dp[i][j]+=dp[i][j+1];

//                            //dp[i][j]= Math.min(dp[i][j],dp[i][j+1]);
                        }
//                        //dp[i][j]+=A.get(i).get(j);
                    }else{
                        if(j<dp[0].length-1) {

                                //dp[i][j]=dp[i+1][j];
                                dp[i][j]+=dp[i][j+1];

                        }else{
                            dp[i][j]=1;
                        }

                    }



                }

            }
            //for(int[] xd : dp)System.out.println(Arrays.toString(xd));
            return dp[0][0];





        }
    }
}
