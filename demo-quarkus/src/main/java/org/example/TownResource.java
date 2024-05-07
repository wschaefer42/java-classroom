package org.example;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/towns")
public class TownResource {
    @Inject
    TownRepository townRepository;

    @GET
    public List<TownDto> getAll() {
        return townRepository.listAll().stream().map(TownDto::new).toList();
    }

    @POST
    @Transactional
    public Long create(TownDto town) {
        Town newTown = new Town();
        newTown.name = town.name();
        newTown.countryCode = town.countryCode();
        townRepository.persist(newTown);
        return newTown.id;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean deleteById(@RestPath Long id) {
        return townRepository.deleteById(id);
    }
}
