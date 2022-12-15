package main;

import ru.levogordnikov.fileconverter.FileConverter;

import java.util.Scanner;

public class Main {
    /**
     * Преобразует данные из xml файла в json или наоборот
     * xml файл представляет собой иерархическую структура
     * из биологии начиная с класса заканчивая видом, но
     * только для класса насекомых. То есть по порядку класс,
     * отряд, семейство, род, вид. См пример ins.xml
     * <p>
     * Json файл представляет набор названий видов и куда они
     * входят, то есть их класс, отряд, семейство, род, вид.
     * См пример ins.json
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Преобразуемый файл: ");
        String inputFileName = scanner.nextLine().replace("\\", "/");
        System.out.print("Новый файл, куда запишутся данные: ");
        String outputFileName = scanner.nextLine().replace("\\", "/");
        FileConverter.convert(inputFileName, outputFileName);
    }
}