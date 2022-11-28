package json_to_xml.xml;

import model.Insect;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import settings.FileInsectSettings;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class WriterXmlInsect {
    /**
     * записывает информацию в xml файл
     * @param fileName имя файла куда нужно записать данные
     * @param insects список объектов, которые нужно записать в файл
     */
    public void writeXmlFileInsect(String fileName, ArrayList<Insect> insects)
            throws ParserConfigurationException, IOException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        //rootElement присваивается начальный тег в данном случае - это class
        Element rootElement = doc.createElement(FileInsectSettings.getTagOrNull(0));
        rootElement.setAttribute("name","Insect");
        //подготовка данных в виде дерева для создания xml файла
        createAndAppendChildElements(rootElement,doc,insects,1);
        doc.appendChild(rootElement);
        //создание xml файла
        FileOutputStream output = new FileOutputStream(fileName);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
        output.close();
    }

    /**
     * Метод формирует дерево для записи его в xml файл
     * @param element узел дерева для которого будут создаваться дочерние элементы
     * @param document необходим для создания элементов
     * @param insects список откуда берут данные для добавления в дерево
     * @param index номер тега или то насколько добавляемые элементы удалены от корня дерева
     */
    private void createAndAppendChildElements(Element element,
                                              Document document,ArrayList<Insect> insects, int index){
        if(index==FileInsectSettings.countTags-1){
            //Достигнут последний тег, следовательно, все дочерние элементы будут
            //листами и нужно выйти из дерева
            for (Insect insect:insects)
                if(element.getAttribute("name")
                        .equals(insect.getValueInField(insect.getInsectFieldsNames().get(index-1)))){
                    Element newElement=document.createElement(FileInsectSettings.getTagOrNull(index));
                    newElement.setTextContent(insect.getValueInField(insect.getInsectFieldsNames().get(index)));
                    element.appendChild(newElement);
                }
            return;
        }
        //В классе Insect из-за особенностей файла уникальным будет только поле species, но в xml файл достаточно
        //записать их только один раз, поэтому используется HashSet
        HashSet<String> uniqueValues=new HashSet<>();
        for (Insect insect:insects)
            if(element.getAttribute("name")
                    .equals(insect.getValueInField(insect.getInsectFieldsNames().get(index-1))))
                uniqueValues.add(insect.getValueInField(insect.getInsectFieldsNames().get(index)));
        for (String value:uniqueValues) {
            Element newElement=document.createElement(FileInsectSettings.getTagOrNull(index));
            newElement.setAttribute("name",value);
            createAndAppendChildElements(newElement,document,insects,index+1);
            element.appendChild(newElement);
        }
    }
}
