import java.util.*;
public class Testing {
    public static HashMap<String,Integer> mp;
    public static void main(String[] args){
        MyClass s = new MyClass();
        ArrayList<Integer> X = new ArrayList<>();
        X.add(43);
        X.add(3);
        X.add(3);
        System.out.println("status 1 it is "+(X.get(1)==X.get(2)));//TRUE
        int[] a = new int[]{630, 197, 197, 821, 923, 752};

        ArrayList<Integer> BX = new ArrayList<>();

       BX.add(630);
       BX.add(197);
       BX.add(197);
        System.out.println("status 1 it is "+(BX.get(1)==BX.get(2)));
        System.out.println("B[1] = "+BX.get(1));
        System.out.println("B[2] = "+BX.get(2));
        System.out.println("status 4 it is "+(BX.get(1)==BX.get(2)));
        s.TestFunction(X);
        HashMap<ArrayList<Integer>,String> mp = new HashMap<ArrayList<Integer>, String>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.add(0);ar.add(1);ar.add(2);
        ArrayList<Integer> br = new ArrayList<Integer>();
        br.add(0);br.add(1);br.add(2);
        mp.put(ar,"sample");
        System.out.println("status 23 is"+mp.containsKey(br));


    }

    public static class MyClass {
        public void TestFunction( ArrayList<Integer> BX) {
            System.out.println("B[1] = "+BX.get(1));
            System.out.println("B[2] = "+BX.get(2));
            System.out.println("status 2 it is "+(BX.get(1)==BX.get(2)));//TRUE
            System.out.println("status 3 it is "+(BX.get(1)-BX.get(2)==0));
        }
    }

}
//OUTPUT ON CONSOLE :
//status 1 it is true
//        B[1] = 197
//        B[2] = 197
//        status 2 it is false
//        status 3 it is true
