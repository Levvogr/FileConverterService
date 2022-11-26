package main;

import org.json.simple.parser.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName=sc.nextLine().replace("\\","/");
        System.out.print("Output file: ");
        String outputFileName=sc.nextLine().replace("\\","/");
        if(inputFileName.charAt(inputFileName.lastIndexOf('.')+1)=='x')
            xml_to_json.XmlToJsonInsect.convertXmlToJson(inputFileName,outputFileName);
        else
            json_to_xml.JsonToXmlInsect.convertJsonToXml(inputFileName,outputFileName);
    }
}