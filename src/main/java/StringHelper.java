public class StringHelper {
    static void getCountWord(String testString, String word) {
        String[] str2Words = testString
                .toLowerCase()
                .split("[, ?.!:]+");
        int countWord = 0;
        for (String str2Word : str2Words) {
            if (str2Word.equals(word)) {
                countWord++;
            }
        }
        System.out.println("Слово '" + word + "'  встречается " + countWord + " раз(а)");
    }

    static void gerCountPunctuation(String testString, String punct) {
        int countPunctuation = 0;
        for (int i = 0; i < testString.length(); i++) {
            char test = testString.charAt(i);
            if (punct.contains(test + "")) {
                countPunctuation++;
            }
        }
        System.out.println("Всего знаков препинания " + countPunctuation);
    }
}
