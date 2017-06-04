package si.kosic.crypto.kraken.models.req;

/**
 * @author ssituk
 */
public class TradablePairReq {
    private String firstAssetName;
    private String secondAssetName;
    public TradablePairReq() {
    }

    public TradablePairReq(String firstAssetName, String secondAssetName) {
        this.firstAssetName = firstAssetName;
        this.secondAssetName = secondAssetName;
    }


    public String getFirstAssetName() {
        return firstAssetName;
    }

    public void setFirstAssetName(String firstAssetName) {
        this.firstAssetName = firstAssetName;
    }

    public String getSecondAssetName() {
        return secondAssetName;
    }

    public void setSecondAssetName(String secondAssetName) {
        this.secondAssetName = secondAssetName;
    }


}
