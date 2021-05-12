package Server_Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8388);
        Socket socket = server.accept();
        InputStream inp = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inp.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes, 0, len, StandardCharsets.UTF_8));
        OutputStream oup = socket.getOutputStream();
        oup.write("hello".getBytes(StandardCharsets.UTF_8));
        server.close();
        socket.close();
    }
}
