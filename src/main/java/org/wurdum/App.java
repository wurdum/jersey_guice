package org.wurdum;

import com.google.inject.servlet.GuiceFilter;
import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import org.wurdum.ioc.GuiceModule;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ServletAdapter adapter = getServletAdapter();

        GrizzlyWebServer server = new GrizzlyWebServer(9998);
        server.addGrizzlyAdapter(adapter, new String[] {"/"});

        server.start();

        System.out.println("Press any key to exit...");
        System.in.read();

        server.stop();
    }

    private static ServletAdapter getServletAdapter() {
        ServletAdapter adapter = new ServletAdapter();
        adapter.setProperty(ServletAdapter.LOAD_ON_STARTUP, 1);
        adapter.setContextPath("/");
        adapter.setServletPath("/*");
        adapter.addServletListener(GuiceModule.class.getName());
        adapter.addFilter(new GuiceFilter(), "GuiceFilter", null);
        return adapter;
    }
}
