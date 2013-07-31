package org.wurdum.resources;

import com.google.inject.Inject;
import org.wurdum.models.Book;
import org.wurdum.repositories.IBookRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Path("/books")
public class BooksResource {

    private final static Random RND = new Random(System.currentTimeMillis());

    private final IBookRepository bookRepository;

    @Inject
    public BooksResource(IBookRepository repository) throws UnknownHostException {
        this.bookRepository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAll() {
        return this.bookRepository.getAll();
    }

    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Book addOne() {
        Book book = getRandomBook();

        this.bookRepository.add(book);

        return book;
    }

    private Book getRandomBook() {
        String name = UUID.randomUUID().toString();
        int length = RND.nextInt();

        return new Book(name, length);
    }
}
