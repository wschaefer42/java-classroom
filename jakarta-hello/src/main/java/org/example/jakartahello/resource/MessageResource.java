package org.example.jakartahello.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.example.jakartahello.domain.Message;
import org.example.jakartahello.domain.MessageRepository;
import java.util.List;

@Path("/messages")
public class MessageResource {
    @Inject
    private MessageRepository repository;

    @GET
    public List<Message> getAll() {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    public Message getById(@PathParam("id") long id) {
        return repository.findById(id);
    }

    @POST
    public Message insert(@Valid Message message) {
        return repository.save(message);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        if (repository.delete(id)) {
            return Response.status(Status.OK).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
