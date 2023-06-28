import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int) (Math.random() * 100);
        }
        BubbleSort b = new BubbleSort();
        System.out.println("Original array: " + Arrays.toString(arr));

        b.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    }

