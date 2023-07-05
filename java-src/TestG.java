import java.util.*;
public class TestG {
    public static void main(String[] args){
        System.out.println("Hello, World!");
        ArrayList<String> x = new ArrayList<>();
        x.add("R");
        x.add("Y");
        x.add("B");
        x.add("G");
        int count=0;
        for(int i = 0;i<4;i++){
            for(int j =0;j<4;j++){
                if(i==j){
                    continue;
                }
                for(int k=0;k<4;k++){
                    if(j==k){
                        continue;
                    }
                    if(i==k){
                        count++;
                    }
                    System.out.println(x.get(i)+x.get(j)+x.get(k)+"\n");

                }



            }


        }
        System.out.println(count);
    }

}
