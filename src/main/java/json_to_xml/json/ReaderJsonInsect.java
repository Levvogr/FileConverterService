package json_to_xml.json;

import model.Insect;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import settings.FileInsectSettings;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Set;

    public class ReaderJsonInsect {
        /**
         * Считывает информацию из файла, и возвращает её в виде списка объектов класса Insect
         * @param fileName имя файла из которого считывается информация
         */
        public ArrayList<Insect> readJsonFileInsect(String fileName) throws IOException, ParseException {
            ArrayList<Insect> insects=new ArrayList<>();
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject)parser.parse(reader);
            Set<String> species=jsonObject.keySet();
            for (String key:species) {
                JSONObject objectInsect=(JSONObject)jsonObject.get(key);
                //В данном случае getTagOrNull возвращает значения ключей соответствующих
                //переданному номеру, так как ключи в json файле совпадают с тегами в xml
                //ошибки не будет
                insects.add(new Insect(objectInsect.get(FileInsectSettings.getTagOrNull(0)).toString(),
                        objectInsect.get(FileInsectSettings.getTagOrNull(1)).toString(),
                        objectInsect.get(FileInsectSettings.getTagOrNull(2)).toString(),
                        objectInsect.get(FileInsectSettings.getTagOrNull(3)).toString(),
                        key));
            }
            reader.close();
            return insects;

        }
    }
