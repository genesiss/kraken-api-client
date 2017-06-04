package si.kosic.crypto.kraken.utils;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import si.kosic.crypto.kraken.utils.filters.EntityLoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public final class JerseyClient {

    private final Client httpClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class.getName());


    public JerseyClient() {
        this(null);
    }

    public JerseyClient(final Integer timeout) {
        //todo make it configurable from outside
        ClientConfig configuration = new ClientConfig();
        if (timeout != null) {
            configuration.property(ClientProperties.CONNECT_TIMEOUT, timeout);
            configuration.property(ClientProperties.READ_TIMEOUT, timeout);
        }

        this.httpClient = ClientBuilder.newBuilder().register(new EntityLoggingFilter(LOGGER, Level.ERROR, true)).build();
    }

    public Client getHttpClient() {
        return httpClient;
    }

}
