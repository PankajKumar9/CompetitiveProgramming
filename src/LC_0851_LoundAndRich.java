import java.util.*;
import java.io.*;

public class LC_0851_LoundAndRich {

    public static void main(String[] args) throws Exception {
        System.out.println("It is a really good day to code");
        int richer[][] = {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,9},{1,3},{1,4},{1,5},{1,6},{1,7},{1,9},{2,3},{2,4},{2,5},{2,6},{2,7},{2,8},{2,9},{3,5},{3,6},{3,7},{3,8},{3,9},{4,6},{4,7},{4,8},{4,9},{5,6},{5,7},{5,8},{5,9},{6,8},{6,9},{7,9},{8,9}};
        int quiet[]={4,0,3,1,2,6,9,8,5,7};
        for(var x : richer){
            System.out.println(x[0]+" "+x[1]);
        }
        //5 5 2 5 4 5 6 7
        int[] ans= loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
               
        ArrayList<Integer>[] adj = ad(richer, quiet.length);

       boolean vis[] = new boolean[adj.length];
       boolean bis[] = new boolean[adj.length];
       int ans[] = new int[adj.length];
       int bns[] = new int[adj.length];
       for(int i = 0; i < adj.length; i++) {  
           bns[i] = quiet[i];
           ans[i] = i;
       }
       int temp = Integer.MAX_VALUE;
       
       for(int i=0;i<adj.length;i++){
           Stack<Integer> st = new Stack<>();
           Stack<Integer> bt = new Stack<>();
          
           if(!vis[i]){
               vis[i] = true;
               st.push(i);
               bt.push(i);
           }else{
               continue;
           }
       temp = Integer.MAX_VALUE;
       
       int curr = i;
       bis = new boolean[adj.length];
       int brr;
       while(!st.isEmpty()){
       
           curr= st.pop();
           brr = bt.pop();
           temp = bns[brr];
           for(Integer x : adj[curr]){
          
                   if(bns[x]>temp || !bis[x]){
                   vis[x] = true;
                   bis[x]= true;
                   st.push(x);
                   if(bns[x]<temp){
                       bt.push(x);
                   }else{
                       bt.push(brr);
                   }
                   
                   }
               if (bns[x]>temp){
                   bns[x] = temp;
                   ans[x]=brr;
               }
           }
       }
       
       }
 
       return ans;
   }




       


   

   public static ArrayList<Integer>[] ad(int[][] edges,int n) {
       ArrayList<Integer>[] al = new ArrayList[n]; 
       for (int i = 0; i < n; i++) {
           al[i] = new ArrayList<Integer>();}
       for(var i : edges) {
           al[i[0]].add(i[1]);

       }
       return al;



   }
}
