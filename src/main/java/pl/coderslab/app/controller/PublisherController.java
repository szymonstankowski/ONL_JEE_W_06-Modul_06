package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.dao.PublisherDao;

import java.util.List;
@RequestMapping
@Controller
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publishers")
    public String showPublishers(Model model){
        List<Publisher> list = publisherDao.findAll();
        model.addAttribute("publishers", list);
        return "publishers-list";
    }

    @GetMapping("/editPublisher/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisher-edit-form";
    }

    @PostMapping("editPublisher/{id}")
    public String updatePublisher(@PathVariable long id, Publisher publisher){
        Publisher publisher1 = publisherDao.findById(id);
        publisher1.setName(publisher.getName());
        publisherDao.update(publisher1);
        return "redirect:/publishers";
    }

    @GetMapping("/addPublisher")
    public String addNewPublisherForm(Model model) {
        model.addAttribute("publisher",new Publisher());
        return "publisher-add-form";
    }

    @PostMapping("/addPublisher")
    public String createPublishers(Publisher publisher){
        publisherDao.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/deletePublisher/{id}")
    public String confirmPublisherDelete(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);

        return "publisher-confirm";
    }

    @PostMapping
    public String deletePublisher(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/publishers";
    }
}
