/**
 * @author Guillaume Houioux ©
 */
public class RoundedDownSquareRoot {

    public static int execute(int x) {

        double temp = (double) x/2;
        double prev = 0;

        while (Math.abs(temp - prev) != 0) {
            prev = temp;
            temp = 0.5 * (temp + (x/temp));
        }
        return (int) temp;
    }

}
