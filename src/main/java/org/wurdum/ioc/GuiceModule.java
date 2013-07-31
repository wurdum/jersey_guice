package org.wurdum.ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

public class GuiceModule extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets() {
                install(new AppModule());

                Map<String, String> props = new HashMap<>();
                props.put("com.sun.jersey.config.property.packages", "org.wurdum.resources");

                serve("/*").with(GuiceContainer.class, props);
            }
        });
    }
}
