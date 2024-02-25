/**
 * @author Guillaume Houioux ©
 */
public class RoundedDownSquareRoot {

    public static int execute(int x) {

        double temp = (double) x/2;
        double prev = 0;
        double abs = temp - prev;

        // Could be replaced by Math.abs(temp-prev) != 0 inside
        // the while loop but since no built-in functions are
        // allowed, use of manual computation for absolute value
        while (((abs < 0) ? -abs : abs) != 0) {
            prev = temp;
            temp = 0.5 * (temp + (x/temp));
            abs = temp - prev;
        }
        return (int) temp;
    }

}
