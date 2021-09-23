package controller;

import ch.zli.m223.addressbook.entity.Address;
import ch.zli.m223.addressbook.service.AddressService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 23.09.2021
 * Project: addressbookserver
 */
@Path("/addresses")
public class AddressController extends AbstractController<Address> {

    @Inject
    AddressService addressService;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Address create(Address entity) {
        return addressService.create(entity);
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id) {
        addressService.delete(id);
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address find(@PathParam("id") Long id) {
        return addressService.find(id);
    }
}
