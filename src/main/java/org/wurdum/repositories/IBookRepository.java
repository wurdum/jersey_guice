package org.wurdum.repositories;

import org.wurdum.models.Book;

import java.util.List;

public interface IBookRepository {

    void add(Book book);
    List<Book> getAll();
}
