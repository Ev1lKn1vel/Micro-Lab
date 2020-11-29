package wien.dimitrov.microlab.rest.resource;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import wien.dimitrov.microlab.rest.client.JokeClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/joke")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JokeResource {

    @Inject
    @RestClient
    JokeClient jokeClient;

    @Path("/chuck-norris")
    @GET
    public Response getChuckNorrisJoke(){
        return jokeClient.getRandomJoke();
    }
}
