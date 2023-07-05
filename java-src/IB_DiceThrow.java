import java.util.*;
public class IB_DiceThrow {
    public static void main(String[] args){
        Solution s = new Solution();
        int ans = s.findDiceSum(2,4,5);

        System.out.println(ans);
    }
    public static class Solution {

        HashMap<String,Integer> mp ;
        public int findDiceSum(int A, int B, int C) {

            mp = new HashMap<>();
            return findSum(A,B,C)/2;
        }
        public int findSum(int A, int B, int C) {
            if(A==0){
                return 0;
            }
            if(C<=0){
                return 1;
            }
            String s = A+"$"+B+"$"+C;
            if(mp.containsKey(s)){
                return mp.get(s);
            }
            int sum = 0;
            for(int i = 1;i<B+1;i++){
                if(i==C){
                    sum+=1;
                }
              sum +=  A*findSum(A-1,B,C-i);
                System.out.println("i= "+i+" sum = "+sum);
            }
            mp.put(s,sum);
            return sum;

        }
    }
}
