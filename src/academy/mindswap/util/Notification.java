package academy.mindswap.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// curl logic from https://stackoverflow.com/a/62456780
public class Notification {

    public static void send(String[] commands) {
        sendAux(commands);
    }

    public static void send(String url, String title, String message) {
        String[] commands = new String[]{"curl", "-H", "t: " + title, "-d", message, url};
        sendAux(commands);
    }

    public static void send(String title, String message) {
        String url = "https://ntfy.ducknexus.com/javaoutputs";
        String[] commands = new String[]{"curl", "-H", "t: " + title, "-d", message, url};
        sendAux(commands);
    }

    public static void send(String message) {
        String url = "https://ntfy.ducknexus.com/javaoutputs";
        String title = "Sent from Java project";
        String[] commands = new String[]{"curl", "-H", "t: " + title, "-d", message, url};
        sendAux(commands);
    }

    private static void sendAux(String[] commands) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                response.concat(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
