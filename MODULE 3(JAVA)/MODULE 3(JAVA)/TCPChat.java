import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Run as (server/client): ");
        String mode = scanner.nextLine();
        if (mode.equalsIgnoreCase("server")) {
            runServer();
        } else if (mode.equalsIgnoreCase("client")) {
            runClient();
        } else {
            System.out.println("Invalid mode.");
        }
    }
    public static void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");
            new Thread(() -> readMessages(socket)).start();
            new Thread(() -> writeMessages(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void runClient() {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");
            new Thread(() -> readMessages(socket)).start();
            new Thread(() -> writeMessages(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readMessages(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("\nReceived: " + message);
                System.out.print("You: ");
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
  }
    }
    public static void writeMessages(Socket socket) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.print("You: ");
                msg = scanner.nextLine();
                writer.println(msg);
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
        }
    }
}
