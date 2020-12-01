package wien.dimitrov.microlab.rest.resource;

import wien.dimitrov.microlab.model.Joke;
import wien.dimitrov.microlab.rest.resource.interceptor.Logged;
import wien.dimitrov.microlab.service.JokeService;

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
@Logged
public class JokeResource {

    @Inject
    JokeService jokeService;

    @Path("/chuck-norris")
    @GET
    public Response getChuckNorrisJoke(){
        Joke joke = jokeService.getRandomJoke();
        return Response.ok(joke).build();
    }
}
