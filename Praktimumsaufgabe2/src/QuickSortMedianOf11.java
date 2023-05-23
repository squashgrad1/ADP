import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class QuickSortMedianOf11 {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //if (high - low > 10) {
                int pivotIndex = partition(arr, low, high);
                int i = low -1;
                int j = high -1;
                while(true){
                    while(arr[++i] < arr[pivotIndex]);
                    while(arr[--j] > arr[pivotIndex]);
                    if(i >= j) break;
                    else swap(arr,i,j);
                }
                swap(arr,i,pivotIndex);
                quickSort(arr, low, i - 1);
                quickSort(arr, i + 1, high);
           // } else {
                //insertionSort(arr, low, high);
            //}
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int[] medians = new int[12];
        for (int i = 0; i < medians.length - 1; i++) {
            medians[i] = low + i * ((high - low) /10);
        }
        medians[medians.length -1] = high;
        for (int j = 0; j < medians.length; j++) {
            for (int i = j+1; i < medians.length; i++) {
                if (arr[medians[j]] > arr[medians[i]])
                    swap(arr, medians[j], medians[i]);
            }
        }
        swap(arr,medians[medians.length/2], high-1);
        return high-1;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private  static long doublingTestQuickSort(int[] arr) {
        StopWatch timer = new StopWatch();
        timer.start();
        quickSort(arr);
        timer.stop();
        return timer.getTime(TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        int j = 100;
        int[] arr = new int[j];
        for (j = 0; j < arr.length; j++) {
            arr[j]=(int) (Math.random() * 100);
        }
        System.out.println("Startet Zeit fuer "+arr.length);
        System.out.println("Zeit fuer "+arr.length+" Elemente zu sortieren: " + doublingTestQuickSort(arr));
        while (true) {
            j = j * 2;
            arr = new int[j];
            for (j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * 100);
            }
            System.out.println("Startet Zeit fuer " + arr.length);
            System.out.println("Zeit fuer " + arr.length + " Elemente zu sortieren: " + doublingTestQuickSort(arr));
        }
    }
}
