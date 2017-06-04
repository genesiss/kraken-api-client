package si.kosic.crypto.kraken.models.resp;

import java.math.BigDecimal;

/**
 * Created by ssituk on 4.6.2017.
 */
public class PricePair {

    private BigDecimal today;
    private BigDecimal last24hours;

    public BigDecimal getToday() {
        return today;
    }

    public void setToday(BigDecimal today) {
        this.today = today;
    }

    public BigDecimal getLast24hours() {
        return last24hours;
    }

    public void setLast24hours(BigDecimal last24hours) {
        this.last24hours = last24hours;
    }
}
