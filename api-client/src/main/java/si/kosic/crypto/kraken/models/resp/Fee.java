package si.kosic.crypto.kraken.models.resp;

import java.math.BigDecimal;

/**
 * @author ssituk
 */
public class Fee {
    private Long volume;
    private BigDecimal fee;

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
