package si.kosic.crypto.kraken.models.resp;

import java.math.BigDecimal;

/**
 * Created by ssituk on 4.6.2017.
 */
public class AskBid {
    private BigDecimal price;
    private Long wholeLotVolume;
    private BigDecimal lotVolume;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getWholeLotVolume() {
        return wholeLotVolume;
    }

    public void setWholeLotVolume(Long wholeLotVolume) {
        this.wholeLotVolume = wholeLotVolume;
    }

    public BigDecimal getLotVolume() {
        return lotVolume;
    }

    public void setLotVolume(BigDecimal lotVolume) {
        this.lotVolume = lotVolume;
    }
}
