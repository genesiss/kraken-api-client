package si.kosic.crypto.kraken.services;


import si.kosic.crypto.kraken.utils.JerseyClient;

import javax.ws.rs.client.Client;

class AbstractService {

  protected Client httpClient;
  private final String ENDPOINT;
  protected final String ABSOLUTE_PATH;

  protected AbstractService(JerseyClient httpClient, String endpoint, String path) {
    this.ENDPOINT = endpoint.endsWith("/") ? endpoint.substring(0, endpoint.length()-1) : endpoint;
    path = path.startsWith("/") ? path : "/"+path;
    this.ABSOLUTE_PATH = endpoint + path;
    this.httpClient = httpClient.getHttpClient();
  }

}
