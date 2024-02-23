import java.util.Map;

/**
 * @author Guillaume Houioux ©
 */
public class RomanToInt {

    public static int execute(String s) {

        Map<Character, Integer> values = Map.of(
                'I',1,
                'V',5,
                'X',10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000);

        int i = s.length() - 1;
        int fin = 0;
        int prev = 0;

        while (i > -1) {
            int curr = values.get(s.charAt(i));
            fin = curr < prev ? fin - curr : fin + curr;
            prev = curr;
            i--;
        }

        return fin;
    }

}
