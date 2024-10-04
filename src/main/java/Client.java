import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {

        try {
            Socket client = new Socket("netology.homework", Server.PORT);
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Клиент Павла стартовал");

            writer.println("Привет");
            String message = reader.readLine();
            System.out.println("Сервер прислал: " + message);

            message = reader.readLine();
            System.out.println("Сервер прислал: " + message);
            writer.println("Павел");

            message = reader.readLine();
            System.out.println("Сервер прислал: " + message);
            writer.println("Внучков");

            message = reader.readLine();
            System.out.println("Сервер прислал: " + message);
            writer.println(39);

            String result;
            while ((result = reader.readLine()) != null) {
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
