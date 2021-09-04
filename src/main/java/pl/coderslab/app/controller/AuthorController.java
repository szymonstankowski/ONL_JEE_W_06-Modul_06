package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.dao.AuthorDao;


@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    public AuthorController(AuthorDao authorDao){
        this.authorDao=authorDao;
    }


    @RequestMapping("/author/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Thinking in Java");
        author.setLastName("Fantasy book");
        authorDao.save(author);
        return "Id dodanej książki to:"
                + author.getId();
    }

    @RequestMapping("/author/update/{firstName}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable String firstName, @PathVariable String lastName ) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }




}
