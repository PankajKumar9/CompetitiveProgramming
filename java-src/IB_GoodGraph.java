import java.util.*;

public class IB_GoodGraph {
    public static void main(String[] args){


    }
    public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer>[] adj = new ArrayList[A.size()];

        for(int i = 0;i<A.size();i++){
            adj[i] = new ArrayList<Integer>();
            adj[i].add(A.get(i)-1);
        }
        Deque<Integer> deque= new LinkedList<Integer>();
        int[] vis = new int[A.size()];
        for(int i = 0;i<vis.length;i++){
            vis[i] = -1;
        }
        boolean[] good = new boolean[A.size()];

        int curr;
        for(int i = 0;i<A.size();i++){
            if(vis[i] != -1){
                continue;
            }
            deque.addLast(i);
            vis[i] = i;
            while(!deque.isEmpty()){
                curr = deque.removeLast();



            }


        }
            return 0;
    }
}
