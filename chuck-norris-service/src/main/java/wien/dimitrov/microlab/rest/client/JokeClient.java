package wien.dimitrov.microlab.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient
public interface JokeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getRandomJoke();
}
