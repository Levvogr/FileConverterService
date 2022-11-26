package xml_to_json.xml;


import model.Insect;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import settings.FileInsectSettings;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderXmlInsect {
    private ArrayList<Insect> insects=new ArrayList<>();
    public ArrayList<Insect> readXmlFileInsect(String fileName)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder=DocumentBuilderFactory
                .newDefaultInstance()
                .newDocumentBuilder();
        Document document=documentBuilder.parse(new File(fileName));
        Node root=document.getDocumentElement();
        Insect insect=new Insect();
        searchInTree(0, root, insect);
        return insects;
    }
    private void searchInTree(int indexTag,Node node,Insect insect){
        if(indexTag== FileInsectSettings.countTags-1){
            //выход из дерева, так как был пройден путь до его листа
            insect.setField(insect.getInsectFieldsNames().get(indexTag),
                    node.getChildNodes().item(0).getTextContent());
            insects.add(insect.copy());
            return;
        }
        //продолжение обхода дерева
        insect.setField(insect.getInsectFieldsNames().get(indexTag),
                node.getAttributes()
                        .getNamedItem("name")
                        .getNodeValue());
        indexTag++;
        NodeList nodeList=node.getChildNodes();
        for (int l = 0; l < nodeList.getLength(); l++) {
            Node newNode=nodeList.item(l);
            if(newNode.getNodeType() != Node.TEXT_NODE
                    && newNode.getNodeName().equals(FileInsectSettings.getTagOrNull(indexTag)))
                searchInTree(indexTag,newNode,insect);
        }
    }
}
