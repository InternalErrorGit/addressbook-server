package controller;

import ch.zli.m223.addressbook.entity.Person;
import ch.zli.m223.addressbook.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@Path("/persons")
public class PersonController extends AbstractController<Person> {

    @Inject
    PersonService personService;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person create(Person entity) {
        return personService.create(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        personService.delete(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person find(@PathParam("id") Long id) {
        return personService.find(id);
    }
}
