package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import si.kosic.crypto.kraken.models.req.TradablePairReq;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssituk
 */
public class TradablePairListSerializator extends StdSerializer<List<TradablePairReq>> {

    private static final long serialVersionUID = -3203524429023082065L;

    public TradablePairListSerializator() {
        this(null);
    }

    protected TradablePairListSerializator(Class<List<TradablePairReq>> t) {
        super(t);
    }


    @Override
    public void serialize(List<TradablePairReq> tradablePairReqs, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(tradablePairReqs.stream().map(tradablePair -> tradablePair.getFirstAssetName() + tradablePair.getSecondAssetName()).collect(Collectors.joining(",")));
    }
}
