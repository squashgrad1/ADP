class QuickSort3Particion {

    public static void quickSort(int[] intArray, int left, int right ){
        int i,j,pivot;
        if(right-left>10){
            pivot = medianOf3(intArray,left,right);
            i = left -1;
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
        else insertionSort(intArray,left,right);
    }

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

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0,123,10,11,19,18,17,16,15,14,13,12};
        quickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}