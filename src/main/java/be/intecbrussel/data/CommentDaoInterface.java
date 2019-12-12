package be.intecbrussel.data;

import be.intecbrussel.model.Comment;

import java.util.List;

public interface CommentDaoInterface {
    public void createNewComment(Comment newComment);
    public Comment findCommentById(int id);
    public List<Comment> findCommentByAuthorId(int authorId);
    public List<Comment> findCommentByBlogPostID(int blogpostID);
    public List<Comment> findAllComments();
    public void updateComment(Comment update, int toUpdateId);
    public Comment deleteComment(int commentId);
}
