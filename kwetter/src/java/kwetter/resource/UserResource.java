package kwetter.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import kwetter.domain.User;
import kwetter.service.KwetterService;

public class UserResource {
    
    private KwetterService kwetterService = new KwetterService();
    
    private final String name;

    public UserResource(String name) {
        this.name = name;
    }
    
    @GET
    @Produces("application/json")
    public User getUser() {
        return kwetterService.find(name);
    }
}
