import java.util.*;
import java.io.*;

public class LC_0547_NumberOfProvinces {
    public static class Solution {

        public String stringAL(ArrayList<Integer> x){
            StringBuilder sb = new StringBuilder();
            for(Integer t : x){
                sb.append(t.toString()+" ");
            }
            if(x.size()== 0){
                return "null";
            }
            return sb.toString();
        }

        public  ArrayList<Integer>[] DirectedAdj(int[][] edges,int n,boolean index0) {
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
                for(var i : edges) {
                    if(index0){
                    al[i[0]].add(i[1]);
                   }else{
                        al[i[0]-1].add(i[1]-1);
                  
                    }
         
                }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
        public  ArrayList<Integer>[] unDirectedAdj(int[][] edges,int n,boolean index0 ) {
            if(n==-1){
                int max = -1;
                for(var t : edges){
                    if(t[0]>max){
                        max = t[0];
                    }
                    if(t[1]>max){
                        max = t[1];
                    }
                }
                    n=max;

            }
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
            for(var i : edges) {
                if(index0){
                al[i[0]].add(i[1]);
                al[i[1]].add(i[0]);}else{
                    al[i[0]-1].add(i[1]-1);
                    al[i[1]-1].add(i[0]-1);  
                }
     
            }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
        public  ArrayList<Integer>[] revDirectedAdj(int[][] edges,int n,boolean index0) {
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
                for(var i : edges) {
                    if(index0){
                    al[i[1]].add(i[0]);
                   }else{
                        al[i[1]-1].add(i[0]-1);
                  
                    }
         
                }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
    //Here goes our solutiom func
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Integer>[] adj = new ArrayList[isConnected.length];
        for(int i = 0;i<isConnected.length;i++){
            adj[i] = new ArrayList<Integer>();    
            for(int j = 0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    adj[i].add(j);
                }
            }
        }
        int count = 0;
        Stack<Integer> st = new Stack<>();
        int curr = 0;
         boolean vis[] = new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
            if(vis[i]){
                continue;
            }
            count++;
            st.push(i);
            vis[i] = true;
            while(!st.empty()){
              curr = st.pop();
                for(int x : adj[curr]){
                    if(!vis[x]){
                        st.push(x);
                        vis[x] = true;
                    }
                    
                    
                }
                
                
                
            }
            
            
            
        }
        return count;
        
    }
    }








    public static void main(String[] args) throws Exception {
        System.out.println("It is a really good day to code");
    }
}
