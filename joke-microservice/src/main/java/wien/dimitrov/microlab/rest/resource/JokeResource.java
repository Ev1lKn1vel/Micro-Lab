package wien.dimitrov.microlab.rest.resource;

import wien.dimitrov.microlab.dto.JokeDto;
import wien.dimitrov.microlab.rest.resource.interceptor.Logged;
import wien.dimitrov.microlab.service.ChuckNorrisJokeService;
import wien.dimitrov.microlab.service.DadJokeService;

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
    ChuckNorrisJokeService chuckNorrisjokeService;

    @Inject
    DadJokeService dadJokeService;


    @Path("/chuck-norris")
    @GET
    public Response getChuckNorrisJoke(){
        JokeDto joke = chuckNorrisjokeService.getRandomJoke();
        return Response.ok(joke).build();
    }
    @Path("/dad")
    @GET
    public Response getDadJoke(){
        JokeDto joke = dadJokeService.getRandomJoke();
        return Response.ok(joke).build();
    }
}
