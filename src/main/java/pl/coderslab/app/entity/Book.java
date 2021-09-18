package pl.coderslab.app.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {


    @ManyToMany
    @NotEmpty
    private List<Author> authors = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;

    @ManyToOne
    @NotNull
    private Publisher publisher;
    @Min(1)
    int pages;



    public Book() {
    }

    public Book(Long id, String title, int rating,String description) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", rating=" + rating +
                ", description=" + description +
                '}';
    }



//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
