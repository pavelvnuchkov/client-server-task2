import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                System.out.println("Подключение с новым клиентом!");
                StringBuffer buffer = new StringBuffer();
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = in.readLine();
                out.println(String.format("Привет, твой порт %d", clientSocket.getPort()));
                System.out.println("Клиент прислал - " + message);

                out.println("Пришли своё имя!");
                message = in.readLine();
                buffer.append("Клиент c порта: " + clientSocket.getPort());
                buffer.append("\nИмя: " + message);
                System.out.println("Клиент прислал - " + message);
                out.println("Пришли свою фамилию!");
                message = in.readLine();
                buffer.append("\nФамалия: " + message);
                System.out.println("Клиент прислал - " + message);
                out.println("Пришли свой возраст!");
                message = in.readLine();
                buffer.append("\nВозраст: " + message);
                System.out.println("Клиент прислал - " + message);
                out.println(buffer);
                System.out.println("Итог - " + buffer);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
