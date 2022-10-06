package az.company.library.model;

import lombok.Data;

import java.util.Date;

@Data
public class Author extends Library{

    private String name;
    private String surname;
    private Date dob;



}
