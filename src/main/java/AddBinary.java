import java.util.Iterator;
import java.util.Stack;

/**
 * @author Guillaume Houioux ©
 */
public class AddBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));

    }

    public static String addBinary(String a, String b) {

        int aDecimal = 0, bDecimal = 0;

        for (int i = 0; i < a.length(); i++) {
            aDecimal += (int) (Double.parseDouble(a.charAt(i)+ "") * Math.pow(2, i));
            System.out.println(aDecimal);
        }

        for (int i = 0; i < b.length(); i++) {
            bDecimal += (int) (Double.parseDouble(b.charAt(i)+ "") * Math.pow(2, i));
        }

        int i = 0;
        int res = aDecimal + bDecimal;

        //System.out.println(aDecimal);
        //System.out.println(bDecimal);
        Stack<Integer> stack = new Stack<>();
        String str = "";

        while (res != 1) {

            if (res % 2 != 0) {
                res -= 1;
                stack.add(1);
            } else {
                stack.add(0);
            }
            res /= 2;
        }

        stack.add(1);

        while (!stack.isEmpty()) {
            str += stack.pop().toString();
        }



        return str;
    }
}
