package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("/users")
public class UserResource {
    @GET
    public List<User> getUsers() {
        return User.listAll();
    }

    @GET
    @Path("/{name}")
    public List<User> listUsers(@RestPath String name) {
        return User.findByName(name);
    }

    @GET
    @Path("/search")
    public List<User> searchUsers(@RestQuery Integer age) {
        return User.findByAge(age);
    }
}
