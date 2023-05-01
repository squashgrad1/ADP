import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
//TODO Zugriffe berechnen
    private void merge(int arr[], int lo, int mid1, int mid2, int hi, int aux[]){
        int i = lo;
        int j = mid1;
        int k = mid2;
        int l = lo;

        //Alle 3 Arrays Vergleichen
        while((i < mid1) && (j<mid2) && (k<hi)){
            if (arr[i] < arr[j]){
                if(arr[i] < arr[k])
                      aux[l++] = arr[i++];
                else  aux[l++] = arr[k++];
            }
            else
            {
                if(arr[j] < arr[k])
                     aux[l++] = arr[j++];
                else aux[l++] = arr[k++];
            }
        }

        //linkes und mittleres Array bleiben übrig
        while((i < mid1) && (j < mid2)){
            if (arr[i] < arr[j])
                 aux[l++] = arr[i++];
            else aux[l++] = arr[j++];
        }

        //mittleres und rechtes Array bleiben übrig
        while((j < mid2) && (k < hi)){
            if (arr[k] < arr[j])
                aux[l++] = arr[k++];
            else aux[l++] = arr[j++];
        }

        //mittleres und rechtes Array bleiben übrig
        while((i < mid1) && (k < hi)){
            if (arr[k] < arr[i])
                aux[l++] = arr[k++];
            else aux[l++] = arr[i++];
        }

        //übrig gebliebene Werte werden rechts angehängt
        while(i < mid1){
            aux[l++] = arr[i++];
        }
        while(j < mid2){
            aux[l++] = arr[j++];
        }
        while(k < hi){
            aux[l++] = arr[k++];
        }
    }

    private void recSort(int arr[], int lo, int hi, int aux[]){
        if(hi - lo < 2) return;

        int mid1 = lo+((hi - lo)/3);
        int mid2 = lo+2*((hi - lo)/3);

        if(mid1 == mid2)
            mid2= mid1+((hi - mid1)/2);

        recSort(aux,lo,mid1,arr);
        recSort(aux,mid1,mid2,arr);
        recSort(aux,mid2,hi,arr);

        merge(aux,lo,mid1,mid2,hi,arr);
    }

    public void sort(int[] arr){
        if(arr.length < 2) return;
        int [] aux = Arrays.copyOf(arr,arr.length);
        recSort(arr,0, arr.length, aux);
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] a = {2,1,5,3,4,6,9,8,7,234,456,324,342,32,44,5,243,234,3,456,243,4,23,5,34,5432,432,0,254,56,4576,456,342,2,4,6};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print("\n");
        sort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
