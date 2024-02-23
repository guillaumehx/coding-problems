import java.util.ArrayList;
import java.util.List;

public class PigIt {

    public static String execute(String expression) {

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

}
