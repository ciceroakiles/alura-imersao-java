import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("API_KEY:");

        String url = "https://imdb-api.com/en/API/Top250Movies/";
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(url + sc.nextLine()
            )).build();
        String json = HttpClient.newHttpClient()
            .send(request, HttpResponse.BodyHandlers.ofString())
            .body();

        System.out.println(json);
    }
}
