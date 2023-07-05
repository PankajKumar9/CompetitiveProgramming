import java.util.*;
public class IB_WordSearchBoard {
    public static void main(String args[]){
        System.out.println("Hello there ");
    }
    public static int exist(ArrayList<String> A, String B) {
        int N= A.size();
        int M = A.get(0).length();
        boolean vis[][] = new boolean[N][M];
        Stack<Integer[]> st = new Stack<>();
        Stack<String> ft = new Stack<>();
        Integer[] curr ;
        String surr;
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                st = new Stack<Integer[]>();
                ft = new Stack<String>();
                st.push(new Integer[]{i,j});
                ft.push(B);
                while(!st.empty()){
                    curr = st.pop();
                    surr = ft.pop();

                    if(A.get(curr[0]).charAt(curr[1])!= surr.charAt(0)){
                        continue;
                    }
                    if(surr.length()==1){
                        return 1;
                    }
                    if (curr[0]>0){
                        st.push(new Integer[]{curr[0]-1,curr[1]});
                        ft.push(surr.substring(1,surr.length()));
                    }
                    if(curr[0]<N-1){
                        st.push(new Integer[]{curr[0]+1,curr[1]});
                        ft.push(surr.substring(1,surr.length()));

                    }
                    if(curr[1]>0){
                        st.push(new Integer[]{curr[0],curr[1]-1});
                        ft.push(surr.substring(1,surr.length()));
                    }
                    if(curr[1]<M-1){
                        st.push(new Integer[]{curr[0],curr[1]+1});
                        ft.push(surr.substring(1,surr.length()));
                    }

                }

            }

        }
        return 0;





    }

}
//    Given a 2D board and a word, find if the word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
//
//        The same letter cell may be used more than once.
//
//        Example :
//
//        Given board =
//
//        [
//        ["ABCE"],
//        ["SFCS"],
//        ["ADEE"]
//        ]
//        word = "ABCCED", -> returns 1,
//        word = "SEE", -> returns 1,
//        word = "ABCB", -> returns 1,
//        word = "ABFSAB" -> returns 1
//        word = "ABCD" -> returns 0
//        Note that 1 corresponds to true, and 0 corresponds to false.
//
//        Show similar questions


