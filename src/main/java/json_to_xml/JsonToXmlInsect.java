package json_to_xml;

import json_to_xml.json.ReaderJsonInsect;
import json_to_xml.xml.WriterXmlInsect;
import model.Insect;
import org.json.simple.parser.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
public class JsonToXmlInsect {
    public static void convertJsonToXml(String fileNameJson, String fileNameXml)
            throws IOException, ParseException, ParserConfigurationException, TransformerException {
        ReaderJsonInsect r=new ReaderJsonInsect();
        ArrayList<Insect> insects=r.readJsonFileInsect(fileNameJson);
        WriterXmlInsect w=new WriterXmlInsect();
        w.writeXmlFileInsect(fileNameXml,insects);
    }
}
