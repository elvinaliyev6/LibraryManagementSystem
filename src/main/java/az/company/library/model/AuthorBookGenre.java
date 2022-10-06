package az.company.library.model;

import lombok.Data;

@Data
public class AuthorBookGenre extends Library{

    private Author author;
    private BookGenre bookGenre;

}
