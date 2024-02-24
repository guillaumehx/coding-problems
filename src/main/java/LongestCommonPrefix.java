/**
 * @author Guillaume Houioux ©
 */
public class LongestCommonPrefix {

    public static String execute(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!prefix.isEmpty() && !strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

}
