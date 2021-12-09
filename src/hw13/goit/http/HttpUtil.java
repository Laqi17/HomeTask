package hw13.goit.http;

import hw13.goit.user.Post;
import hw13.goit.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hw13.goit.user.Comments;
import hw13.goit.user.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpUtil {
    private static HttpClient CLIENT = HttpClient.newHttpClient();
    private static Gson GSON = new Gson();

    public static void sendGet(String uri) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }

    public static User sendPost(String uri, User user) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);

    }

    public static User sendGetByID(String uri, int id) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        final User user = GSON.fromJson(response.body(), User.class);

        return user;
    }

    public static void removeById(String uri, int id) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    public static User put(String uri, int id, User user) throws IOException, InterruptedException {
        final String putBody = GSON.toJson(user);
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "/" + id))
                .PUT(HttpRequest.BodyPublishers.ofString(putBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static void sendGetByUsername(String uri, String username) throws IOException, InterruptedException {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + "?username=" + username))
                .header("Content-type", "application/json")
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }

    public static void getCommentsByUserID(String postUrl, String commentURL, int userId) throws IOException, InterruptedException {

        HttpRequest requestPosts = HttpRequest.newBuilder()
                .uri(URI.create(postUrl + "/" + userId + "/posts"))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response_posts = CLIENT.send(requestPosts, HttpResponse.BodyHandlers.ofString());
        List<Post> posts = GSON.fromJson(response_posts.body(), new TypeToken<List<Post>>() {
        }.getType());

        posts.sort((a, b) -> b.getId() - a.getId());
        int postId = posts.get(0).getId();

        HttpRequest requestComments = HttpRequest.newBuilder()
                .uri(URI.create(commentURL + "?postId=" + postId))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response_comments = CLIENT.send(requestComments, HttpResponse.BodyHandlers.ofString());
        List<hw13.goit.user.Comments> comments = GSON.fromJson(response_comments.body(), new TypeToken<List<Comments>>() {
        }.getType());

        String outJSON = "src\\hw13\\user-" + userId + "-post-" + postId + "-comments.json";
        File file = new File(outJSON);

        checkFile(file);
        writeFile(outJSON, comments);

        System.out.println("New file created? - " + file.exists() + "\nFile path - " +file.getPath());

    }

    public static void checkFile(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void writeFile(String path, List lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(lines, writer);
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public static List<hw13.goit.user.Task> getTodos(String url, int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id + "/todos?completed=false"))
                .GET()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<hw13.goit.user.Task> tasks = GSON.fromJson(response.body(), new TypeToken<List<Task>>() {
        }.getType());
        return tasks;
    }
}

