package xml_to_json;

import model.Insect;
import org.xml.sax.SAXException;
import xml_to_json.json.WriterJsonInsect;
import xml_to_json.xml.ReaderXmlInsect;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlToJsonInsect {
    /**
     * Метод создан для удобства, то есть в методе main вместо написания одной
     * строчки достаточно просто вызвать этот метод
     * @param fileNameXml файл откуда будут считываться данные
     * @param fileNameJson  файл куда будут записаны данные
     */
    public static void convertXmlToJson(String fileNameXml, String fileNameJson)
            throws ParserConfigurationException, IOException, SAXException {
        ReaderXmlInsect r=new ReaderXmlInsect();
        ArrayList<Insect> insects = r.readXmlFileInsect(fileNameXml);
        WriterJsonInsect w=new WriterJsonInsect();
        w.writeJsonFileInsect(fileNameJson,insects);
    }
}
