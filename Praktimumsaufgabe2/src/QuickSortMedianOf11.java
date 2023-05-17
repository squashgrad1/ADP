import java.util.Arrays;

public class QuickSortMedianOf11 {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            if (high - low > 10) {
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
            } else {
                insertionSort(arr, low, high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int left = low;
        int[] center = low + (high - low) / 10;
        int center = low + 2 * ((high - low) / 10);
        int centerRight = low + 3 * ((high - low) / 10);
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

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 8, 3, 7, 4, 6, 2,2,43,45,456,453,432,342,756,0,786,897,7896,456453,3,453,645,564,432,123,7,756,7896,90,7,789,765,56,5,433,3,3,3,45,5,76,89,76,5,57,8,9,0,0,9,786,6,5,443,3,45,566,7,889,9,8,76,5};
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
