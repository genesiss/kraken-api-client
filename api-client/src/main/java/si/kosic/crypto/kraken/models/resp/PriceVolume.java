package si.kosic.crypto.kraken.models.resp;

import java.math.BigDecimal;

/**
 * Created by ssituk on 4.6.2017.
 */
public class PriceVolume {

    private BigDecimal price;
    private BigDecimal lotVolume;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getLotVolume() {
        return lotVolume;
    }

    public void setLotVolume(BigDecimal lotVolume) {
        this.lotVolume = lotVolume;
    }
}
