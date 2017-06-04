package si.kosic.crypto.kraken.models.req.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author ssituk
 */
public enum OhlcInterval {
    _1("1"),
    _5("5"),
    _15("15"),
    _30("30"),
    _60("60"),
    _240("240"),
    _1440("1440"),
    _10080("10080"),
    _21600("21600");

    private String code;

    OhlcInterval(final String code) {
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
