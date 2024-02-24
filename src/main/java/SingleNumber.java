/**
 * @author Guillaume Houioux ©
 */
public class SingleNumber {

    public static Integer execute(int[] nums) {
        int result = 0;

        for (int i : nums) {
            result ^= i;
        }

        return result;
    }
}
