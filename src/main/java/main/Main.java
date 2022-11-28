package main;

import java.util.Scanner;

public class Main {
    /**
     * Преобразует данные из xml файла в json или наоборот
     * xml файл представляет собой иерархическую структура
     * из биологии начиная с класса заканчивая видом, но
     * только для класса насекомых. То есть по порядку класс,
     * отряд, семейство, род, вид. Смотри пример ins.xml
     *
     * json файл представляет набор названий видов и куда они
     * входят, то есть их класс, отряд, семейство, род, вид.
     * Смотри пример ins.json
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName=sc.nextLine().replace("\\","/");
        System.out.print("Output file: ");
        String outputFileName=sc.nextLine().replace("\\","/");
        try {
            if(inputFileName.endsWith(".xml")&&outputFileName.endsWith(".json"))
                xml_to_json.XmlToJsonInsect.convertXmlToJson(inputFileName,outputFileName);
            else if(inputFileName.endsWith(".json")&&outputFileName.endsWith(".xml"))
                json_to_xml.JsonToXmlInsect.convertJsonToXml(inputFileName,outputFileName);
            else
                System.out.println("Error: incorrect filenames");
        }catch (Exception e){
            System.out.println("Error: incorrect data in files");
        }

    }
}