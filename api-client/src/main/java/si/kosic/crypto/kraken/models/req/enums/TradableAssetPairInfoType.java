package si.kosic.crypto.kraken.models.req.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author ssituk
 */
public enum TradableAssetPairInfoType {
    INFO("info"),
    LEVERAGE("leverage"),
    FEES("fees"),
    MARGIN("margin");

    private String code;

    TradableAssetPairInfoType(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(code);
    }

}
