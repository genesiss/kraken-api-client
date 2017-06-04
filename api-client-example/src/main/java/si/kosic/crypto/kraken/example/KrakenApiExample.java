package si.kosic.crypto.kraken.example;

import si.kosic.crypto.kraken.context.KrakenContext;
import si.kosic.crypto.kraken.models.req.AssetReq;
import si.kosic.crypto.kraken.models.req.OhlcDataRequest;
import si.kosic.crypto.kraken.models.req.TickerInformationReq;
import si.kosic.crypto.kraken.models.req.TradableAssetPairs;
import si.kosic.crypto.kraken.models.req.TradablePairReq;
import si.kosic.crypto.kraken.models.req.enums.TradableAssetPairInfoType;
import si.kosic.crypto.kraken.models.resp.Asset;
import si.kosic.crypto.kraken.models.resp.KrakenResponse;
import si.kosic.crypto.kraken.models.resp.OhlcDataResp;
import si.kosic.crypto.kraken.models.resp.ServerTime;
import si.kosic.crypto.kraken.models.resp.TickerInfo;
import si.kosic.crypto.kraken.models.resp.TradablePair;
import si.kosic.crypto.kraken.services.PublicMarketDataService;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by ssituk on 4.6.2017.
 */
public class KrakenApiExample {

    public static void main(String[] args) {
        KrakenContext krakenContext = new KrakenContext("https://api.kraken.com");
        PublicMarketDataService publicMarketDataService = krakenContext.getPublicMarketDataService();
        KrakenResponse<ServerTime> serverTime = publicMarketDataService.getServerTime();
        KrakenResponse<Map<String, Asset>> assetInfo = publicMarketDataService.getAssetInfo();
        AssetReq assetReq = new AssetReq();
        assetReq.setAsset(Arrays.asList("ETH", "XRP"));
        assetInfo = publicMarketDataService.getAssetInfo(assetReq);
        KrakenResponse<Map<String, TradablePair>> tradableAssetPairs = publicMarketDataService.getTradableAssetPairs();
        TradableAssetPairs pairs = new TradableAssetPairs();
        pairs.setInfo(TradableAssetPairInfoType.LEVERAGE);
        pairs.setPair(Arrays.asList(new TradablePairReq("DASH", "EUR"), new TradablePairReq("DASH", "USD")));
        tradableAssetPairs = publicMarketDataService.getTradableAssetPairs(pairs);

        TickerInformationReq tickerInformationReq = new TickerInformationReq();
        tickerInformationReq.setPair(Arrays.asList(new TradablePairReq("DASH", "EUR"), new TradablePairReq("DASH", "USD")));
        KrakenResponse<Map<String, TickerInfo>> tickerInfo = publicMarketDataService.getTickerInformation(tickerInformationReq);

        OhlcDataRequest ohlcDataRequest = new OhlcDataRequest();
        ohlcDataRequest.setPair(tickerInformationReq.getPair().get(0));
        KrakenResponse<Map<String, OhlcDataResp>> ohlc = publicMarketDataService.getOhlc(ohlcDataRequest);

        int a = 5;
    }

}
