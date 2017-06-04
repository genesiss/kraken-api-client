package si.kosic.crypto.kraken.models.resp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import si.kosic.crypto.kraken.utils.FeesDeserializer;

import java.util.List;

/**
 * @author ssituk
 */
public class TradablePair {
    private String altname;
    private String aclass_base;
    private String base;
    private String aclass_quote;
    private String quote;
    private String lot;
    private Short pair_decimals;
    private Short lot_decimals;
    private Short lot_multiplier;
    private List<Short> leverage_buy;
    private List<Short> leverage_sell;

    @JsonDeserialize(using = FeesDeserializer.class)
    private List<Fee> fees;

    @JsonDeserialize(using = FeesDeserializer.class)
    private List<Fee> fees_maker;
    private String fee_volume_currency;
    private Integer margin_call;
    private Integer margin_stop;

    public String getAltname() {
        return altname;
    }

    public void setAltname(String altname) {
        this.altname = altname;
    }

    public String getAclass_base() {
        return aclass_base;
    }

    public void setAclass_base(String aclass_base) {
        this.aclass_base = aclass_base;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAclass_quote() {
        return aclass_quote;
    }

    public void setAclass_quote(String aclass_quote) {
        this.aclass_quote = aclass_quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Short getPair_decimals() {
        return pair_decimals;
    }

    public void setPair_decimals(Short pair_decimals) {
        this.pair_decimals = pair_decimals;
    }

    public Short getLot_decimals() {
        return lot_decimals;
    }

    public void setLot_decimals(Short lot_decimals) {
        this.lot_decimals = lot_decimals;
    }

    public Short getLot_multiplier() {
        return lot_multiplier;
    }

    public void setLot_multiplier(Short lot_multiplier) {
        this.lot_multiplier = lot_multiplier;
    }

    public List<Short> getLeverage_buy() {
        return leverage_buy;
    }

    public void setLeverage_buy(List<Short> leverage_buy) {
        this.leverage_buy = leverage_buy;
    }

    public List<Short> getLeverage_sell() {
        return leverage_sell;
    }

    public void setLeverage_sell(List<Short> leverage_sell) {
        this.leverage_sell = leverage_sell;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    public List<Fee> getFees_maker() {
        return fees_maker;
    }

    public void setFees_maker(List<Fee> fees_maker) {
        this.fees_maker = fees_maker;
    }

    public String getFee_volume_currency() {
        return fee_volume_currency;
    }

    public void setFee_volume_currency(String fee_volume_currency) {
        this.fee_volume_currency = fee_volume_currency;
    }

    public Integer getMargin_call() {
        return margin_call;
    }

    public void setMargin_call(Integer margin_call) {
        this.margin_call = margin_call;
    }

    public Integer getMargin_stop() {
        return margin_stop;
    }

    public void setMargin_stop(Integer margin_stop) {
        this.margin_stop = margin_stop;
    }
}
