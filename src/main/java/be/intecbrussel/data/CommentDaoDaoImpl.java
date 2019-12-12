package be.intecbrussel.data;

import be.intecbrussel.config.Config;
import be.intecbrussel.model.Comment;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CommentDaoDaoImpl implements CommentDaoInterface {

    //create Comment
    public void createNewComment(Comment newComment){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newComment);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    // read comment

    //find comment by id
    public Comment findCommentById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        return em.find(Comment.class,id);
    }

    //find list of  comments by authorId
    public List<Comment> findCommentByAuthorId(int authorId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query= em.createQuery("select p from Comment as p where p.author.authorId = :authorId",Comment.class);
        query.setParameter("authorId", authorId);
        return query.getResultList();
    }

    // find list of comments by blogpost ID

    public List<Comment> findCommentByBlogPostID(int blogpostID){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query= em.createQuery("select p from Comment as p where p.blogPost.blogID = :blogpostID",Comment.class);
        query.setParameter("blogpostID", blogpostID);
        return query.getResultList();

    }

    //find all comments
    public List<Comment> findAllComments(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query= em.createQuery("select p from Comment as p",Comment.class);
        return query.getResultList();
    }

    //update comment
    public void updateComment(Comment update, int toUpdateId){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.find(Comment.class,toUpdateId).setText(update.getText());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    //delete comment

    public Comment deleteComment(int commentId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comment commentToRemove = em.find(Comment.class, commentId);
        em.remove(commentToRemove);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return commentToRemove;
    }
}
