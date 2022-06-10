import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws Exception {
        int port = 8800;
        ServerSocket server = new ServerSocket(port);
        System.out.println("step1: socket bind: " + port);
        while (true) {
            Socket socket = server.accept();
            System.out.println("step2: accept port->" + socket.getPort());
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Server recv line:" + line);
                        out.println("Server recv:" + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
