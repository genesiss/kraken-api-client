package si.kosic.crypto.kraken.models.resp;

/**
 * @author ssituk
 */
public class Asset {
    private String aclass;
    private String altname;
    private Short decimals;
    private Short display_decimals;

    public String getAclass() {
        return aclass;
    }

    public void setAclass(String aclass) {
        this.aclass = aclass;
    }

    public String getAltname() {
        return altname;
    }

    public void setAltname(String altname) {
        this.altname = altname;
    }

    public Short getDecimals() {
        return decimals;
    }

    public void setDecimals(Short decimals) {
        this.decimals = decimals;
    }

    public Short getDisplay_decimals() {
        return display_decimals;
    }

    public void setDisplay_decimals(Short display_decimals) {
        this.display_decimals = display_decimals;
    }
}
