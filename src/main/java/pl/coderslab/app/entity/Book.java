package pl.coderslab.app.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {

    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;



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
