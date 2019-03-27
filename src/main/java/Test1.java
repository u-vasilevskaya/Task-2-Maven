import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Test1 {

    private static String filepath = "./src/main/resources/config1.xml";
    private static String firstString;
    private static String secondString;

    public static void main(String args[]) {
        try {
            File file = new File(filepath);
            readData(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] str1Words = StringHelper.getWordsArray(firstString);
        String[] str2Words = StringHelper.getWordsArray(secondString);
        StringHelper.writeUniqueWords(str1Words, str2Words);
    }

    //работа с xml
    private static void readData(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Strings");
        Element strings = (Element) nList.item(0);
        firstString = strings.getElementsByTagName("FirstString").item(0).getTextContent();
        secondString = strings.getElementsByTagName("SecondString").item(0).getTextContent();
    }




}