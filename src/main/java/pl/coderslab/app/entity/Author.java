package pl.coderslab.app.entity;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authors")
@Data
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @PESEL
    private String pesel;
    @Email
    @NotBlank
    private String email;

//    public void delete(Author author) {
//    }
}
