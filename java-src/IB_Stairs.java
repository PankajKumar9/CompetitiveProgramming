import java.util.*;
public class IB_Stairs {
    public static void main(String[] args){


    }
    public static class Solution {
        public int climbStairs(int A) {
            int a[] = new int[A+1];
            a[A] =1;
            a[A-1]=1;
            for(int i = A-2;i>=0;i--){
                a[i]= a[i+1]+a[i+2];

            }
            return a[0];


        }
    }

}
