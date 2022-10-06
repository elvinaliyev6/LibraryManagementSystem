package az.company.library.model;

import lombok.Data;

@Data
public class Book extends Library{

    private String name;
    private Double price;
    private String description;

}
