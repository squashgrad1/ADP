import java.util.Arrays;

//Aufgabe 1
public class LocalMaximum {

    public static void main(String[] args) {
        int[] ary1 = {1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary2 = {1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] ary3 = {99,1, 61, 89, 75, 16, 33, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15};
        int[] erg1 = localMaximum(ary1,2);
        int[] erg2 = localMaximum(ary2,3);
        System.out.println("local max array 1: " + Arrays.toString(erg1));
        System.out.println("local max array 2: " + Arrays.toString(erg2));
        System.out.println("local max array 3: " + Arrays.toString(localMaximum(ary3,1)));
    }


    //TODO
    static int[] localMaximum(int[] array, int radius){

        if(radius >= array.length / 2) return null;
        int first = 0;
        int last = array.length - 1;
        int middle = (first + last) / 2;
        int[] localMaxArray;

        //Der Wert links vom vermutetem lokalen Maximums ist größer. Es wird links weiter gesucht
        if (array[middle - 1] > array[middle]) {
            localMaxArray = recLocalMaximum(array, radius, first, middle);
            //links wurde keine Lösung gefunden, also wird rechts weiter gesucht
            if (localMaxArray == null) {
                return recLocalMaximum(array, radius, middle, last);
            } else return localMaxArray;
        }

        //Der Wert rechts vom vermutetem lokalen Maximums ist größer. Es wird rechts weiter gesucht
        if (array[middle + 1] > array[middle]) {
            localMaxArray = recLocalMaximum(array, radius, middle, last);
            //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
            if (localMaxArray == null) {
                return recLocalMaximum(array, radius, first, middle);
            } else return localMaxArray;
        }


        if (checkLeftSide(array, radius, middle)) {
            if (checkRightSide(array, radius, middle)) {
                //Es wurde eine Lösung gefunden
                return getLocalMaxArray(array, radius, middle);
            }


            //Die Werte rechts vom vermutetem lokalen Maximums folgen nicht der gegebenen Folge. Es wird rechts weiter gesucht
            else {
                //Die Werte rechts vom vermutetem lokalen Maximums folgen nicht der gegebenen Folge. Es wird rechts weiter gesucht
                localMaxArray = recLocalMaximum(array, radius, middle, last);
                //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
                if (localMaxArray == null) {
                    return recLocalMaximum(array, radius, first, middle);
                } else return localMaxArray;
            }
        }


        else {
            //Die Werte links vom vermutetem lokalen Maximums folgen nicht der gegebenen Folge. Es wird links weiter gesucht
            localMaxArray = recLocalMaximum(array, radius, first, middle);
            //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
            if (localMaxArray == null) {
                return recLocalMaximum(array, radius, middle, last);
            }
            return localMaxArray;


        }
    }


    private static int[] recLocalMaximum(int[] array, int radius, int first, int last) {
        int middle = (first + last) / 2;
        int[] localMaxArray;

        //Wenn middle first oder last ist wurde dieser index schon geprüft und es wurde nichts gefunden
        if (middle == first || middle == last) return null;

        //Der Wert links vom vermutetem lokalen Maximums ist größer. Es wird links weiter gesucht
        if (array[middle - 1] > array[middle]) {
            localMaxArray = recLocalMaximum(array, radius, first, middle);
            //links wurde keine Lösung gefunden, also wird rechts weiter gesucht
            if (localMaxArray == null) {
                return recLocalMaximum(array, radius, middle, last);
            } else return localMaxArray;
        }

        //Der Wert rechts vom vermutetem lokalen Maximums ist größer. Es wird rechts weiter gesucht
        if (array[middle + 1] > array[middle]) {
            localMaxArray = recLocalMaximum(array, radius, middle, last);
            //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
            if (localMaxArray == null) {
                return recLocalMaximum(array, radius, first, middle);
            } else return localMaxArray;
        }


        if (checkLeftSide(array, radius, middle)) {
            if (checkRightSide(array, radius, middle)) {
                //Es wurde eine Lösung gefunden
                return getLocalMaxArray(array, radius, middle);
            }


            else {
                //Die Werte rechts vom vermutetem lokalen Maximums folgen nicht der gegebenen Folge. Es wird rechts weiter gesucht
                localMaxArray = recLocalMaximum(array, radius, middle, last);
                //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
                if (localMaxArray == null) {
                    return recLocalMaximum(array, radius, first, middle);
                } else return localMaxArray;
            }
        }


        else {
            //Die Werte links vom vermutetem lokalen Maximums folgen nicht der gegebenen Folge. Es wird links weiter gesucht
            localMaxArray = recLocalMaximum(array, radius, first, middle);
            //rechts wurde keine Lösung gefunden, also wird links weiter gesucht
            if(localMaxArray == null){
                return recLocalMaximum(array, radius, middle, last);
            }return localMaxArray;
        }
    }

    private static int[] getLocalMaxArray (int[] array, int radius, int indexLocalMax){
        int [] localMaxArray = new int[2*radius + 1];
        int j = 0;
        for(int i = indexLocalMax - radius; i <= indexLocalMax + radius; i++){
            localMaxArray[j] = array[i];
            j++;
        }
        return localMaxArray;
    }

    private static boolean checkLeftSide(int[] array, int radius, int indexLocalMax){
        for(int i = indexLocalMax - radius; i < indexLocalMax; i++){
            if(!(array[i] < array[i+1])) return false;
        }
        return true;
    }

    private static boolean checkRightSide(int[] array, int radius, int indexLocalMax){
        for(int i = indexLocalMax + 1; i < indexLocalMax + radius; i++){
            if(!(array[i] > array[i+1])) return false;
        }
        return true;
    }
}
