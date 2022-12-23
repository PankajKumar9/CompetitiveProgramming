import java.util.*;

public class IB_Stepping_Numbers {

    public static void main(String args[]){

        ArrayList<String> x = new ArrayList<>();
        ArrayList<String> y = new ArrayList<>();
        ArrayList<Integer> nx = new ArrayList<>();
        for(int l = 1;l<9;l++) {
            x = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                x.add(Integer.toString(i));
            }

            for (int j = 0; j < l; j++) {
                int k = x.size();
                y = new ArrayList<>();

                for (int i = 0; i < k; i++) {


                    ArrayList<String> numbers = getNumbers(x.get(i));
                    for (String s : numbers) {
                        y.add(x.get(i) + s);

                    }


                }

                x = y;
            }

            for(int i = 0;i<x.size();i++){
                nx.add(Integer.parseInt(x.get(i)));
            }

            //yaha tak shi x mil rha h

        }

//        for(int i = 0;i<x.size();i++){
//            System.out.println(x.get(i));
//        }

    }

    public static ArrayList<String> getNumbers(String s){
        int a = Character.getNumericValue(s.charAt(s.length()-1));
        ArrayList<String> ans = new ArrayList<>();
        if(a!=0){
            ans.add(Integer.toString(a-1));
        }
        if(a!=9){
            ans.add(Integer.toString(a+1));
        }
    return ans;


    }



}
