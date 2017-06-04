package si.kosic.crypto.kraken.context;

import si.kosic.crypto.kraken.services.PublicMarketDataService;
import si.kosic.crypto.kraken.utils.JerseyClient;

import java.lang.reflect.Constructor;


public class KrakenContext {

    private final JerseyClient httpClient;
    private final String API_KEY;

    private PublicMarketDataService publicMarketDataService;

    public KrakenContext(final String endpoint) {
        this(endpoint,null);
    }

    public KrakenContext(final String endpoint, final String apiKey) {
        this(endpoint, apiKey, null);
    }

    public KrakenContext(final String endpoint, final String apiKey, Integer timeout) {
        this.API_KEY = apiKey;
        try {
            this.httpClient = new JerseyClient(timeout);
            this.publicMarketDataService = this.getPrivateConstructor(PublicMarketDataService.class).newInstance(this.httpClient, endpoint);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    public PublicMarketDataService getPublicMarketDataService() {
        return publicMarketDataService;
    }

    private <T> Constructor<T> getPrivateConstructor(final Class<T> clazz) throws Exception {
        Constructor<T> declaredConstructor = clazz.getDeclaredConstructor(JerseyClient.class, String.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor;
    }

}
