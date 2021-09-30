package ch.zli.m223.addressbook.controller;

import ch.zli.m223.addressbook.entity.User;
import ch.zli.m223.addressbook.service.AuthService;
import ch.zli.m223.addressbook.service.UserService;
import ch.zli.m223.addressbook.viewmodel.LoginViewModel;

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
    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginViewModel login(User user) {
        System.out.println(user);
        User check = userService.find(user);
        if (check == null) {
            throw new NotAuthorizedException("User not found");
        } else {
            return new LoginViewModel(authService.generateValidJwtToken(user.getUsername()), check.getId());
        }
    }

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
