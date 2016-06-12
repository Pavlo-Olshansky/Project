package com.cooking.app.services;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cooking.app.controller.DuplicateEntityException;
import com.cooking.app.data.Author;


@Service
public class DynamicAuthorService implements AuthorService {

    private final Map<String, Author> authorsMap = new LinkedHashMap<>();

    @PostConstruct
    public void init() {
        putAuthor(new Author("Андрій", "Дгіпро", "андрій123"));
        putAuthor(new Author("Паша", "Львів", "паша123"));
    }

    private void putAuthor(Author author) {
        authorsMap.put(author.getName(), author);
    }

    public List<Author> getAuthors() {
        List<Author> authorList = new ArrayList(authorsMap.values());
        Collections.sort(authorList, new Comparator<Author>() {
            @Override
            public int compare(Author o1, Author o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return authorList;
    }

    public void deleteAuthor(String authorId) {
        authorsMap.remove(authorId);
    }

    @Override
    public void saveAuthor(Author author) throws DuplicateEntityException {
        for (Author existing : authorsMap.values()) {
            if (existing.getName().equals(author.getName()) && !existing.getId().equals(author.getId())) {
                throw new DuplicateEntityException(Author.class.getSimpleName(), "name", existing.getName());
            }
        }
        authorsMap.put(author.getId(), author);
    }

    @Override
    public Author getAuthorByName(String name) {
        Author result = authorsMap.get(name);
        if (result != null) {
            return result;
        } else {
            throw new IllegalArgumentException("No author with name: " + name);
        }
    }

}

