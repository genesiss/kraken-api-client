package si.kosic.crypto.kraken.services;

import si.kosic.crypto.kraken.models.req.AssetReq;
import si.kosic.crypto.kraken.models.req.OhlcDataRequest;
import si.kosic.crypto.kraken.models.req.TickerInformationReq;
import si.kosic.crypto.kraken.models.req.TradableAssetPairs;
import si.kosic.crypto.kraken.models.resp.Asset;
import si.kosic.crypto.kraken.models.resp.KrakenResponse;
import si.kosic.crypto.kraken.models.resp.OhlcDataResp;
import si.kosic.crypto.kraken.models.resp.ServerTime;
import si.kosic.crypto.kraken.models.resp.TickerInfo;
import si.kosic.crypto.kraken.models.resp.TradablePair;
import si.kosic.crypto.kraken.utils.JerseyClient;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @author ssituk
 */
public class PublicMarketDataService extends AbstractService {

    private final static String PATH = "/0/public";

    private PublicMarketDataService(final JerseyClient httpClient, final String endpoint) {
        super(httpClient, endpoint, PATH);
    }

    public KrakenResponse<ServerTime> getServerTime() {
        return httpClient.target(ABSOLUTE_PATH + "/Time").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<KrakenResponse<ServerTime>>(){});
    }

    public KrakenResponse<Map<String, Asset>> getAssetInfo() {
        return getAssetInfo(new AssetReq());
    }

    public KrakenResponse<Map<String, Asset>> getAssetInfo(AssetReq assetReq) {
        return httpClient.target(ABSOLUTE_PATH + "/Assets").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(assetReq), new GenericType<KrakenResponse<Map<String, Asset>>>() {});
    }

    public KrakenResponse<Map<String, TradablePair>> getTradableAssetPairs() {
        return getTradableAssetPairs(new TradableAssetPairs());
    }

    public KrakenResponse<Map<String, TradablePair>> getTradableAssetPairs(TradableAssetPairs tradableAssetPairs) {
        return httpClient.target(ABSOLUTE_PATH + "/AssetPairs").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(tradableAssetPairs), new GenericType<KrakenResponse<Map<String, TradablePair>>>() {});
    }

    public KrakenResponse<Map<String, TickerInfo>> getTickerInformation(TickerInformationReq tickerInformationReq) {
        return httpClient.target(ABSOLUTE_PATH + "/Ticker").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(tickerInformationReq), new GenericType<KrakenResponse<Map<String, TickerInfo>>>() {});
    }

    //todo: deserialization doesn't work
    public KrakenResponse<Map<String, OhlcDataResp>> getOhlc(OhlcDataRequest ohlcDataRequest) {
        return httpClient.target(ABSOLUTE_PATH + "/OHLC").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(ohlcDataRequest), new GenericType<KrakenResponse<Map<String, OhlcDataResp>>>() {});
    }


}
