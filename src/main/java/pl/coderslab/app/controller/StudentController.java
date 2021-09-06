package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Person;
import pl.coderslab.app.entity.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Python", "Ruby", "C++", "JavaScript", "C#");
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("JAVA", "Python", "Ruby", "C++", "C#");
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("student", new Student());

        return "student-form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String print(Student student){

        return student.toString();
    }
    
}
