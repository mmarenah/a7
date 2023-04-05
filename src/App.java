import java.util.Arrays;

public class App {
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 9, 1, 4, 7, 6};
        
        long startTime = System.nanoTime();
        int[] sorted1 = bubbleSort(arr.clone());
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " nanoseconds");
        printArray(sorted1);
        
        startTime = System.nanoTime();
        int[] sorted2 = mergeSort(arr.clone(), 0, arr.length-1);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;
        System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");
        printArray(sorted2);
    }
    
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    
    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }
    
    public static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[start+i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid+1+j];
        int i = 0, j = 0, k = start;
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
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void printArray(int[] arr) {
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
