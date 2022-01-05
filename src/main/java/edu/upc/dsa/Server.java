package edu.upc.dsa;

import edu.upc.dsa.Badge;
import edu.upc.dsa.Manager;
import edu.upc.dsa.ManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value ="/endpoint", description = "Endpoint to Pokemon Service")
@Path("/endpoint")
public class Server {
    private Manager manager;

    public Server() {
        this.manager = ManagerImpl.getInstance();
    }

    @GET
    @ApiOperation(value = "get list of badges", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Badge.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/badges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBadges(){
        List<Badge> badges = this.manager.getBadges();
        if(badges.size()!=0) {
            GenericEntity<List<Badge>> entity = new GenericEntity<List<Badge>>(badges) {
            };
            return Response.status(200).entity(entity).build();
        }
        else{
            return Response.status(500).build();
        }
    }

    @GET
    @ApiOperation(value = "get user", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Not found")
    })
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") String userId){
        if(userId!=null){
            User user = this.manager.getUser(userId);
            if (user!=null){
                return Response.status(201).entity(user).build();}
            else{
                return Response.status(500).build();}}
        else{
            return Response.status(500).build();}
    }
}
