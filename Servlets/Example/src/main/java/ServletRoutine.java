import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ServletRoutine {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        URLConnection connection = new URL("http://localhost:8080/thread").openConnection();
                        connection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();
        }
    }
}
