package web;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        int code = 0;
        System.out.println("Enter code ");
        while (true) {
            String line = scanner.nextLine();
            try {
                code = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
                continue;
            }
            String url = HttpStatusChecker.getStatusImage(code);
            if (url == null) {
                System.out.println("There is not image for HTTP status " + code + ". Try again");
            } else {
                HttpStatusImageDownloader.downloadStatusImage(code);
                System.out.println("Image downloaded");
                break;
            }
        }
    }
}

