import java.util.*;
public class IB_NearestSmallerElement {
    public static void main(String[] args){
        //-1 8 8 8 16 -1 -1 7 27 7 27 7 -1 -1 1 1 1 1 6 16 26 26
        int[] a= { 8, 23, 22, 16, 22, 7, 7, 27, 35, 27, 32, 20, 5, 1, 35, 28, 20, 6, 16, 26, 48, 34};
     a= new int[]{34, 35, 27, 42, 5, 28, 39, 20, 28};
        ArrayList<Integer> x = new ArrayList<>();
        for(int i : a){
            x.add(i);
        }
        Solution s = new Solution();
        System.out.println("Yaha dekhna toh");
        for(Integer sd :s.prevSmaller(x)){
            System.out.print(sd+" ");
        }
    }
    public static class Solution {
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
                    deque.addLast(A.get(i));
                }else{
                    x= deque.peekLast();
                    if(x<A.get(i)){

                        dp[i]=x;
                        deque.addLast(A.get(i));
                        continue;
                    }else{

                        while(deque.size()!=0){
                            if(deque.size()==1){
                                x= deque.peekLast();
                                if(x==A.get(i)){
                                    dp[i]=x;
                                    break;
                                }
                                if(!(x<A.get(i))){
                                    deque.removeLast();
                                    break;

                                }
                                break;

                            }
                            x= deque.peekLast();
                            //yaha fata q ;
                            if(!(x<A.get(i))){
                                deque.removeLast();


                            }else{
                                break;
                            }
                        }
                        System.out.println("queue ki size ye thi "+deque.size());
                        if(deque.size()==0){
                            dp[i]=-1;
                            deque.addLast(A.get(i));
                        }else{
                            dp[i]=deque.peekLast();
                            deque.addLast(A.get(i));
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
            ArrayList<Integer> ans = new ArrayList<>();
            for(int ij : dp){
                ans.add(ij);
            }
            return ans;


        }
    }


}
