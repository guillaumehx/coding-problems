public class BubbleSort {

    public static void execute(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int n = arr.length;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (i + 1 < arr.length && arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            n--;
        }
    }
}
