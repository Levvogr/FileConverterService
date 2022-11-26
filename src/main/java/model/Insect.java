package model;

import java.util.ArrayList;

public class Insect {
    private String className;
    private String orderName;
    private String familyName;
    private String genusName;
    private String species;
    private ArrayList<String> insectFieldsNames=new ArrayList<String>();

    public Insect(String className, String orderName, String familyName, String genusName, String species) {
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.genusName = genusName;
        this.species = species;
        initInsectFieldsNames();
    }
    public Insect() {
        initInsectFieldsNames();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public ArrayList<String> getInsectFieldsNames() {
        return insectFieldsNames;
    }

    private void initInsectFieldsNames() {
        insectFieldsNames.add("className");
        insectFieldsNames.add("orderName");
        insectFieldsNames.add("familyName");
        insectFieldsNames.add("genusName");
        insectFieldsNames.add("species");
    }
    public String getValueInField(String field){
        switch (field){
            case "className":
                return getClassName();
            case "orderName":
                return getOrderName();
            case "familyName":
                return getFamilyName();
            case "genusName":
                return getGenusName();
            case "species":
                return getSpecies();
            default:
                return null;
        }
    }
    public void setField(String field, String value){
        switch (field){
            case "className":
                setClassName(value);
                break;
            case "orderName":
                setOrderName(value);
                break;
            case "familyName":
                setFamilyName(value);
                break;
            case "genusName":
                setGenusName(value);
                break;
            case "species":
                setSpecies(value);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Insect{" +
                "className='" + className + '\'' +
                ", orderName='" + orderName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", genusName='" + genusName + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
    public Insect copy(){
        return new Insect(className,
                orderName,
                familyName,
                genusName,
                species);
    }
}
