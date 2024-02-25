package org.example.jakartahello.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/health")
public class HealthResource {
    @GET
    @Path("/ping")
    public String ping() {
        return "PONG";
    }
}
