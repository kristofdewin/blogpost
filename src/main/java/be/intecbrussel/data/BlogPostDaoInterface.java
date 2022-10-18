package be.intecbrussel.data;

import be.intecbrussel.model.BlogPost;

import java.util.List;

public interface BlogPostDaoInterface {
    public void createNewBlogPost(BlogPost blogPost);
    public BlogPost findBlogPostById(int id);
    public List<BlogPost> findBlogPostByAuthorId(int authorId);
    public List<BlogPost> findAllBlogPosts();
    public void updateComment(BlogPost update, int toUpdateId);
    public void deleteBlogPost(int blogPostId);
}
