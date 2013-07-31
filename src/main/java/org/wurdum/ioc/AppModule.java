package org.wurdum.ioc;

import com.github.jmkgreen.morphia.Morphia;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wurdum.repositories.IBookRepository;
import org.wurdum.repositories.MongoBookRepository;

import java.net.UnknownHostException;

public class AppModule extends AbstractModule {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppModule.class);
    private final static Config CONFIG = ConfigFactory.load();

    protected void configure() {
        try {
            bind(Mongo.class).toInstance(new MongoClient(
                    CONFIG.getString("jersey_guice.mongo.host"),
                    CONFIG.getInt("jersey_guice.mongo.port")));
        } catch (UnknownHostException e) {
            LOGGER.error("Mongo instantiation error", e);
        }

        bind(IBookRepository.class).to(MongoBookRepository.class);
        bind(Morphia.class).toInstance(new Morphia());
        bind(String.class)
                .annotatedWith(Names.named("dbname"))
                .toInstance(CONFIG.getString("jersey_guice.mongo.database"));
    }
}
