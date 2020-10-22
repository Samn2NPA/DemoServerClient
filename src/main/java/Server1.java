import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import sun.net.httpserver.DefaultHttpServerProvider;

/**
 * Created by Phanh on 10/22/20.
 */
public class Server1 {

    private static final Vertx vertx = Vertx.vertx();

    public static void main(String[] args) {
        startServer1();
    }

    public static void startServer1() {
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            System.out.println("request: " + request.toString());

            // This handler gets called for each request that arrives on the server
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("Hello World!");
        });

        server.listen(8080);
    }

}