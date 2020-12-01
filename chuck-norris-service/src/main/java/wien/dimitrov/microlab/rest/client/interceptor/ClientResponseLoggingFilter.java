package wien.dimitrov.microlab.rest.client.interceptor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import java.io.IOException;
import java.util.logging.Logger;

public class ClientResponseLoggingFilter implements ClientResponseFilter {

    private final static Logger logger = Logger.getLogger(ClientRequestLoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {
        logger.info("[Client Request " + clientRequestContext.getMethod() + " "
                + clientRequestContext.getUri().toURL()
                + " - Client Response Status: " + clientResponseContext.getStatus() + "]");    }
}
