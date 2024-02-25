package org.example.demojakarta.greeting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/hello")
public class HelloResource {
    @Inject
    private HelloDao helloDao;

    @GET
    public List<HelloDto> getAll() {
        return helloDao.findAll().stream().map(Mapper::helloToDto).toList();
    }
}
