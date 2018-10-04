package edu.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/service")
public class RestService {
    @GET
    @Path("/say/hello")
    public Response sayHello() {
        return Response.status(200).entity("hello").build();
    }

    @GET
    @Path("/say/{something}")
    public Response saySomething(@PathParam("something") String out){
        return Response.status(200).entity(out).build();
    }

    @GET
    @Path("/query")
    public Response queryParams(@QueryParam("from") int from, @QueryParam("to") @DefaultValue("10") int to){
        return Response.status(200).entity("from = " + from + " to = " + to).build();
    }

    @POST
    @Path("/add")
    public Response add(@FormParam("name") String name, @FormParam("age") int age){
        return Response.status(200).entity("Name   " + name + " Age " + age).build();
    }


}
