
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(9890);
        Socket socket = serversocket.accept();
        InputStream inp = socket.getInputStream();

        String path = "D:\\AAATEMP\\Java_File";
        path = java.net.URLDecoder.decode(path, StandardCharsets.UTF_8);
        File file = new File(path);
        assert file.exists() || file.mkdirs();

        byte[] bytes = new byte[1024];
        FileOutputStream fo = new FileOutputStream(file + "\\stock.java");

        int len = 0;
        while ((len = inp.read(bytes)) != -1){
            fo.write(bytes, 0, len);
        }

        socket.getOutputStream().write("成功".getBytes(StandardCharsets.UTF_8));

        serversocket.close();
        socket.close();
        fo.close();

    }
}
