package si.kosic.crypto.kraken.models.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import si.kosic.crypto.kraken.utils.AskBidDeserializer;
import si.kosic.crypto.kraken.utils.CountPairDeserializer;
import si.kosic.crypto.kraken.utils.PricePairDeserializer;
import si.kosic.crypto.kraken.utils.PriceVolumeDeserializer;
import si.kosic.crypto.kraken.utils.VolumePairDeserializer;

import java.math.BigDecimal;

/**
 * Created by ssituk on 4.6.2017.
 */
public class TickerInfo {

    @JsonDeserialize(using = AskBidDeserializer.class)
    private AskBid ask;

    @JsonDeserialize(using = AskBidDeserializer.class)
    private AskBid bid;

    @JsonDeserialize(using = PriceVolumeDeserializer.class)
    private PriceVolume lastTrade;

    @JsonDeserialize(using = VolumePairDeserializer.class)
    private VolumePair volume;

    @JsonDeserialize(using = VolumePairDeserializer.class)
    private VolumePair volumeWeightedAveragePrice;

    @JsonDeserialize(using = CountPairDeserializer.class)
    private CountPair numberOfTrades;

    @JsonDeserialize(using = PricePairDeserializer.class)
    private PricePair low;

    @JsonDeserialize(using = PricePairDeserializer.class)
    private PricePair high;

    private BigDecimal todaysOpeningPrice;

    public AskBid getAsk() {
        return ask;
    }

    @JsonProperty(value = "a")
    public void setAsk(AskBid ask) {
        this.ask = ask;
    }

    public AskBid getBid() {
        return bid;
    }

    @JsonProperty(value = "b")
    public void setBid(AskBid bid) {
        this.bid = bid;
    }

    public PriceVolume getLastTrade() {
        return lastTrade;
    }

    @JsonProperty(value = "c")
    public void setLastTrade(PriceVolume lastTrade) {
        this.lastTrade = lastTrade;
    }

    public VolumePair getVolume() {
        return volume;
    }

    @JsonProperty(value = "v")
    public void setVolume(VolumePair volume) {
        this.volume = volume;
    }

    public VolumePair getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    @JsonProperty(value = "p")
    public void setVolumeWeightedAveragePrice(VolumePair volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    public CountPair getNumberOfTrades() {
        return numberOfTrades;
    }

    @JsonProperty(value = "t")
    public void setNumberOfTrades(CountPair numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    public PricePair getLow() {
        return low;
    }

    @JsonProperty(value = "l")
    public void setLow(PricePair low) {
        this.low = low;
    }

    public PricePair getHigh() {
        return high;
    }

    @JsonProperty(value = "h")
    public void setHigh(PricePair high) {
        this.high = high;
    }

    public BigDecimal getTodaysOpeningPrice() {
        return todaysOpeningPrice;
    }

    @JsonProperty(value = "o")
    public void setTodaysOpeningPrice(BigDecimal todaysOpeningPrice) {
        this.todaysOpeningPrice = todaysOpeningPrice;
    }
}
