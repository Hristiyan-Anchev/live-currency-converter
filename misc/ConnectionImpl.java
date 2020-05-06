package misc;

import interfaces.Connection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionImpl implements Connection {
    private final String DEFAULT_URL = "https://api.exchangeratesapi.io/latest";
    private URL destinationURL;
    private HttpURLConnection connection;


    public ConnectionImpl()
            throws IOException {
        destinationURL = new URL(DEFAULT_URL);
    }

    public void establishConnectionToDestination(String... baseCurrency) throws IOException {
        //open HTTP connection to latest exchange rates quoted against default currency(EURO)
        if (baseCurrency.length != 0) {
            this.destinationURL = new URL(DEFAULT_URL + String.format("?base=%s", baseCurrency[0].toUpperCase()));

        }

        connection = (HttpURLConnection) this.destinationURL.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
    }

    public void closeConnection() {
        this.connection.disconnect();
    }

    public HttpURLConnection getConnection() {
        return connection;
    }






}
