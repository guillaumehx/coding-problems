public class BubbleSort {

    public static void execute(int[] array) {

        if (array.length == 0 || array.length == 1) {
            return;
        }

        int n = array.length;
        boolean swapped = false;
        int i = 0;
        while (i < n - 1) {
            int j = 0;
            while (j < n - i - 1) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
                j++;
            }

            if (!swapped) {
                break;
            }
            i++;
        }
    }
}
