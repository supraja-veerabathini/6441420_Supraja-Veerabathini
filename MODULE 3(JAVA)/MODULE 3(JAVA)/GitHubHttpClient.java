import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import com.google.gson.*;
public class GitHubHttpClient {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .header("User-Agent", "JavaHttpClient")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Raw Response Body:\n" + response.body());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            System.out.println("\nParsed Info:");
            System.out.println("Login: " + json.get("login").getAsString());
            System.out.println("Name: " + json.get("name").getAsString());
            System.out.println("Public Repos: " + json.get("public_repos").getAsInt());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }   }
