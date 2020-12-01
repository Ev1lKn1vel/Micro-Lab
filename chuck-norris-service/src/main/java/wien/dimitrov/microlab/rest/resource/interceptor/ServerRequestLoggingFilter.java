package wien.dimitrov.microlab.rest.resource.interceptor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Logged
@Provider
public class ServerRequestLoggingFilter implements ContainerRequestFilter {

    private final static Logger logger = Logger.getLogger(ServerRequestLoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        logger.info("[Server Request - " + containerRequestContext.getMethod() + " "
                + containerRequestContext.getUriInfo().getRequestUri().getPath()
                + "]");
    }
}
