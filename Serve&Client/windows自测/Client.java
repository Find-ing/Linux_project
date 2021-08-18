
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9890);
        // STOPSHIP: 2021/5/13
        OutputStream oup = socket.getOutputStream();

        String path = "F:\\JavaFX\\src\\FX1\\fx_01.java";

//        path = java.net.URLDecoder.decode(path, StandardCharsets.UTF_8);
        FileInputStream fin = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fin.read(bytes)) != -1){
             oup.write(bytes, 0, len);
        }
        socket.shutdownOutput();


        InputStream inp = socket.getInputStream();
        while ((len = inp.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }

        fin.close();
        socket.close();
    }
}
