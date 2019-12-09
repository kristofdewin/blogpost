package be.intecbrussel.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogID;
    @OneToOne
    private Author author;
    private String text;
    private LocalDateTime localDateTimePost;

    public BlogPost() {
        localDateTimePost = LocalDateTime.now();
    }

    public int getBlogID() {
        return blogID;
    }

    public BlogPost setBlogID(int blogID) {
        this.blogID = blogID;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public BlogPost setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getText() {
        return text;
    }

    public BlogPost setText(String text) {
        this.text = text;
        return this;
    }

    public LocalDateTime getLocalDateTimePost() {
        return localDateTimePost;
    }

    public BlogPost setLocalDateTimePost(LocalDateTime localDateTimePost) {
        this.localDateTimePost = localDateTimePost;
        return this;
    }
}
