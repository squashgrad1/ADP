public class BubbleSort {
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
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.println(arrayToSort[i]);
        }
        return;
    }
}
