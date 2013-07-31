package org.wurdum.repositories;

import org.wurdum.models.Book;
import org.wurdum.dao.BookDao;

import javax.inject.Inject;
import java.util.List;

public class MongoBookRepository implements IBookRepository {

    private final BookDao dao;

    @Inject
    public MongoBookRepository(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Book book) {
        this.dao.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.dao.find().asList();
    }
}
