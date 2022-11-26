package xml_to_json.json;

import model.Insect;
import org.json.simple.JSONObject;
import settings.FileInsectSettings;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterJsonInsect {
    public void writeJsonFileInsect(String fileName, ArrayList<Insect> insects) throws IOException {
        JSONObject obj = new JSONObject();
        for (Insect insect:insects) {
            JSONObject insectObj = new JSONObject();
            insectObj.put(FileInsectSettings.getTagOrNull(0),insect.getClassName());
            insectObj.put(FileInsectSettings.getTagOrNull(1),insect.getOrderName());
            insectObj.put(FileInsectSettings.getTagOrNull(2),insect.getFamilyName());
            insectObj.put(FileInsectSettings.getTagOrNull(3),insect.getGenusName());
            obj.put(insect.getSpecies(),insectObj);
        }
        FileWriter file = new FileWriter(fileName);
        file.write(obj.toJSONString());
        file.close();
    }
}
