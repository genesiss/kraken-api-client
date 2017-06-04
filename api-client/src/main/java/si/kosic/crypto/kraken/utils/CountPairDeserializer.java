package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.collections4.IteratorUtils;
import si.kosic.crypto.kraken.models.resp.CountPair;

import java.io.IOException;
import java.util.List;

/**
 * @author ssituk
 */
public class CountPairDeserializer extends StdDeserializer<CountPair> {
    private static final long serialVersionUID = -4135217440476683814L;

    public CountPairDeserializer() {
        this(null);
    }

    protected CountPairDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public CountPair deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if (!node.isArray()) {
            //todo: add custom error
            throw new JsonParseException(jsonParser, "Json array was expected but got " + node.getNodeType().name());
        }

        List<JsonNode> nodes = IteratorUtils.toList(node.elements(), 2);
        if (nodes == null || nodes.size() != 2) {
            //todo: add custom error
            throw new JsonParseException(jsonParser, "Expected array of length 2. Array length is: " + (nodes == null ? "null" : nodes.size()));
        }

        CountPair countPair = new CountPair();
        countPair.setToday(nodes.get(0).asLong());
        countPair.setLast24hours(nodes.get(1).asLong());

        return countPair;
    }
}
