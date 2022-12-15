package ru.levogordnikov.fileconverter.jsontoxml;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.json.simple.parser.ParseException;
import ru.levogordnikov.fileconverter.jsontoxml.json.ReaderJsonInsect;
import ru.levogordnikov.fileconverter.jsontoxml.xml.WriterXmlInsect;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Slf4j
public class JsonToXmlInsect {
    /**
     * Метод создан для удобства, то есть в методе main вместо написания одной
     * строчки достаточно просто вызвать этот метод
     *
     * @param fileNameJson файл откуда будут считываться данные
     * @param fileNameXml  файл куда будут записаны данные
     */
    public static void convertJsonToXml(final String fileNameJson, final String fileNameXml) {
        try {
            val insects = new ReaderJsonInsect().readJsonFileInsect(fileNameJson);
            try {
                new WriterXmlInsect().writeXmlFileInsect(fileNameXml, insects);
            } catch (IOException ioException) {
                log.error("Ошибка открытия " + fileNameXml + " файла", ioException);
                return;
            } catch (TransformerException transformerException) {
                log.error("Этой ошибки не должно было произойти", transformerException);
                return;
            }
        } catch (ParserConfigurationException parserConfigurationException) {
            log.error("Этой ошибки не должно было произойти", parserConfigurationException);
            return;
        } catch (IOException ioException) {
            log.error("Ошибка открытия " + fileNameJson + " файла", ioException);
            return;
        } catch (ParseException parseException) {
            log.error("Этой ошибки не должно было произойти", parseException);
            return;
        } catch (NullPointerException nullPointerException) {
            log.error("Вместо имени файла был передан null", nullPointerException);
            return;
        }
        log.info("Преобразование прошло успешно");
    }
}
