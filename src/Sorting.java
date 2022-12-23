import java.util.Arrays;

public class Sorting {
    public static void main(String args[]){
        int arr[]= new int[]{5,4,1,234,12,43,12,56,123,531,64,12,-100,-100,0,0,65};
        MergeSort(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{5,4,1,234,12,43,12,56,123,531,64,12,-100,-100,0,0,65};
        QuickSortCaller(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{5,4,1,234,12,43,12,56,123,531,64,12,-100,-100,0,0,65};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{5,4,1,234,12,43,12,56,123,531,64,12,-100,-100,0,0,65};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));

        arr= new int[]{5,4,1,234,12,43,12,56,123,531,64,12,-100,-100,0,0,65};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void MergeSort(int[] arr){
        //2 functions used , sort and merge
        //Complexity O(N.log(N))
        sort(arr, 0, arr.length - 1);
    }
    public static void sort(int arr[], int l, int r){
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    //QUICK SORT
    public static void QuickSortCaller(int[] arr){
        //Complexity O(N.log(N))
        //3 functions used quickSort, Partition and swap
        quickSort(arr,0,arr.length-1);

    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
   public static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    public  static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void SelectionSort(int[] arr){
        //Complexity O(N^2)
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            int k = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[k])
                    k = j;
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int[] arr){
        //Complexity O(N^2)
        int n = arr.length;
        for (int i = 1;i < n;i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void BubbleSort(int[] arr){
        //Complexity O(N^2)
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i =0;i <n - 1;i++){
            swapped = false;
            for (j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

    }








}
