

import java.util.Arrays;

public class HeapSort {
	public static void main(String args[]) {
		
		
		int a[] = new int[] {12,54,54,12,54,213,1234,643};
		System.out.println(Arrays.toString(mergesort(a,0,a.length-1)));
		
		
		
	}
	public static int[] mergesort(int[] a,int l , int r) {
		
	
		
		
		if(l==r) {
			int b1[] = new int[1];
			b1[0]= a[l];
			return b1;
		}
		if(r==l+1) {
			int b1[] = new int[2];
			b1[0]= a[l];
			b1[1] = a[r];
			if(b1[0]>b1[1]) {
				b1[0]=a[r];
				b1[1]=a[l];
				
				
			}
			return b1;
		
		}
		
		
		int[] a1 = mergesort(a,l,(l+r)/2);
		int[] a2 = mergesort(a,(l+r)/2+1,r);
		
		int a3[] = new int[a1.length+a2.length];
		int x = 0;int y= 0;
		for(int i =0;i<a3.length;i++) {
			if(y<a2.length && x<a1.length) {
			if(a1[x]<a2[y] ) {
				a3[i]= a1[x];
				x++;
			
			}else {
				a3[i]= a2[y];
				y++;
				
			}
			}else {
				
				if(x<a1.length) {
					a3[i]= a1[x];
					x++;
				}else {
					a3[i]= a2[y];
					y++;
					
				}
				
				
				
			}
			
			
		}
		
		return a3;
		
		
	}
	
}
