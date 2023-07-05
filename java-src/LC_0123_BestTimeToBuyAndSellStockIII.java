import java.util.*;
public class LC_0123_BestTimeToBuyAndSellStockIII {
    public static void main(String args[]){
        int[] a = new int[]{3,3,5,0,0,3,1,4};
        Solution s = new Solution();
       int ans=  s.maxProfit(a);
       System.out.println(ans);


    }
    public static class Solution {

        public int maxProfit(int[] prices) {
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();
            for(int i = 1;i< prices.length;i++){
                if(prices[i]>max){
                    max = prices[i];
                }
            }
            for(int i = 1;i<prices.length;i++){
                if(prices[i]==max){
                    x.add(i);
                }
            }

            int ans[][] = new int[x.size()][4];
            int j = 0;



            return 0;
        }
        public int maxp(int[] prices,boolean flag){
                    int max1 = Integer.MIN_VALUE;
                    int min1 = Integer.MAX_VALUE;
                    int N = prices.length;
                   return 0;


        }
    }
}
