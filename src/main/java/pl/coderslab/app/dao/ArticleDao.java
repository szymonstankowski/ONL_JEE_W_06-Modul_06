package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Article;
import pl.coderslab.app.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Article> findAll(){
        Query select_a_from_article_a = entityManager.createQuery("select a from Article a");
        return select_a_from_article_a.getResultList();
    }

    public List<Article> findFirst(int limit){

        return entityManager.createQuery("select a from Article a order by a.creationDate", Article.class
        ).setMaxResults(limit).getResultList();
    }
}
