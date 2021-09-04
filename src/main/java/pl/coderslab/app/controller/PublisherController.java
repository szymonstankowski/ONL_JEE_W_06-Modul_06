package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.dao.PublisherDao;

@Controller
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao){
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Szymon");
        publisherDao.save(publisher);
        return "Id dodanego publishera to: "+publisher.getId();
    }

    @RequestMapping("/publisher/update/{id}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id){
        Publisher publisher = new Publisher();
        publisher.setName("Marek");
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
}
