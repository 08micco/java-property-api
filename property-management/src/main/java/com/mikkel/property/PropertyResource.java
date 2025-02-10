package com.mikkel.property;

import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/properties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropertyResource {
    PropertyRepository repository = new PropertyRepository();

    @GET
    public List<Property> getAllProperties() {
        return repository.getAllProperties();
    }

    @GET
    @Path("/{id}")
    public Property getPropertyFromID(@PathParam("id") Long id) {
        return repository.getPropertyById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProperty(Property property) {
        repository.addProperty(property);
        return Response.status(Response.Status.CREATED).entity(property).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProperty(@PathParam("id") Long id, Property updatedProperty) {
        repository.updateProperty(id, updatedProperty);
        return Response.status(Response.Status.OK).entity(updatedProperty).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeProperty(@PathParam("id") Long id) {
        repository.removeProperty(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
