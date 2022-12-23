import java.util.*;

public class PrintMat {
    public static void main(String args[]) {
        Boolean[][] mat = new Boolean[][]{{true, false, true}, {true, true, true}, {false, false, true}};

        Integer[][] dat = new Integer[][]{{3, 7}};
        PrintMatrix(dat);
        PrintMatrix(mat);

    }

    public static <E> void PrintMatrix(E[][] x) {
        for (E[] a : x) {
            System.out.println(Arrays.toString(a));
        }
    }
}





