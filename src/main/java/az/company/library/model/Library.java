package az.company.library.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Library {

    private Long r;
    private Long id;
    private Date dataDate;
    private Integer active;


}
