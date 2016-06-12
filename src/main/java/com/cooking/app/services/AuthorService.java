package com.cooking.app.services;

import java.util.List;
import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.Author;

public interface AuthorService {

    List<Author> getAuthors();

    void deleteAuthor(String authorId);

    void saveAuthor(Author author) throws DuplicateEntityException;

    Author getAuthorByName(String name);
}
