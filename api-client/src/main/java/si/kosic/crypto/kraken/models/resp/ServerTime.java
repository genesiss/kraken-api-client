package si.kosic.crypto.kraken.models.resp;

/**
 * @author ssituk
 */
public class ServerTime {

    private Long unixtime;
    private String rfc1123;

    public Long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(Long unixtime) {
        this.unixtime = unixtime;
    }

    public String getRfc1123() {
        return rfc1123;
    }

    public void setRfc1123(String rfc1123) {
        this.rfc1123 = rfc1123;
    }
}
