package pl.coderslab.app.entity;

import lombok.Data;
import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String creationDate = String.valueOf(LocalDate.now());
    private String title;
    @Column(length = 1000)
    private String content;

}
