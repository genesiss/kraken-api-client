package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.collections4.IteratorUtils;
import si.kosic.crypto.kraken.models.resp.OhlcData;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

/**
 * @author ssituk
 */
public class OhlcDataDeserializer extends StdDeserializer<OhlcData> {
    private static final long serialVersionUID = -4135217440476683814L;

    public OhlcDataDeserializer() {
        this(null);
    }

    protected OhlcDataDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public OhlcData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if (!node.isArray()) {
            //todo: add custom error
            throw new JsonParseException(jsonParser, "Json array was expected but got " + node.getNodeType().name());
        }

        List<JsonNode> nodes = IteratorUtils.toList(node.elements(), 8);
        if (nodes == null || nodes.size() != 8) {
            //todo: add custom error
            throw new JsonParseException(jsonParser, "Expected array of length 8. Array length is: " + (nodes == null ? "null" : nodes.size()));
        }

        OhlcData ohlcData = new OhlcData();
        ohlcData.setTime(Instant.ofEpochMilli(nodes.get(0).asLong()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        ohlcData.setOpen(nodes.get(1).decimalValue());
        ohlcData.setHigh(nodes.get(2).decimalValue());
        ohlcData.setLow(nodes.get(3).decimalValue());
        ohlcData.setClose(nodes.get(4).decimalValue());
        ohlcData.setVwap(nodes.get(5).decimalValue());
        ohlcData.setVolume(nodes.get(6).decimalValue());
        ohlcData.setCount(nodes.get(7).asLong());
        return ohlcData;
    }
}
