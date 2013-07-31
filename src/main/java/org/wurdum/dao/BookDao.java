package org.wurdum.dao;

import com.github.jmkgreen.morphia.Morphia;
import com.github.jmkgreen.morphia.dao.BasicDAO;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mongodb.Mongo;
import org.wurdum.models.Book;

public class BookDao extends BasicDAO<Book, String> {

    @Inject
    public BookDao(Mongo mongo, Morphia morphia, @Named("dbname") String dbName) {
        super(mongo, morphia, dbName);
    }
}
