import java.util.*;
import java.util.Random;   
import java.io.*;
public class BinarySearch {
	public static int bS(int arr[], int x)
	{
		//THIS FUNCTION RETURNS NEGATIVE OF WHERE IT CAN BE INSERTED IF NOT FOUND
		//IF CAN BE INSERTED AT 4 , WE MULTIPLY IT WITH -1 AND SUBTRACT 1 MORE TO 
		//KEEP RESULT STRICTLY NEGATIVE FOR NOT FOUND 
		//SO IF IT CAN BE INSERTED AT 0 , WE RETURN -1
		  int lo = 0, hi = arr.length - 1;
		    while (hi - lo > 1) {
		 
		        int mid = (hi + lo) / 2;
		        if (arr[mid] < x) {
		            lo = mid + 1;
		        }
		        else {
		            hi = mid;
		        }
		    }
		    if (arr[lo] == x) {
		      return lo;
		    }
		    else if (arr[hi] == x) {
		        return hi;
		    }
		    int pos = 0;
		    if(arr[hi]>x) {
		    	pos = hi+1;
		    }
		    else if (x<arr[lo]) {
		    	pos = lo;
		    }
		    else {
		    	pos = hi;
		    }
		   return (-1*pos)-1;
	}
	public static void main(String args[]) {
		int a[] = new int[]{5,150,3500,70000,1000000};
		int b[];
		Random rand = new Random(); 
		int x =100,y = 10000000;
		int t =0;
		for(int i = 0;i<a.length;i++) {
			b = generateSorted(a[i],x,y);
			t = rand.nextInt(y-x+1);
			 List<Integer> list1 = new ArrayList<Integer>();
		      for(int j = 0;j<b.length;j++) {
		    	  list1.add(b[j]);
		      }
		      boolean cv = bS(b,t)==Collections.binarySearch(list1, t);
		      if(!cv) {
		    	  System.out.println("@@@@@@@@%%%%%%%");
		    	  System.out.println("Arrays := ");
		    	  System.out.println(Arrays.toString(b));
		    	  try {write("APPLES",b);}
		    	  catch(IOException e)  {
		    		  System.out.println("DO NOTHING ");
		    	  }
		    	  System.out.println("ToFInd := ");
		    	  System.out.println(t);
		    	  System.out.println("%%%%%%%");
		    	  
		      }
			System.out.println(t);
			
		}
		
		
		
		
		
		
	
		
		
	}
	public static int[] generateSorted(final int length, final int minVal, final int maxVal) {
		Random rand = new Random();     
		int span = maxVal - minVal + 1;
		   int[] accumulator = new int[span];
		   for(int genIdx = 0; genIdx < length; genIdx++) {
		      accumulator[rand.nextInt(span)]++;
		   }
		   int resultIdx = 0;
		   int[] result = new int[length];
		   for(int accIdx = 0; accIdx < span; accIdx++) {
		      for(int valIdx = 0; valIdx < accumulator[accIdx]; valIdx++) {
		         result[resultIdx++] = accIdx + minVal;
		      }
		   }
		   return result;
		}
	
	
	
	public static void write (String filename, int[]x) throws IOException{
		  BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter(filename));
		  outputWriter.write(Arrays.toString(x));
//		  for (int i = 0; i < x.length; i++) {
//		    // Maybe:
//		    outputWriter.write(x[i]+"");
//		    // Or:
//		    outputWriter.write(Integer.toString(x[i]));
//		    outputWriter.newLine();
//		  }
		  outputWriter.flush();  
		  outputWriter.close();  
		}
}
