import java.util.*;
public class IB_WaysToDecode {
    public static void main(String args[]){
        Solution s = new Solution();
        String A = "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
       int ans =  s.numDecodings(A);
       System.out.println(ans);

    }
    public static class Solution {


        public int numDecodings(String A) {

            HashMap<Integer,Long> mp = new HashMap<Integer,Long>();
            return (int)solve(A.length()-1,mp,A);
        }
        public long solve(int i,HashMap<Integer,Long> mp,String s) {
            if(mp.containsKey(i)){
                return mp.get(i);
            }
            if(i <0){
                return 1;
            }
            if(i==0){
                return 1;
            }
            long ans =0;
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)>'2'){
                    return 0;
                }
                ans = solve(i-2,mp,s);
                ans = ans% 1000000007;
                mp.put(i,ans);
                return ans;
            }

            if(s.charAt(i-1)=='2'){
                if(s.charAt(i)<'7'){
                    ans = solve(i-2,mp,s)+solve(i-1,mp,s);
                    ans = ans% 1000000007;
                    mp.put(i,ans);
                    return ans;
                }
            }
            if(s.charAt(i-1)=='1'){
                ans = solve(i-2,mp,s)+solve(i-1,mp,s);
                mp.put(i,ans);
                ans = ans% 1000000007;
                return ans;

            }
            ans = solve(i-1,mp,s);
            ans = ans% 1000000007;
            mp.put(i,ans);
            return ans;
        }
    }


}
