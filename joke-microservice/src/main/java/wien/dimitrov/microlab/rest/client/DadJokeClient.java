package wien.dimitrov.microlab.rest.client;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import wien.dimitrov.microlab.dto.JokeDto;
import wien.dimitrov.microlab.rest.client.interceptor.ClientRequestLoggingFilter;
import wien.dimitrov.microlab.rest.client.interceptor.ClientResponseLoggingFilter;
import wien.dimitrov.microlab.rest.client.model.DadJoke;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class DadJokeClient {

    @ConfigProperty(name = "dadjoke.url")
    String BASE_URL;

    public DadJoke getRandomDadJoke(){
        Client client = ClientBuilder.newClient()
                .register(ClientRequestLoggingFilter.class)
                .register(ClientResponseLoggingFilter.class);

        return client.target(BASE_URL)
                .request(MediaType.APPLICATION_JSON)
                .get(DadJoke.class);
    }

}
