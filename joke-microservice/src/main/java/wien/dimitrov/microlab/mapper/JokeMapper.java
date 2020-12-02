package wien.dimitrov.microlab.mapper;

import wien.dimitrov.microlab.dto.JokeDto;
import wien.dimitrov.microlab.rest.client.model.ChuckNorrisJoke;
import wien.dimitrov.microlab.rest.client.model.DadJoke;

import javax.inject.Singleton;

@Singleton
public class JokeMapper {

    public static JokeDto map(ChuckNorrisJoke chuckNorrisJoke) {
        JokeDto joke = new JokeDto();
        joke.setJoke(chuckNorrisJoke.getValue());
        return joke;
    }

    public static JokeDto map(DadJoke dadJoke) {
        JokeDto joke = new JokeDto();
        joke.setJoke(dadJoke.getJoke());
        return joke;
    }

}
