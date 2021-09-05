package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.PersonDao;
import pl.coderslab.app.dao.PersonDetailsDao;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.PersonDetails;

@Controller
@RequestMapping("/persons")
public class PersonController {


    private PersonDao personDao;
    private PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao){
        this.personDetailsDao = personDetailsDao;
        this.personDao = personDao;
    }

    @RequestMapping("/add")
    public void add(Person person){
        Person person1 = new Person();
        PersonDetails personDetails =
                new PersonDetails("Szymon","Stankowski", 12, "Lokietka", "poznan");
        personDetailsDao.save(personDetails);
        person1.setEmail("szymonstankowski@gmail.com");
        person1.setLogin("szymon");
        person1.setPassword("password");
        person1.setPersonDetails(personDetails);

        personDao.save(person1);

        System.out.println(person.toString());
    }

    @RequestMapping("/read/{id}")
    public String read(@PathVariable long id){
        Person person = personDao.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id){
        Person person = personDao.findById(id);
        person.setLogin("marek88");
        person.setEmail("marek@marek.com");
        person.setPassword("password");

        personDao.save(person);
        return person.toString();
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "deleted";
    }

    @GetMapping("/add")

    public String addForm(Model model){

        return "person-form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam("login") String login,
                      @RequestParam("password") String password,
                      @RequestParam("email") String email){
        Person person = new Person(null, null, login,password,email);

        personDao.save(person);
        return person.toString();
    }
}

