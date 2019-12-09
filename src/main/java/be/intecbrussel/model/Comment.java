package be.intecbrussel.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;
    @OneToOne
    private Author author;
    @OneToOne
    private BlogPost blogPost;

    private String text;

    public int getCommentID() {
        return commentID;
    }

    public Author getAuthor() {
        return author;
    }

    public Comment setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public Comment setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }
}
