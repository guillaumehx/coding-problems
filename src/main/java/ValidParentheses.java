import java.util.List;

/**
 * @author Guillaume Houioux ©
 */
public class ValidParentheses {

    public static boolean isValid(String s) {

        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        List<String> matches = List.of("()", "[]", "{}");

        for (int i = 0; i < s.length(); i+=2) {
            if (i + 1 <= s.length() - 1 && !matches.contains("" + s.charAt(i) + s.charAt(i+1))) {
                return false;
            }
        }

        return true;
    }
}
