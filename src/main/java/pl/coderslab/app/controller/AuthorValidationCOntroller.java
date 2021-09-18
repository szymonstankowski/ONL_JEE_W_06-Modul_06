package pl.coderslab.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Author;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validateAuthor")
@RequiredArgsConstructor
public class AuthorValidationCOntroller {

    private final Validator validator;

    @GetMapping
    @ResponseBody
    public String validateBook(){
        Author author = new Author();

        Set<ConstraintViolation<Author>> constraintViolations = validator.validate(author);

        StringBuilder sb = new StringBuilder();

        for (ConstraintViolation violation : constraintViolations) {
            sb.append(violation.getPropertyPath());
            sb.append(" : ");
            sb.append(violation.getMessage());
            sb.append("<br/>");
        }
        return sb.toString();
    }
}
