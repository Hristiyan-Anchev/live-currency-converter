package interfaces;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface Connection {
    void establishConnectionToDestination(String... baseCurrency) throws IOException;
    void closeConnection();
    HttpURLConnection getConnection();

}
