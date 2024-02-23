import java.util.HashMap;
import java.util.Map;

/**
 * @author Guillaume Houioux ©
 */
public class TwoSum {

    public static int[] execute(int[] nums, int target) {

        Map<Integer, Integer> ints = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (ints.containsKey(target - nums[i])) {
                return new int[] { ints.get(target - nums[i]), i };
            }
            ints.put(nums[i], i);
        }

        throw new RuntimeException();
    }
}
