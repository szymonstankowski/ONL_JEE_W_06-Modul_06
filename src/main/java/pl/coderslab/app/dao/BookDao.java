package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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


    public List<Book> findAll(){
        Query select_b_from_book_b = entityManager.createQuery("SELECT b FROM Book b");
        return select_b_from_book_b.getResultList();
    }



    public List<Book> findByRating(int rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

//    public List<Book> findBooksWithPublisher(){
//        Query query = entityManager.createQuery("SELECT b FROM Book WHERE Publisher  null");
//        return query.getResultList();
//    }


}
