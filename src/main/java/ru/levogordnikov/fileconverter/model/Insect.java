package ru.levogordnikov.fileconverter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;


/**
 * Класс описывает данные, которые считываются и записываются в файлы
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Insect {
    /**
     * insectFieldsNames нужен для удобного использования методов
     * getValueInField и setField, которые нужны для удобного взаимодействия
     * со структурой дерево(для xml файлов). Конкретно при реализации обхода в глубину
     * то насколько удалён текущий узел от корневого будет показателем
     * какому полю этот узел принадлежит. Так если удалённость
     * от корневого узла = 0, то поле className, если = 1, то orderName,
     * если = 2, то familyName, если = 3, то genusName, если = 4, то species
     */

    public static final List<String> insectFieldsNames = Arrays
            .asList("className", "orderName", "familyName", "genusName", "species");
    @NonNull
    private String className;
    @NonNull
    private String orderName;
    @NonNull
    private String familyName;
    @NonNull
    private String genusName;
    @NonNull
    private String species;

    /**
     * @param field название поля класса Insect
     * @return значение поля field, если field задано неверно вернёт null
     */
    public String getValueInField(String field) {
        switch (field) {
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
     * @param field название поля класса Insect
     * @param value значение, которое будет присвоено полю field,
     *              если field задано неверно ничего не произойдёт
     */
    public void setField(String field, String value) {
        switch (field) {
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

    public Insect copy() {
        return new Insect(className,
                orderName,
                familyName,
                genusName,
                species);
    }
}
