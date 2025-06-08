package web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpStatusChecker {
    public String getStatusImage(int code) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://http.cat/" + code;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                return null;
            } else return "https://http.cat/" + code + ".jpg";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
