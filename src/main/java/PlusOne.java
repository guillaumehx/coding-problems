/**
 * @author Guillaume Houioux ©
 */
public class PlusOne {

    public static int[] execute(int[] digits) {

        int current = 0, last = 0;
        boolean shift = false;

        for (int i = digits.length - 1; i >= 0; i--) {

            current = digits[i];

            if (i == digits.length - 1) {
                current++;
            }

            if (last == 1) {
                current++;
                last = 0;
            }

            if (current > 9) {
                digits[i] = 0;

                if (i == 0) {
                    shift = true;
                }

                last = 1;
            } else {
                digits[i] = current;
            }
        }

        int[] finalDigits = new int[shift ? digits.length + 1 : digits.length];
        for (int j = 0; j < finalDigits.length; j++) {

            if (shift) {
                if (j == 0) {
                    finalDigits[j] = 1;
                }
            } else {
                finalDigits[j] = digits[j];
            }
        }

        return finalDigits;
    }

}
