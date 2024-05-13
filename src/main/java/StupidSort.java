import java.util.Random;

public class StupidSort {
    
    public static void execute(Integer[] array) {
        boolean isSorted = isSorted(array);
        while (!isSorted) {
            shuffleIntArray(array);
            isSorted = isSorted(array);
        }
    }

    public static void shuffleIntArray(Integer[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static boolean isSorted(Integer[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i+1 < array.length && array[i] > array[i+1]) {
                return false;
            }
        }

        return true;
    }

}
