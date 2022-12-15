package ru.levogordnikov.fileconverter.jsontoxml.json;

import lombok.NonNull;
import lombok.val;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.levogordnikov.fileconverter.model.Insect;
import ru.levogordnikov.fileconverter.settings.FileInsectSettings;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class ReaderJsonInsect {
    /**
     * Считывает информацию из файла, и возвращает её в виде списка объектов класса Insect
     *
     * @param fileName имя файла из которого считывается информация
     */
    public ArrayList<Insect> readJsonFileInsect(@NonNull final String fileName) throws IOException, ParseException {
        val insects = new ArrayList<Insect>();
        try (val reader = new FileReader(fileName)) {
            val jsonObject = (JSONObject) new JSONParser().parse(reader);
            for (String key : (Set<String>) jsonObject.keySet()) {
                val objectInsect = (JSONObject) jsonObject.get(key);
                //В данном случае getTagOrNull возвращает значения ключей соответствующих
                //переданному номеру, так как ключи в json файле совпадают с тегами в xml
                //ошибки не будет
                insects.add(new Insect(objectInsect.get(FileInsectSettings.tags.get(0)).toString(),
                        objectInsect.get(FileInsectSettings.tags.get(1)).toString(),
                        objectInsect.get(FileInsectSettings.tags.get(2)).toString(),
                        objectInsect.get(FileInsectSettings.tags.get(3)).toString(),
                        key));
            }
        } catch (IOException ioException) {
            throw ioException;
        } catch (ParseException parseException) {
            throw parseException;
        }
        return insects;

    }
}
