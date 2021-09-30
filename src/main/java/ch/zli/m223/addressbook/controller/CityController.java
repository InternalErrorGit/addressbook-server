package ch.zli.m223.addressbook.controller;

import ch.zli.m223.addressbook.entity.Address;
import ch.zli.m223.addressbook.entity.City;
import ch.zli.m223.addressbook.service.CityService;
import io.quarkus.security.Authenticated;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@Authenticated
@Path("/cities")
public class CityController extends AbstractController<City> {

    @Inject
    CityService cityService;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public City create(City entity) {
        return cityService.create(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        cityService.delete(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> findAll() {
        return cityService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public City find(@PathParam("id") Long id) {
        return cityService.find(id);
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public City update(City entity) {
        return cityService.update(entity);
    }
}
