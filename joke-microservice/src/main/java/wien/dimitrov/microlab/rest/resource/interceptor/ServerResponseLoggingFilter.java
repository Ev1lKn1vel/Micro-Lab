package wien.dimitrov.microlab.rest.resource.interceptor;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Logged
@Provider
public class ServerResponseLoggingFilter implements ContainerResponseFilter {

    private final static Logger logger = Logger.getLogger(ServerResponseLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        ObjectWriter objectWriter = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY).writer();

        logger.info("[Server Request " + containerRequestContext.getMethod() + " "
                + containerRequestContext.getUriInfo().getRequestUri().getPath()
                + " - Server Response Status: " + containerResponseContext.getStatus() + " "
                + " [" + objectWriter.writeValueAsString(containerResponseContext.getEntity()) + "]");
    }
}
