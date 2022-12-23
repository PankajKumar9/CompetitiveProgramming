import java.util.*;
public class IB_WaysToFormMaxHeap {
    public static void main(String args[]){
        int ans = solve(3);
        System.out.println(ans);
    }
    public static int solve(int A) {
        if(A<=3){
            return 1;
        }
        long a[] = new long[A+1];
        a[1]=1;a[2]=1;
        for(int i =3;i<A+1;i++){
            a[i]=a[i-1]+a[i-2];
            a[i]=a[i]%1000000007;
        }
        System.out.println(Arrays.toString(a));
        return (int)a[A];
    }
}
