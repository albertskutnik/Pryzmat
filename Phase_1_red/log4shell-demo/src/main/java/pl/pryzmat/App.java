package pl.pryzmat;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    private static final String documents =
        "[{\"name\":\"Anna kol\",\"email\":\"anna.kossd@example.test\",\"department\":\"Ksiegowosc\"},"
        + "{\"name\":\"Piotr sdasda\",\"email\":\"piotr.sdasda@example.test\",\"department\":\"IT\"},"
        + "{\"name\":\"Marta Wasdasda\",\"email\":\"marta.asddsa@example.test\",\"department\":\"HR\"}]";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", App::handleRequest);
        server.start();
        logger.info("Serwer dokumentow dziala na porcie 8080");
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getRawQuery();
        String decodedQuery = query == null ? "brak" : URLDecoder.decode(query, StandardCharsets.UTF_8.name());

        logger.info("Odebrano zapytanie: " + decodedQuery);

        String response = "{\"documents\":" + documents + "}";
        byte[] body = response.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, body.length);
        try (OutputStream output = exchange.getResponseBody()) {
            output.write(body);
        }
    }
}
