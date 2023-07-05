

import java.util.*;
import java.io.*;

public class Util<T> {

    public String stringAL(ArrayList<T> x){
        StringBuilder sb = new StringBuilder();
        for(T t : x){
            sb.append(t.toString()+" ");
        }
        // oks
        System.out.println("This array list is------++++++");
        System.out.println(sb);
        System.out.println("-------_+++++++This is the array list");
        return sb.toString();
    }

}
