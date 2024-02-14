/**
 * @author Guillaume Houioux ©
 */
public class GCD {

    public static int execute(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return execute(b, a % b);
    }
}
