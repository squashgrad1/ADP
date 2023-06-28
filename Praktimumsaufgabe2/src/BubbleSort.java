import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BubbleSort {
    //  N
    //N+∑N-k
    // k=0
    public void sort(int[] arrayToSort) {
        if (arrayToSort.length == 0) {
            System.out.println("Das Eingabearray ist leer");
            return;
        }
        int checkCount = 0;
        while (checkCount != arrayToSort.length - 1) {
            checkCount = 0;
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int groesser = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = groesser;
                } else {
                    checkCount++;
                }
            }
        }
        return;
    }
    private  static long doublingTestQuickSort(int[] arr){
        StopWatch timer = new StopWatch();
        BubbleSort bubbleSort = new BubbleSort();
        timer.start();
        bubbleSort.sort(arr);
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
    /**
     int[] arr = new int[50];
     for (int i = 0; i < arr.length; i++) {
     arr[i]=(int) (Math.random() * 100);
     }
     BubbleSort b = new BubbleSort();
     System.out.println("Original array: " + Arrays.toString(arr));

     b.sort(arr);

     System.out.println("Sorted array: " + Arrays.toString(arr));
     */
    }

