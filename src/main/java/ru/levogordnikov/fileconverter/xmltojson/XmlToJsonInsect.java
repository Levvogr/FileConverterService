package ru.levogordnikov.fileconverter.xmltojson;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.xml.sax.SAXException;
import ru.levogordnikov.fileconverter.xmltojson.json.WriterJsonInsect;
import ru.levogordnikov.fileconverter.xmltojson.xml.ReaderXmlInsect;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Slf4j
public class XmlToJsonInsect {
    /**
     * Метод создан для удобства, то есть в методе main вместо написания одной
     * строчки достаточно просто вызвать этот метод
     *
     * @param fileNameXml  файл откуда будут считываться данные
     * @param fileNameJson файл куда будут записаны данные
     */
    public static void convertXmlToJson(final String fileNameXml, final String fileNameJson) {
        try {
            val insects = new ReaderXmlInsect().readXmlFileInsect(fileNameXml);
            try {
                new WriterJsonInsect().writeJsonFileInsect(fileNameJson, insects);
            } catch (IOException ioException) {
                log.error("Ошибка открытия " + fileNameJson + " файла", ioException);
                return;
            }
        } catch (ParserConfigurationException parserConfigurationException) {
            log.error("Этой ошибки не должно было произойти", parserConfigurationException);
            return;
        } catch (IOException ioException) {
            log.error("Ошибка открытия " + fileNameXml + " файла", ioException);
            return;
        } catch (SAXException saxException) {
            log.error("Этой ошибки не должно было произойти", saxException);
            return;
        } catch (NullPointerException nullPointerException) {
            log.error("Вместо имени файла был передан null", nullPointerException);
            return;
        }
        log.info("Преобразование прошло успешно");
    }
}
