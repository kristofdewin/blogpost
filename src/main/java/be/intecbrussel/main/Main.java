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

        String username = "jayjay2";

        AuthorDaoInterface authordao = new AuthorDaoImpl();

        Author author = authordao.findAuthorByUsername(username);
       System.out.println(author.toString());

        int id = author.getAuthorId();

        Author updatedAuthor = authordao.findAuthorById(id);
        updatedAuthor
                .setUserName("jayjay4")
                .setEmail("updated@mail.com");

        System.out.println(updatedAuthor.toString());

        authordao.deleteAuthorById(id);

        authordao.createNewAuthor(updatedAuthor);

        System.out.println("where are you " + author.toString());
        System.out.println("updated author :" + updatedAuthor.toString());



    }
}
