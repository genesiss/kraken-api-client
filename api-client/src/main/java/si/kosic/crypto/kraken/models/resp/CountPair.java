package si.kosic.crypto.kraken.models.resp;

/**
 * Created by ssituk on 4.6.2017.
 */
public class CountPair {

    private Long today;
    private Long last24hours;

    public Long getToday() {
        return today;
    }

    public void setToday(Long today) {
        this.today = today;
    }

    public Long getLast24hours() {
        return last24hours;
    }

    public void setLast24hours(Long last24hours) {
        this.last24hours = last24hours;
    }
}
