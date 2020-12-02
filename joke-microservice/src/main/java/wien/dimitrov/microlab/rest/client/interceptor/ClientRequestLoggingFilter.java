package wien.dimitrov.microlab.rest.client.interceptor;


import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.util.logging.Logger;

public class ClientRequestLoggingFilter implements ClientRequestFilter {

    private final static Logger logger = Logger.getLogger(ClientRequestLoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        logger.info("[Client Request - " + clientRequestContext.getMethod() + " "
                + clientRequestContext.getUri().getHost()
                + clientRequestContext.getUri().getPath()
                + "]");
    }
}
