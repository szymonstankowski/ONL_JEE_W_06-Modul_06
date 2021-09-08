package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String s){

        return authorDao.findById(Long.parseLong(s));
    }


}
