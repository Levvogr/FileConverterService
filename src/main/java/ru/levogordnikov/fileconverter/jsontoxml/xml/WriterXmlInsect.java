package ru.levogordnikov.fileconverter.jsontoxml.xml;

import lombok.NonNull;
import lombok.val;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.levogordnikov.fileconverter.model.Insect;
import ru.levogordnikov.fileconverter.settings.FileInsectSettings;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
     *
     * @param fileName имя файла куда нужно записать данные
     * @param insects  список объектов, которые нужно записать в файл
     */
    public void writeXmlFileInsect(@NonNull final String fileName,
                                   @NonNull final ArrayList<Insect> insects)
            throws ParserConfigurationException, IOException, TransformerException {
        final Document doc;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException parserConfigurationException) {
            throw parserConfigurationException;
        }
        //rootElement присваивается начальный тег в данном случае - это class
        val rootElement = doc.createElement(FileInsectSettings.tags.get(0));
        rootElement.setAttribute("name", "Insect");
        //подготовка данных в виде дерева для создания xml файла
        createAndAppendChildElements(rootElement, doc, insects, 1);
        doc.appendChild(rootElement);
        try (val output = new FileOutputStream(fileName)) {
            TransformerFactory.newInstance()
                    .newTransformer()
                    .transform(new DOMSource(doc), new StreamResult(output));
        } catch (IOException ioException) {
            throw ioException;
        } catch (TransformerException transformerException) {
            throw transformerException;
        }
    }

    /**
     * Метод формирует дерево для записи его в xml файл
     *
     * @param element  узел дерева для которого будут создаваться дочерние элементы
     * @param document необходим для создания элементов
     * @param insects  список откуда берут данные для добавления в дерево
     * @param index    номер тега или то насколько добавляемые элементы удалены от корня дерева
     */
    private void createAndAppendChildElements(@NonNull final Element element,
                                              @NonNull final Document document,
                                              @NonNull final ArrayList<Insect> insects,
                                              @NonNull final int index) {
        if (index == FileInsectSettings.countTags - 1) {
            //Достигнут последний тег, следовательно, все дочерние элементы будут
            //листами и нужно выйти из дерева
            for (Insect insect : insects)
                if (element.getAttribute("name")
                        .equals(insect.getValueInField(Insect.insectFieldsNames.get(index - 1)))) {
                    Element newElement = document.createElement(FileInsectSettings.tags.get(index));
                    newElement.setTextContent(insect.getValueInField(Insect.insectFieldsNames.get(index)));
                    element.appendChild(newElement);
                }
            return;
        }
        //В классе Insect из-за особенностей файла уникальным будет только поле species, но в xml файл достаточно
        //записать их только один раз, поэтому используется HashSet
        HashSet<String> uniqueValues = new HashSet<>();
        for (Insect insect : insects)
            if (element.getAttribute("name")
                    .equals(insect.getValueInField(Insect.insectFieldsNames.get(index - 1))))
                uniqueValues.add(insect.getValueInField(Insect.insectFieldsNames.get(index)));
        for (String value : uniqueValues) {
            Element newElement = document.createElement(FileInsectSettings.tags.get(index));
            newElement.setAttribute("name", value);
            createAndAppendChildElements(newElement, document, insects, index + 1);
            element.appendChild(newElement);
        }
    }
}
