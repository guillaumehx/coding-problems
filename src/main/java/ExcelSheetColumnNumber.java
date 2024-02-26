/**
 * @author Guillaume Houioux ©
 */
public class ExcelSheetColumnNumber {

    public static int execute(String columnTitle) {

        double current = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            current += (Math.pow(26, columnTitle.length() - (i+1)) * (columnTitle.charAt(i) - 64));
        }

        return (int) current;
    }
}
