package web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HttpStatusImageDownloader {

    private HttpStatusImageDownloader() {

    }

    public static void downloadStatusImage(int code) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            File file = new File("cat-" + code + ".jpg");
            Files.copy(response.body().byteStream(), file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
