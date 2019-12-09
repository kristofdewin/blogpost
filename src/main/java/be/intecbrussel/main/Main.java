package be.intecbrussel.main;


import be.intecbrussel.data.CommentDao;
import be.intecbrussel.model.Comment;

public class Main {
    public static void main(String[] args) {
        Comment comment = new Comment();
        comment.setText("testing  alteration of existing comment");
        CommentDao commentDao = new CommentDao();

        commentDao.updateComment(comment,2);
    }
}
