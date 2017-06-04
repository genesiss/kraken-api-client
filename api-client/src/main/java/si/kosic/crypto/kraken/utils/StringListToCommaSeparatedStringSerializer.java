package si.kosic.crypto.kraken.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ssituk
 */
public class StringListToCommaSeparatedStringSerializer extends StdSerializer<List<String>> {

    private static final long serialVersionUID = -3203524429023082065L;

    public StringListToCommaSeparatedStringSerializer() {
        this(null);
    }

    protected StringListToCommaSeparatedStringSerializer(Class<List<String>> t) {
        super(t);
    }

    @Override
    public void serialize(List<String> values, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(values.stream().collect(Collectors.joining(",")));
    }
}
