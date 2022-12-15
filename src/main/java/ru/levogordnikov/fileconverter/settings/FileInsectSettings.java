package ru.levogordnikov.fileconverter.settings;

import java.util.Map;

public class FileInsectSettings {
    /**
     * Количество разных тегов в xml файле.
     */
    public static int countTags = 5;
    /**
     * теги файлов
     */
    public static Map<Integer, String> tags = Map.of(
            0, "class",
            1, "order",
            2, "family",
            3, "genus",
            4, "species"
    );
}
