package be.intecbrussel.data;

import be.intecbrussel.config.Config;
import be.intecbrussel.model.BlogPost;

import javax.persistence.*;
import java.util.List;

public class BlogPostDaoImpl implements BlogPostDaoInterface {

    //create blogpost
    public void createNewBlogPost(BlogPost blogPost){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(blogPost);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    //find blogpost by blogId
    public BlogPost findBlogPostById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        return em.find(BlogPost.class,id);
    }

    //find blogpost by authorId
    public List<BlogPost> findBlogPostByAuthorId(int authorId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<BlogPost> query= em.createQuery("select p from BlogPost as p where p.id = :authorId",BlogPost.class);
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }
    // find all blogposts
    public List<BlogPost> findAllBlogPosts(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<BlogPost> query= em.createQuery("select p from BlogPost as p",BlogPost.class);
        return query.getResultList();
    }
    //update blogpost text
    public void updateComment(BlogPost update, int toUpdateId){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.find(BlogPost.class,toUpdateId).setText(update.getText());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    //delete BlogPost
    public void deleteBlogPost(int blogPostId){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        BlogPost blogPost = em.find(BlogPost.class,blogPostId);
        em.remove(blogPost);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
