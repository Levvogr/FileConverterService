package ru.levogordnikov.fileconverter;

import lombok.extern.slf4j.Slf4j;
import ru.levogordnikov.fileconverter.jsontoxml.JsonToXmlInsect;
import ru.levogordnikov.fileconverter.xmltojson.XmlToJsonInsect;

@Slf4j
public class FileConverter {

    /**
     * В методе происходит валидация и вызов одного из методов, которые преобразуют файл
     *
     * @param inputFileName  Имя файла который будет преобразован
     * @param outputFileName Имя файла куда запишется преобразованный результат
     */
    public static void convert(final String inputFileName, final String outputFileName) {
        try {
            if (inputFileName.endsWith(".xml") && outputFileName.endsWith(".json")) {
                XmlToJsonInsect.convertXmlToJson(inputFileName, outputFileName);
            } else if (inputFileName.endsWith(".json") && outputFileName.endsWith(".xml")) {
                JsonToXmlInsect.convertJsonToXml(inputFileName, outputFileName);
            } else {
                log.error("Заданы неправильные типы файлов", new IllegalArgumentException());
            }
        } catch (NullPointerException nullPointerException) {
            log.error("Вместо имени файла был передан null", nullPointerException);
        }

    }
}
