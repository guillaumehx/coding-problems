import java.util.ArrayList;
import java.util.List;

public class PigIt {
    public static void main(String[] args) {

        String input1 = "Pig latin is cool i";
        String input2 = "Hello world !";

        System.out.println(pigIt(input2));

    }

    public static String pigIt(String expression) {

        List<String> words = new ArrayList<>(List.of(expression.split(" ")));

        for (int i = 0; i < words.size(); i++) {

            String actualWord = words.get(i);
            if(actualWord.length() == 1 && !Character.isLetter(actualWord.charAt(0))) {
                continue;
            }

            List<String> letters = new ArrayList<>(List.of(actualWord.split("")));
            String firstLetter = letters.get(0);
            letters.remove(0);
            letters.add(firstLetter);

            words.set(i, String.join("", letters) + "ay");
        }

        return String.join(" ", words);
    }

    //private static boolean isValid(String word) {
    //    if(word.length() > 1) {
    //        return true;
    //    } else if(word.length() == 1) {
    //        int c = word.charAt(0);
    //        if((c > 64 && c < 91) || c > 96 && c < 123) {
    //            return true;
    //        }
    //    }
    //    return false;
    //}
}
