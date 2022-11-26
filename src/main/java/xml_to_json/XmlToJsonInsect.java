package xml_to_json;

import model.Insect;
import org.xml.sax.SAXException;
import xml_to_json.json.WriterJsonInsect;
import xml_to_json.xml.ReaderXmlInsect;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlToJsonInsect {
    public static void convertXmlToJson(String fileNameXml, String fileNameJson)
            throws ParserConfigurationException, IOException, SAXException {
        ReaderXmlInsect r=new ReaderXmlInsect();
        ArrayList<Insect> insects = r.readXmlFileInsect(fileNameXml);
        WriterJsonInsect w=new WriterJsonInsect();
        w.writeJsonFileInsect(fileNameJson,insects);
    }
}
