package be.intecbrussel.data;

import be.intecbrussel.config.Config;
import be.intecbrussel.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDao {

    //create author
    public void createNewAuthor(Author author){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    //find author(read)
    public Author findAuthorById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        return em.find(Author.class,id);
    }
    //find author by username //TODO clean this up
    public Author findAuthorByUsername(String userName){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Author> query = em.createQuery("SELECT p from Author as p where p.userName = :user", Author.class);
        query.setParameter("user",userName);
        if(query.getResultList() == null){
            Author noAuthor = new Author();
            return noAuthor;
        }else {
            List<Author> authorList = query.getResultList();
            Author returnAuthor = new Author();
            for (Author author : authorList) {
                returnAuthor=author;
            }
            return returnAuthor;
        }
    }
    //find all authors
    public List<Author> findAllAuthors(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Author> query = em.createQuery("SELECT p from Author as p", Author.class);
        return query.getResultList();
    }

    //update author
    //delete author
    public void deleteAuthorById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Author author = em.find(Author.class,id);
        em.remove(author);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
