package pl.coderslab.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authors")
@Data
public class Author {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

//    public void delete(Author author) {
//    }
}
