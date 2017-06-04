package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.collections4.IteratorUtils;
import si.kosic.crypto.kraken.models.resp.Fee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ssituk
 */
public class FeesDeserializer extends StdDeserializer<List<Fee>> {
    private static final long serialVersionUID = -4135217440476683814L;

    public FeesDeserializer() {
        this(null);
    }

    protected FeesDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<Fee> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if (!node.isArray()) {
            throw new JsonParseException(jsonParser, "Json array was expected but got " + node.getNodeType().name());
        }

        List<Fee> fees = new ArrayList<>();
        for (Iterator<JsonNode> it = node.elements(); it.hasNext(); ) {
            JsonNode tuple = it.next();

            List<JsonNode> tupleElements = IteratorUtils.toList(tuple.elements(), 2);
            if (tupleElements == null || tupleElements.size() != 2) {
                //todo: add custom error
                throw new JsonParseException(jsonParser, "Expected array of length 2. Array length is: " + (tupleElements == null ? "null" : tupleElements.size()));
            }

            Fee fee = new Fee();
            fee.setVolume(tupleElements.get(0).asLong());
            fee.setFee(tupleElements.get(1).decimalValue());
            fees.add(fee);
        }
        return fees;
    }
}
