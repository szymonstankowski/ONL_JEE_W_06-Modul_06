package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll(){
        Query select_c_from_category_c = entityManager.createQuery("select c from Category c");
        return select_c_from_category_c.getResultList();
    }

    public void save(Category category){
        entityManager.persist(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category)? category : entityManager.merge(category));
    }
    public void update(Category category){
        entityManager.merge(category);
    }
    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }



}
