import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static void main() {
        try {
            File file = new File("./src/main/resources/config.xml");
            //работа с xml
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Strings");

            Element strings = (Element) nList.item(0);
            String firstString = strings.getElementsByTagName("FirstString").item(0).getTextContent();
            String secondString = strings.getElementsByTagName("SecondString").item(0).getTextContent();

            // перевод строки в массив слов для сравнеия без учета регистра и знаков препинания
            String[] str1Words = firstString
                    .toLowerCase()
                    .split("[, ?.!:]+");
            String[] str2Words = secondString
                    .toLowerCase()
                    .split("[, ?.!:]+");
            List<String> str2WordsList = Arrays.asList(str2Words);

            for (String str1Word : str1Words) {
                if (!str2WordsList.contains(str1Word))
                    System.out.println(str1Word);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}