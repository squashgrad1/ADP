import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class QuickSortMedianOf5 {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
            if (high - low > 1) {
                int pivotIndex = partition(arr, low, high);
            int i = low ;
            int j = high -1;
            while(true){
                while(arr[++i] < arr[pivotIndex]);
                while(arr[--j] > arr[pivotIndex] && j>0);
                if(i >= j) break;
                else swap(arr,i,j);
            }
            swap(arr,i,high-1);
            quickSort(arr,low,i);
            quickSort(arr,i,high);
            } //else {
               // insertionSort(arr, low, high);
           // }

    }


    private static int partition(int[] arr, int low, int high) {
        int left = low;
        int centerLeft = low + (high - low) / 4;
        int center = low + 2 * ((high - low) / 4);
        int centerRight = low + 3 * ((high - low) / 4);
        int right = high;

        if (arr[left] > arr[centerLeft])
            swap(arr, low, centerLeft);
        if (arr[left] > arr[center])
            swap(arr, left, center);
        if (arr[left] > arr[centerRight])
            swap(arr, left, centerRight);
        if (arr[left] > arr[right])
            swap(arr, left, right);

        if (arr[centerLeft] > arr[center])
            swap(arr, centerLeft, center);
        if (arr[centerLeft] > arr[centerRight])
            swap(arr, centerLeft, centerRight);
        if (arr[centerLeft] > arr[right])
            swap(arr, centerLeft, right);

        if (arr[center] > arr[centerRight])
            swap(arr, center, centerRight);
        if (arr[center] > arr[right])
            swap(arr, center, right);

        if (arr[centerRight] > arr[right])
            swap(arr, centerRight, right);

        swap(arr,center,high-1);
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
        /**
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
         */
    }
}

