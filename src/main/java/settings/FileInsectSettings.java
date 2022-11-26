package settings;

public class FileInsectSettings {
    public static int countTags=5;
    public static String getTagOrNull(int index){
        switch (index){
            case 0: return "class";
            case 1: return "order";
            case 2: return "family";
            case 3: return "genus";
            case 4: return "species";
            default: return null;
        }
    }
}
