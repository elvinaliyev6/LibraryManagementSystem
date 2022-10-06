package az.company.library.model;

import lombok.Data;

@Data
public class BookGenre extends Library {

    private Book book;
    private Genre genre;

}
