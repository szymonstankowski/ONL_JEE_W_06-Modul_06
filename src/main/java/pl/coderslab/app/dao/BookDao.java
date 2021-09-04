package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {



    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book){
        entityManager.persist(book);
    }

    public Book findById(long id){
        return entityManager.find(Book.class, id);
    }

    public void update(Book book){
        entityManager.merge(book);
    }

    public void delete(Book book){
        entityManager.remove(entityManager.contains(book)? book : entityManager.merge(book));
    }


}
