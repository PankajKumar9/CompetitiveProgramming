import java.util.*;
public class LC_0084_LargestRectangleInHistogram {
    public static void main(String args[]){
        Solution x = new Solution();
        int[] h = new int[]{2,1,5,6,2,3};
        x.largestRectangleArea(h);

    }
   public static class Solution {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> deque = new LinkedList<Integer>();

            int dp[] = new int[heights.length];
            int x = -1;
            //deque.addLast("Element 3 (Tail)");
            //System.out.println(dq.pollLast());
            //removeLast()	This method is used to remove an element from the tail of the queue
            for(int i = 0;i<heights.length;i++){
                if(deque.size()==0){
                    dp[i]=-1;
                    deque.addLast(i);
                }else{
                    x= deque.peekLast();
                    if(heights[x]<heights[i]){

                        dp[i]=x;
                        deque.addLast(i);
                    }else{

                        while(deque.size()!=0){
                            x= deque.peekLast();
                            if(!(heights[x]<heights[i])){
                                deque.removeLast();


                            }else{
                                break;
                            }
                        }
                        if(deque.size()==0){
                            dp[i]=-1;
                            deque.push(i);
                        }else{
                            dp[i]=deque.pollLast();
                            deque.push(i);
                        }


                    }


                }
                System.out.println("for i = "+i);
                for (Iterator itr = deque.iterator();
                     itr.hasNext();) {
                    System.out.print(itr.next() + " ");
                }
                System.out.println("");
                System.out.println("-------");
            }

            for(int i = 0;i<dp.length;i++){
                System.out.print(heights[i]+",");

            }
            System.out.println("");

            for(int i = 0;i<dp.length;i++){
                System.out.print(dp[i]+",");

            }


            return 0;
        }

    }


}
