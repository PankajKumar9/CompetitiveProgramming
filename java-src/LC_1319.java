import java.nio.file.*;
import java.util.*;
import java.io.*;

public class LC_1319 {
    public static class Util<T> {

        public String stringAL(ArrayList<T> x){
            StringBuilder sb = new StringBuilder();
            for(T t : x){
                sb.append(t.toString()+" ");
            }
            if(x.size()== 0){
                return "null";
            }
            return sb.toString();
        }
    
    }
    public static void main(String[] args) throws Exception {
        System.out.println("It is a really good day to code");
        int[][] connections = new int[][]{{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}};
            int n = 11;
            Solution x = new Solution();
            System.out.println(x.makeConnected(n,  connections));
    }
   public static class Solution {
        public int makeConnected(int n, int[][] connections) {
            if(connections.length<n-1){
                return -1;
            }
            Util<Integer> nm = new Util<>();
            ArrayList<Integer>[] adj = ad(connections,n);
            System.out.println("printing al ");
            for(var d : adj){
                System.out.println(nm.stringAL(d));
        }
        System.out.println("----printing al ");
            boolean vis[] = new boolean[n];
            Stack<Integer> st = new Stack<>();
            int curr = 0;
            int count = -1;
            for(int i=0;i<adj.length;i++){
                if(!vis[i]){
                    System.out.println("i = " + i);
                    curr = i;
                    vis[i] = true;
                    count++;
                    st.push(i);
                }
            while(!st.empty()){
                curr = st.pop();
                System.out.println("CURR = "+curr);
                vis[curr] = true;
       
                
                for(int j=0;j<adj[curr].size();j++){
                    if(!vis[adj[curr].get(j)]){
                        vis[adj[curr].get(j)] = true;
                        st.push(adj[curr].get(j));
                    }


            }

        }


            }


            return count;
        }
        public static ArrayList<Integer>[] ad(int[][] edges,int n) {
            ArrayList<Integer>[] al = new ArrayList[n]; 
            System.out.println("n= "+n);
            for (int i = 0; i < n; i++) {
                al[i] = new ArrayList<Integer>();}
            for(var i : edges) {
                al[i[0]].add(i[1]);
     
            }
            System.out.println("n= "+n);
            return al;
     
     
     
        }
    }
}
