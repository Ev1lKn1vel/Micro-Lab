package wien.dimitrov.microlab.service;

import wien.dimitrov.microlab.dto.JokeDto;
import wien.dimitrov.microlab.mapper.JokeMapper;
import wien.dimitrov.microlab.rest.client.DadJokeClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DadJokeService implements IJokeService {

    @Inject
    DadJokeClient dadJokeClient;

    @Override
    public JokeDto getRandomJoke() {
        return JokeMapper.map(dadJokeClient.getRandomDadJoke());
    }
}
