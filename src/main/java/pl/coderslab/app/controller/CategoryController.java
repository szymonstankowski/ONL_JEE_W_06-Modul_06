package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Category;

import java.util.List;
@RequestMapping
@Controller
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao){
        this.categoryDao=categoryDao;
    }

    @RequestMapping("categories")
    public String showAll(Model model){
        List<Category> list = categoryDao.findAll();
        model.addAttribute("categories",list);
        return "category-list";
    }
    @GetMapping("/addCategory")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        return "category-add-form";
    }
    @PostMapping("/addCategory")
    public String createCategory(Category category){
        categoryDao.save(category);
        return "redirect:/category";
    }

    @GetMapping("/updateCategory/{id}")
    public String update(@PathVariable long id, Model model){
        Category byId = categoryDao.findById(id);
        model.addAttribute(byId);
        return "category-update-form";
    }
    @PostMapping("/category/update/{id}")
    public String update1(@PathVariable long id, Category category){
        Category categoryDaoById = categoryDao.findById(id);
        categoryDaoById.setName(category.getName());
        categoryDao.update(categoryDaoById);
        return "redirect:/category";
    }

    @RequestMapping("/deleteCategory/{id}")
    public String delete(@PathVariable long id){
        Category byId = categoryDao.findById(id);
        categoryDao.delete(byId);
        return "redirect:/category";
    }



}
