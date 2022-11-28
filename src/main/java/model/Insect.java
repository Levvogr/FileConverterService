package model;

import java.util.ArrayList;


/**
 * Класс описывает данные, которые считываются и записываются в файлы
 */
public class Insect {
    private String className;
    private String orderName;
    private String familyName;
    private String genusName;
    private String species;
    /**
     * insectFieldsNames нужен для удобного использования методов
     * getValueInField и setField, которые нужны для удобного взаимодействия
     * со структурой дерево(для xml файлов). Конкретно при реализации обхода в глубину
     * то насколько удалён текущий узел от корневого будет показателем
     * какому полю этот узел принадлежит. Так если удалённость
     * от корневого узла = 0, то поле className, если = 1, то orderName,
     * если = 2, то familyName, если = 3, то genusName, если = 4, то species
     */

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

    /**
     *
     * @param field название поля класса Insect
     * @return значение поля field, если field задано неверно вернёт null
     */
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

    /**
     *
     * @param field название поля класса Insect
     * @param value значение, которое будет присвоено полю field,
     *             если field задано неверно ничего не произойдёт
     */
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
