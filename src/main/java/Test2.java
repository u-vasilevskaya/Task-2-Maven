import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Test2 {
    public static void main(String args[]) {
        try {
            File file = new File("./src/main/resources/config2.xml");
            //работа с xml
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Strings");

            Element strings = (Element) nList.item(0);
            String word = strings.getElementsByTagName("Word").item(0).getTextContent();
            String testString = strings.getElementsByTagName("String").item(0).getTextContent();

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

            int countPunctuation = 0;

            for (int i = 0; i < testString.length(); i++) {
                switch (testString.charAt(i)) {
                    case '.':
                        countPunctuation++;
                        break;
                    case ',':
                        countPunctuation++;
                        break;
                    case '?':
                        countPunctuation++;
                        break;
                    case '!':
                        countPunctuation++;
                        break;
                    case ':':
                        countPunctuation++;
                        break;
                    case ';':
                        countPunctuation++;
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Всего знаков препинания " + countPunctuation);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}