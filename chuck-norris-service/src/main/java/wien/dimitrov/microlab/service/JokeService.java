package wien.dimitrov.microlab.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import wien.dimitrov.microlab.model.Joke;
import wien.dimitrov.microlab.rest.client.JokeClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class JokeService {

    @Inject
    @RestClient
    JokeClient jokeClient;

    public Joke getRandomJoke() {
        Response response = jokeClient.getRandomJoke();
        Joke joke = response.readEntity(Joke.class);
        return joke;

    }
}
