package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import si.kosic.crypto.kraken.models.req.TradablePairReq;

import java.io.IOException;

/**
 * @author ssituk
 */
public class TradablePairSerializator extends StdSerializer<TradablePairReq> {

    private static final long serialVersionUID = -3203524429023082065L;

    public TradablePairSerializator() {
        this(null);
    }

    protected TradablePairSerializator(Class<TradablePairReq> t) {
        super(t);
    }


    @Override
    public void serialize(TradablePairReq tradablePair, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(tradablePair.getFirstAssetName() + tradablePair.getSecondAssetName());
    }
}
