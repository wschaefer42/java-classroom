package org.example.demojakarta;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.annotation.FacesConfig;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.logging.Logger;

@FacesConfig
@ApplicationScoped
@ApplicationPath("/api")
public class AppConfig extends Application {
    @Produces
    public Logger getLogger() {
        return Logger.getLogger("demo-jakarta");
    }
}
