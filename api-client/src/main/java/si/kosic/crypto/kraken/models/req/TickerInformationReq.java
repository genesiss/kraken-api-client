package si.kosic.crypto.kraken.models.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import si.kosic.crypto.kraken.utils.TradablePairListSerializator;

import java.util.List;

/**
 * @author ssituk
 */
public class TickerInformationReq {

    @JsonSerialize(using = TradablePairListSerializator.class)
    private List<TradablePairReq> pair;

    public List<TradablePairReq> getPair() {
        return pair;
    }

    public void setPair(List<TradablePairReq> pair) {
        this.pair = pair;
    }
}
