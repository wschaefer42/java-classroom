package org.example.jakartahello.common;

import jakarta.faces.annotation.FacesConfig;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@FacesConfig
@ApplicationPath("/api")
public class HelloApplication extends Application {
}
