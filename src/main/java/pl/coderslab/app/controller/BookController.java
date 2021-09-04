package pl.coderslab.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.dao.PublisherDao;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/books")
@Controller
//@RequiredArgsConstructor
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/addWithPublisherAuthors")
    @ResponseBody
    public String add() {

        List<Author> list = new ArrayList<>();
        Author winston = authorDao.findById(1);
        Author szymon = authorDao.findById(2);

        list.add(winston);
        list.add(szymon);



        Publisher publisher = new Publisher();

        publisher.setName("WSiP");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Forrest Gump");
        book.setDescription("ksiazka przygodowa");
        book.setRating(9);
        book.setPublisher(publisher);
        book.setAuthors(list);
        bookDao.save(book);
        return book.toString();

    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        book.setTitle("Gra o Tron");
        book.setDescription("Fantasy book");
        book.setRating(5);
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setDescription("Fantasy book");
        book.setRating(5);
        bookDao.save(book);
        return "Id dodanej książki to:"
                + book.getId();
    }


}
