package ru.levogordnikov.fileconverter.xmltojson.json;

import lombok.NonNull;
import lombok.val;
import org.json.simple.JSONObject;
import ru.levogordnikov.fileconverter.model.Insect;
import ru.levogordnikov.fileconverter.settings.FileInsectSettings;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterJsonInsect {
    /**
     * записывает информацию в json файл
     *
     * @param fileName имя файла куда нужно записать данные
     * @param insects  список объектов, которые нужно записать в файл
     */
    public void writeJsonFileInsect(@NonNull final String fileName,
                                    @NonNull final ArrayList<Insect> insects)
            throws IOException {
        val obj = new JSONObject();
        for (Insect insect : insects) {
            val insectObj = new JSONObject();
            //В данном случае getTagOrNull возвращает значения ключей соответствующих
            //переданному номеру, так как ключи в json файле должны совпадать с тегами в xml
            //ошибки не будет
            insectObj.put(FileInsectSettings.tags.get(0), insect.getClassName());
            insectObj.put(FileInsectSettings.tags.get(1), insect.getOrderName());
            insectObj.put(FileInsectSettings.tags.get(2), insect.getFamilyName());
            insectObj.put(FileInsectSettings.tags.get(3), insect.getGenusName());
            obj.put(insect.getSpecies(), insectObj);
        }
        try (val file = new FileWriter(fileName)) {
            file.write(obj.toJSONString());
        } catch (IOException ioException) {
            throw ioException;
        }

    }
}
