package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Book;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    public AuthorController(AuthorDao authorDao){
        this.authorDao=authorDao;
    }
    @RequestMapping("/authors")
    public String findAll(Model model) {
        List<Author> list = authorDao.findAll();
        model.addAttribute("authors", list);
        return "author-list";
    }

    @GetMapping("/addAuthor")
    public String addNewBook(Model model){
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @PostMapping("/addAuthor")
    public String create(@Valid Author author, BindingResult result){
        if (result.hasErrors()){
            return "author-form";
        }
        authorDao.save(author);
        return "redirect:/authors";
    }
    
    @GetMapping("/editAuthor/{id}")
    public String editAuthorForm(@PathVariable long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author",author);
        return "author-edit-form";
    }

    @PostMapping("/editAuthor/{id}")
    public String updateAuthor(@PathVariable long id, Author author){
        Author authorToUpdate = authorDao.findById(id);
        authorToUpdate.setFirstName(author.getFirstName());
        authorToUpdate.setLastName(author.getLastName());
        authorDao.update(authorToUpdate);
        return "redirect:/authors";
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/deleteAuthor/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/authors";
    }

}
