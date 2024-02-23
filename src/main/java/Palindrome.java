/**
 * @author Guillaume Houioux ©
 */
public class Palindrome {

    public static boolean execute(int x) {

        char[] input = Integer.toString(x).toCharArray();
        int i = 0, j = input.length - 1;

        while (i < j) {
            if (input[i] != input[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
