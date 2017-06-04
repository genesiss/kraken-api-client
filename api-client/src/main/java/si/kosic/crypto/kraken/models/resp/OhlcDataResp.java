package si.kosic.crypto.kraken.models.resp;

import java.util.List;

/**
 * Created by ssituk on 4.6.2017.
 */
public class OhlcDataResp {

    private String last;
    private List<OhlcData> ohlcDataList;

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public List<OhlcData> getOhlcDataList() {
        return ohlcDataList;
    }

    public void setOhlcDataList(List<OhlcData> ohlcDataList) {
        this.ohlcDataList = ohlcDataList;
    }
}
