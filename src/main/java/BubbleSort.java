public class BubbleSort {

    public static void execute(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return;
        }

        int n = array.length;

        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (i + 1 < array.length && array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            n--;
        }
    }
}
