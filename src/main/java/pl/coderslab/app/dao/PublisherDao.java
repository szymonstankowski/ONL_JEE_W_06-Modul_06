package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher){
        entityManager.persist(publisher);
    }

    public Publisher findById(long id){
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }
    public void delete(Publisher publisher){
        entityManager.remove(entityManager.contains(publisher)? publisher : entityManager.merge(publisher));
    }

    public List<Publisher> findAll(){
        Query select_b_from_book_b = entityManager.createQuery("SELECT p FROM Publisher p");
        return select_b_from_book_b.getResultList();
    }
}
