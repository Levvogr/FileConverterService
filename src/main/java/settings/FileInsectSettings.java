package settings;

public class FileInsectSettings {
    /**
     * Количество разных тегов в xml файле.
     */
    public static int countTags=5;

    /**
     * метод подходит и для xml и для json, так как теги в xml совпадают с
     * ключами в json, кроме species
     * @param index индекс тега
     * @return вернёт название тега с заданным индексом индексу,
     * если индекс задан неверный вернёт null
     */
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
