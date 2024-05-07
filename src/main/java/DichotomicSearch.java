/**
 * @author guho
 */
public class DichotomicSearch {

    public static Integer execute(Integer[] array, Integer bi, Integer bs, Integer k) {
        if (bs < bi) {
            return -1;
        } else {
            int m = (int) (bi + Math.floor((bs - bi) / 2));
            System.out.println(m);
            if (array[m].equals(k)) {
                return m;
            } else if (array[m] < k) {
                // Left
                return execute(array, m+1, bs, k);
            } else {
                // Right
                return execute(array, bi, m-1, k);
            }
        }
    }
}
