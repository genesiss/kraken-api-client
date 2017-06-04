package si.kosic.crypto.kraken.models.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import si.kosic.crypto.kraken.models.req.enums.OhlcInterval;
import si.kosic.crypto.kraken.utils.TradablePairSerializator;

/**
 * Created by ssituk on 4.6.2017.
 */
public class OhlcDataRequest {

    @JsonSerialize(using = TradablePairSerializator.class)
    private TradablePairReq pair;
    private OhlcInterval interval = OhlcInterval._1;
    private String since;

    public TradablePairReq getPair() {
        return pair;
    }

    public void setPair(TradablePairReq pair) {
        this.pair = pair;
    }

    public OhlcInterval getInterval() {
        return interval;
    }

    public void setInterval(OhlcInterval interval) {
        this.interval = interval;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

}
