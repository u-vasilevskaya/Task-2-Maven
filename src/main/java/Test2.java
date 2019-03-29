import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Test2 {
    private static String filepath = "./src/main/resources/config2.xml";
    private static String word;
    private static String testString;
    static String punct = ",.;:?!";

    public static void main(String args[]) {
        try {
            File file = new File(filepath);
            readData(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        StringHelper.getCountWord(testString, word);
        StringHelper.gerCountPunctuation(testString, punct);
    }


    private static void readData(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Strings");

        Element strings = (Element) nList.item(0);
        word = strings.getElementsByTagName("Word").item(0).getTextContent();
        testString = strings.getElementsByTagName("String").item(0).getTextContent();
    }
}
