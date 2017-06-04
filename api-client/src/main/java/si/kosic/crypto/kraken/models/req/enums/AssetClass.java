package si.kosic.crypto.kraken.models.req.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author ssituk
 */
public enum AssetClass {
    CURRENCY("currency");

    private String code;

    AssetClass(final String code) {
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
