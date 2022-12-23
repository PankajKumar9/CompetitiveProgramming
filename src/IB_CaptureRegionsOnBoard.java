import java.util.*;

public class IB_CaptureRegionsOnBoard {
    public static void main(String args[]){
        System.out.println("Teri keh k lunga ");
    }
    public static void solve(ArrayList<ArrayList<Character>> a) {
        Stack<Integer[]> st= new Stack<>();
        int N = a.size();
        int M = a.get(0).size();
        boolean[][] vis = new boolean[N][M];
        Character[][] data = new Character[N][M];
        for(int i = 0;i<N;i++){
            if(a.get(i).get(0)=='O'){
                st.push(new Integer[]{i,0});
                vis[i][0]=true;
            }
            if(a.get(i).get(M-1)=='O'){
                st.push(new Integer[]{i,M-1});
                vis[i][M-1]=true;
            }

        }

        for(int j = 0;j<M;j++){
            if(a.get(0).get(j)=='O'){
                st.push(new Integer[]{0,j});
                vis[0][j]=true;
            }
            if(a.get(N-1).get(j)=='O'){
                st.push(new Integer[]{N-1,j});
                vis[N-1][j]=true;
            }

        }
        Integer[] curr;
        int x;int y;
        while(!st.empty()){
            curr = st.pop();
            x = curr[0];
            y= curr[1];
            if(x>0){
                if(a.get(x-1).get(y)=='O'){
                    if(!vis[x-1][y]){
                        vis[x-1][y]= true;
                        st.push(new Integer[]{x-1,y});
                    }}
            }
            if(x<N-1){
                if(a.get(x+1).get(y)=='O'){
                    if(!vis[x+1][y]){
                        vis[x+1][y]= true;
                        st.push(new Integer[]{x+1,y});
                    }}
            }
            if(y>0){
                if(a.get(x).get(y-1)=='O'){
                    if(!vis[x][y-1]){
                        vis[x][y-1]= true;
                        st.push(new Integer[]{x,y-1});
                    }}
            }
            if(y<M-1){
                if(a.get(x).get(y+1)=='O'){
                    if(!vis[x][y+1]){
                        vis[x][y+1]= true;
                        st.push(new Integer[]{x,y+1});
                    }}
            }










        }

        for(int i=0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(vis[i][j]){
                    a.get(i).set(j,'O');
                }


            }


        }


    }
}

