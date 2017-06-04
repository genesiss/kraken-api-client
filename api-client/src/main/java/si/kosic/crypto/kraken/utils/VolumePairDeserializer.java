package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.apache.commons.collections4.IteratorUtils;
import si.kosic.crypto.kraken.models.resp.VolumePair;

import java.io.IOException;
import java.util.List;

/**
 * @author ssituk
 */
public class VolumePairDeserializer extends StdDeserializer<VolumePair> {
    private static final long serialVersionUID = -4135217440476683814L;

    public VolumePairDeserializer() {
        this(null);
    }

    protected VolumePairDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public VolumePair deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
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

        VolumePair volumePair = new VolumePair();
        volumePair.setToday(nodes.get(0).decimalValue());
        volumePair.setLast24hours(nodes.get(1).decimalValue());

        return volumePair;
    }
}
