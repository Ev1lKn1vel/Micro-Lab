package wien.dimitrov.microlab.rest.interceptor;

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
public class ResponseLoggingFilter implements ContainerResponseFilter {

    private final static Logger logger = Logger.getLogger(ResponseLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        ObjectWriter objectWriter = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY).writer();

        logger.info("[Request " + containerRequestContext.getMethod() + " "
                + containerRequestContext.getUriInfo().getRequestUri().getPath()
                + " - Response Status: " + containerResponseContext.getStatus() + " "
                + " [" + objectWriter.writeValueAsString(containerResponseContext.getEntity()) + "]");
    }
}
