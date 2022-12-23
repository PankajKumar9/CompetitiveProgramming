import java.util.*;
public class IB_PathWithGoodNodes {
    public static void main(String args[]){
        System.out.println("Hello ");
        int[] a =  {1, 1, 0, 0, 1  };
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0;i<a.length;i++){A.add(a[i]);}
        int[][] b = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5},
        };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        ArrayList<Integer> temp= new ArrayList<>();
        for(int i = 0;i<b.length;i++){
            temp.add(b[i][0]);
            temp.add(b[i][1]);
            B.add(temp);
            temp = new ArrayList<Integer>();

        }
        int C = 0;
        //expected 5;


        System.out.println(solve(A,B,C));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, final int C) {
        ArrayList<Integer>[] adj = adj(B);
        System.out.println("this is C at entry  "+C);
        for(int i = 0;i<adj.length;i++){
            System.out.print(" "+i+": ");
            for(Integer asd : adj[i]){
                System.out.print(", "+asd);
            }
            System.out.println("");
        }
        boolean vis[] = new boolean[adj.length];
        Stack<Integer> st = new Stack<>();
        Stack<Integer> pt = new Stack<>();
        int purr;
        int curr;
        int count = 0;
        for(int i = 0;i<adj.length;i++){
            if(vis[i]){
                continue;
            }
            System.out.println("this is i "+i);
            System.out.println("this is C "+C);
            st.push(i);
            pt.push(C);
            vis[i]= true;

            while(!st.empty()){
                curr = st.pop();
                purr = pt.pop();
                System.out.println("purr = "+purr);
                if(A.get(curr)==1){
                    if(purr == 0){
                        continue;
                    }
                    purr -=1;
                }
                if(adj[curr].size()==1){
                    count++;
                }
                for(Integer t : adj[curr]){
                    if(!vis[t]){
                        vis[t]= true;
                        st.push(t);
                        System.out.println("purr in = "+purr);
                        pt.push(purr);
                    }

                }


            }



        }

        return count;

    }
    public static ArrayList<Integer>[] adj(ArrayList<ArrayList<Integer>> B){
        ArrayList<Integer>[] adj = new ArrayList[B.size()+1];
        for(int i = 0;i<adj.length;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0;i<B.size();i++){
            adj[B.get(i).get(0)-1].add(B.get(i).get(1)-1);
            adj[B.get(i).get(1)-1].add(B.get(i).get(0)-1);

        }
        return  adj;

    }

}



//    int[][] b = {
//            {10, 6},
//            {3, 2},
//            {12, 7},
//            {9, 5},
//            {2, 1},
//            {8, 3},
//            {7, 1},
//            {4, 2},
//            {6, 3},
//            {11, 4},
//            {5, 3},
//            {13, 11},
//    };

//    int[] a =  { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1 };

//    int C = 7;
//expected 5;