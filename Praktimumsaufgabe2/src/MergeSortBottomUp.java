import java.util.Arrays;
public class MergeSortBottomUp {
    public static void merge(int[] arr, int lo, int mid, int hi, int[] aux)
    {
        int k = lo;
        int i = lo;
        int j = mid + 1;

        while (i <= mid && j <= hi)
        {
            if (arr[i] < arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
            }
        }

        while (i < arr.length && i <= mid) {
            aux[k++] = arr[i++];
        }

        for (i = lo; i <= hi; i++) {
            arr[i] = aux[i];
        }
    }

    public static void mergesort(int[] arr)
    {
        int lo = 0;
        int hi = arr.length - 1;

        int[] aux = Arrays.copyOf(arr, arr.length);

        for (int m = 1; m <= hi - lo; m = 2*m)
        {
            for (int i = lo; i < hi; i += 2*m)
            {
                int from = i;
                int mid = i + m - 1;
                int to = Integer.min(i + 2*m - 1, hi);

                merge(arr, from, mid, to, aux);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) - 100;
        }
        System.out.println("Original array: " + Arrays.toString(arr));
        mergesort(arr);
        System.out.println("Modified array: " + Arrays.toString(arr));
    }
}
