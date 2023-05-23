import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

class QuickSort3Particion {

    public static void quickSort(int[] intArray, int left, int right ){
        int i,j,pivot;
        //if(right-left>10){
            pivot = medianOf3(intArray,left,right);
            i = left - 1;
            j = right -1;
            while(true){
                while(intArray[++i] < pivot);
                while(intArray[--j] > pivot);
                if(i >= j) break;
                else swap(intArray,i,j);
            }
            swap(intArray,i,right-1);
            quickSort(intArray,left,i-1);
            quickSort(intArray,i+1,right);
        }
       // else insertionSort(intArray,left,right);
    //}

    public static int medianOf3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
            swap(intArray, left, center);

        if (intArray[left] > intArray[right])
            swap(intArray, left, right);

        if (intArray[center] > intArray[right])
            swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    public static void swap(int[] intArray, int dex1, int dex2) {
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    public static void insertionSort(int[] intArray, int left, int right) {
        int size =  right - left + 1;
        int k = left;
        for(int i = 1; i <= size; i++){
            for (int j = k; j > 0 && intArray[j] < intArray[j-1]; j--) {
                swap(intArray, j, j - 1);
            }
            k++;
        }
    }

    private  static long doublingTestQuickSort(int[] arr){
        StopWatch timer = new StopWatch();
        timer.start();
        quickSort(arr,0, arr.length-1);
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
