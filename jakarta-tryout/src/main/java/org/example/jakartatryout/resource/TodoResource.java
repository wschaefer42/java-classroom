package org.example.jakartatryout.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.example.jakartatryout.domain.Todo;
import org.example.jakartatryout.domain.TodoDAO;

import java.util.List;

@Path("/todos")
public class TodoResource {
    @Inject
    private TodoDAO todoDAO;

    @GET
    public List<Todo> getAll() {
        return todoDAO.findAll();
    }

    @POST
    public void create(Todo todo) {
        todoDAO.save(todo.getName(), todo.getDescription());
    }

}
