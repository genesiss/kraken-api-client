package si.kosic.crypto.kraken.models.resp;

import java.util.List;

/**
 * @author ssituk
 */
public class KrakenResponse<T> {
    private List<String> error;
    private T result;

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
