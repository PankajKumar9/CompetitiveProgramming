import java.lang.reflect.Array;
import java.util.*;
public class IB_LargestAreaOfRectangleWithPermutations {
    public static void main(String[] args){
        int[][] x = new int[][]{{1,0,1},{0,1,0},{1,0,0}};
        ArrayList<Integer> a= new ArrayList<>();
        for(int i : x[0]){
            a.add(i);
        }
        ArrayList<Integer> b= new ArrayList<>();
        for(int i : x[1]){
            b.add(i);
        }
        ArrayList<Integer> c= new ArrayList<>();
        for(int i : x[2]){
            c.add(i);
        }
        ArrayList<ArrayList<Integer>> rr = new ArrayList<>();
        rr.add(a);
        rr.add(b);
        rr.add(c);
        Solution s = new Solution();
        int rans = s.solve(rr);
        System.out.println(rans);
    }
    public static class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            int[][] dp = new int[A.size()][A.get(0).size()];
            for(int j=0;j<dp[0].length;j++){
                for(int i = 0;i<dp.length;i++){
                    if(i==0){
                        dp[i][j]= A.get(i).get(j);
                        continue;
                    }
                    dp[i][j]=A.get(i).get(j);
                    if(A.get(i).get(j)!=0){
                        dp[i][j]+=dp[i-1][j];
                    }
                }
            }

            int max = 0;
            ArrayList<Integer> xx = new ArrayList<>();
            for(int i = 0;i<dp.length;i++){
                Arrays.sort(dp[i]);
                xx = new ArrayList<>();
                for(int j= 0;j<dp[i].length;j++){
                    xx.add(dp[i][j]);
                }
                max = Math.max(max,largestRectangleArea(xx));
            }

            return max;
        }
        public int largestRectangleArea(ArrayList<Integer> A) {
            ArrayList<Integer> B = A;

            ArrayList<Integer> prev=  prevSmaller(A);
            Collections.reverse(B);

            ArrayList<Integer> next=  prevSmaller(B);
            Collections.reverse(B);
            ArrayList<Integer> temp = next;
            next = new ArrayList<Integer>();
            for(int i = 0;i<temp.size();i++){
                if(temp.get(temp.size()-1-i)==-1){
                    next.add(-1);
                }else{
                    next.add(temp.size()-1-temp.get(temp.size()-1-i));

                }

            }

            int max = 0;
            int a = 0;
            int b = 0;
            int area = 0;

            int tempi=0;
            for(int i = 0;i<A.size();i++){
                if(prev.get(i)==-1){
                    a = i;
                }else{
                    a=i-prev.get(i)-1;
                }
                if(next.get(i)==-1){
                    b=A.size()-1-i;
                }else{
                    b=next.get(i)-i-1;
                }
                area = (a+b+1)*(A.get(i));
                if(area>max){
                    tempi = i;
                }
                max = Math.max(max,area);
            }

            return max;



        }
        public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
            Deque<Integer> deque = new LinkedList<Integer>();

            int dp[] = new int[A.size()];
            int x = -1;
            //deque.addLast("Element 3 (Tail)");
            //System.out.println(dq.pollLast());
            //removeLast()	This method is used to remove an element from the tail of the queue
            for(int i = 0;i<A.size();i++){
                if(deque.size()==0){
                    dp[i]=-1;
                    deque.addLast(i);
                }else{
                    x= deque.peekLast();
                    if(A.get(x)<A.get(i)){

                        dp[i]=x;
                        deque.addLast(i);
                    }else{

                        while(deque.size()!=0){
                            if(deque.size()==1){
                                x= deque.peekLast();
                                if(A.get(x)==A.get(i)){
                                    deque.removeLast();
                                    break;
                                }
                                if(!(A.get(x)<A.get(i))){
                                    deque.removeLast();
                                    break;

                                }
                                break;

                            }
                            x= deque.peekLast();
                            //yaha fata q ;
                            if(!(A.get(x)<A.get(i))){
                                deque.removeLast();


                            }else{
                                break;
                            }
                        }
                        if(deque.size()==0){
                            dp[i]=-1;
                            deque.addLast(i);
                        }else{
                            dp[i]=deque.peekLast();
                            deque.addLast(i);
                        }


                    }


                }

            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int ij : dp){
                ans.add(ij);
            }
            return ans;

        }
    }
}
