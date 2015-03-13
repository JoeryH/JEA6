package kwetter.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import kwetter.domain.User;
import kwetter.service.KwetterService;

@Path("/users")
public class UsersResource {
    
    private KwetterService kwetterService = new KwetterService();
    
    @POST
    public void createUser(User user) {
        kwetterService.create(user);
    }
    
    @Path("/{name}")
    public UserResource getUser(@PathParam("name") String name) {
        return new UserResource(name);
    }
}
