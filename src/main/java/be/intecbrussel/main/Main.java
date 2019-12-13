package be.intecbrussel.main;


import be.intecbrussel.config.Config;
import be.intecbrussel.data.AuthorDaoImpl;
import be.intecbrussel.data.AuthorDaoInterface;
import be.intecbrussel.data.CommentDaoDaoImpl;
import be.intecbrussel.data.CommentDaoInterface;
import be.intecbrussel.model.Author;
import be.intecbrussel.model.Comment;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setText("testing  alteration of existing comment");
        CommentDaoInterface commentDao = new CommentDaoDaoImpl();

        commentDao.updateComment(comment,2);


    }
}
