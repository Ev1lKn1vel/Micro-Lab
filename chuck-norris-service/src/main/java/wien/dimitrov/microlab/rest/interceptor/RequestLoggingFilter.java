package wien.dimitrov.microlab.rest.interceptor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Logged
@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

    private final static Logger logger = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        logger.info("[Request - " + containerRequestContext.getMethod() + " "
                + containerRequestContext.getUriInfo().getRequestUri().getPath()
                + "]");
    }
}
