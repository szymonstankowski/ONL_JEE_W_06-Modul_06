package pl.coderslab.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.dao.PublisherDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @RequestMapping("/editBooks")
    public String findAllBooks(Model model) {
        List<Book> list = bookDao.findAll();
        model.addAttribute("allBooks",list);
        return "book-list-form";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "book-edit";
    }


    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, Book book){
        Book bookToUpdate = bookDao.findById(id);
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setRating(book.getRating());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        bookDao.update(bookToUpdate);
        return "redirect:/books/editBooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "confirm";
    }
    @PostMapping("/delete/{id}")
    public String confirmDelete(@PathVariable long id){
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:books/editBooks";

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

    @RequestMapping
    @ResponseBody
    public String findAll() {
        List<Book> list = bookDao.findAll();

        return list.stream()
                .map(Book::toString)
                .collect(Collectors.joining("<br>"));
    }

    @RequestMapping("/rating/{rating}")
    @ResponseBody
    public String getBooksByRating(@PathVariable int rating) {
        List<Book> list = bookDao.findByRating(rating);
        return list.stream()
                .map(Book::toString)
                .collect(Collectors.joining(" ||| "));
    }

    @RequestMapping("/byPublisher")
    @ResponseBody
    public String getBooksWithPublisher() {
        List<Book> booksWithPublisher = bookDao.findBooksWithPublisher();
        return booksWithPublisher.stream()
                .map(Book::toString)
                .collect(Collectors.joining(" ||| "));
    }

    @RequestMapping("/publisher/{name}")
    @ResponseBody
    public String getBooksWithSpecificPublisher(@PathVariable String name) {
        List<Book> bySpecificPublisher = bookDao.findBySpecificPublisher(name);
        return bySpecificPublisher.stream()
                .map(Book::toString)
                .collect(Collectors.joining(" ||| "));
    }

    @RequestMapping("/authors/{name}")
    @ResponseBody
    public String getBooksOfAnAuthor(@PathVariable String name){
        List<Book> bookWithAnAuthor = bookDao.findBookWithAnAuthor(name);

        return bookWithAnAuthor.stream()
                .map(Book::toString)
                .collect(Collectors.joining(" ||| "));
    }

    @GetMapping("/add")
    public String createForm(Model model){
        model.addAttribute("book", new Book());
        return "book-form";
    }
    @PostMapping("/add")
    public String create(Book book){
        bookDao.save(book);
        return "redirect/books";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers(){
        return publisherDao.findAll();
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

}
