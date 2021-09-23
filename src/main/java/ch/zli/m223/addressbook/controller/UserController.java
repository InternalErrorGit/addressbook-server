package ch.zli.m223.addressbook.controller;

import ch.zli.m223.addressbook.entity.User;
import ch.zli.m223.addressbook.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@Path("/users")
public class UserController extends AbstractController<User> {

    @Inject
    UserService userService;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User entity) {
        return userService.create(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        userService.delete(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User find(@PathParam("id") Long id) {
        return userService.find(id);
    }
}
