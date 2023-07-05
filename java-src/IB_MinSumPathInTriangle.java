import java.util.*;
public class IB_MinSumPathInTriangle {
    public static void main(String args){

    }
    public static class Solution {
        public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
            int prev[] = new int[a.size()];
            int curr[] = new int[a.size()];
            for(int i = 0;i<a.get(a.size()-1).size();i++){
                curr[i] = a.get(a.size()-1).get(i);
            }

            for(int i = a.size()-2;i>=0;i--){
                prev = curr;
                curr = new int[a.get(i).size()];
                for(int j=0;j<a.get(i).size();j++){
                    curr[i]= a.get(i).get(j)+Math.min(prev[i],prev[i+1]);
                }
            }

            return curr[0];


        }
    }

}
