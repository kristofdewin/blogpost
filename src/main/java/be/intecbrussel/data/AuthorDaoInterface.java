package be.intecbrussel.data;

import be.intecbrussel.model.Author;

import java.util.List;

public interface AuthorDaoInterface {
    public void createNewAuthor(Author author);
    public Author findAuthorById(int id);
    public Author findAuthorByUsername(String userName);
    public List<Author> findAllAuthors();
    public void updateAuthor(Author author);
    public void deleteAuthorById(int id);
}
