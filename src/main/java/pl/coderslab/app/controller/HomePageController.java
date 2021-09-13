package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.entity.Article;

import java.util.List;

@Controller
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao){
        this.articleDao=articleDao;
    }

    @RequestMapping("/home")
    public String home(Model model){
        List<Article> list = articleDao.findAll();
        model.addAttribute("articles", list);
        return "article-list";
    }
    @GetMapping("/home/limit")
    public String showArticles(@RequestParam int limit, Model model){
        List<Article> list = articleDao.findFirst(limit);
        model.addAttribute("limitArticles", list);
        return "article-limited-list";
    }




}
