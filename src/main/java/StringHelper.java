import java.util.Arrays;
import java.util.List;

public class StringHelper {

    static String[] getWordsArray(String firstString) {
        return firstString
                .toLowerCase()
                .split("[, ?.!:]+");
    }

    static void writeUniqueWords(String[] str1Words, String[] str2Words) {
        List<String> str2WordsList = Arrays.asList(str2Words);
        for (String str1Word : str1Words) {
            if (!str2WordsList.contains(str1Word))
                System.out.println(str1Word);
        }
    }
}
