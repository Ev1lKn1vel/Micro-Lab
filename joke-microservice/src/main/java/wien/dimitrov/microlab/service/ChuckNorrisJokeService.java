package wien.dimitrov.microlab.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import wien.dimitrov.microlab.dto.JokeDto;
import wien.dimitrov.microlab.mapper.JokeMapper;
import wien.dimitrov.microlab.rest.client.ChuckNorrisJokeClient;
import wien.dimitrov.microlab.rest.client.model.ChuckNorrisJoke;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ChuckNorrisJokeService implements IJokeService {

    @Inject
    @RestClient
    ChuckNorrisJokeClient jokeClient;

    public JokeDto getRandomJoke() {
        Response response = jokeClient.getRandomJoke();
        ChuckNorrisJoke chuckNorrisJoke = response.readEntity(ChuckNorrisJoke.class);
        return JokeMapper.map(chuckNorrisJoke);
    }
}
