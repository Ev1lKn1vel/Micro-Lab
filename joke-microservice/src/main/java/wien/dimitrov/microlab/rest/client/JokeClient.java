package wien.dimitrov.microlab.rest.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterProviders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import wien.dimitrov.microlab.rest.client.interceptor.ClientRequestLoggingFilter;
import wien.dimitrov.microlab.rest.client.interceptor.ClientResponseLoggingFilter;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient
@RegisterProviders({
        @RegisterProvider(ClientRequestLoggingFilter.class),
        @RegisterProvider(ClientResponseLoggingFilter.class)
})
public interface JokeClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getRandomJoke();
}
