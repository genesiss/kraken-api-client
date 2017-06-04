package si.kosic.crypto.kraken.models.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import si.kosic.crypto.kraken.models.req.enums.AssetClass;
import si.kosic.crypto.kraken.models.req.enums.AssetInfo;
import si.kosic.crypto.kraken.utils.StringListToCommaSeparatedStringSerializer;

import java.util.List;

/**
 * Created by ssituk on 4.6.2017.
 */
public class AssetReq {
    private AssetInfo info = AssetInfo.ALL;
    private AssetClass aclass = AssetClass.CURRENCY;

    @JsonSerialize(using = StringListToCommaSeparatedStringSerializer.class)
    private List<String> asset;

    public AssetInfo getInfo() {
        return info;
    }

    public void setInfo(AssetInfo info) {
        this.info = info;
    }

    public AssetClass getAclass() {
        return aclass;
    }

    public void setAclass(AssetClass aclass) {
        this.aclass = aclass;
    }

    public List<String> getAsset() {
        return asset;
    }

    public void setAsset(List<String> asset) {
        this.asset = asset;
    }

}
