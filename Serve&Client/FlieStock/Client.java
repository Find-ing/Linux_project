
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

        String path = "D:\\图片\\Saved Pictures\\58.jpg";
//        path = java.net.URLDecoder.decode(path, StandardCharsets.UTF_8);
        FileInputStream fin = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fin.read(bytes)) != -1){
             oup.write(bytes, 0, len);
        }
        socket.shutdownOutput();

        //获取返回的内容

        InputStream inp = socket.getInputStream();
        while ((len = inp.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }

        fin.close();
        socket.close();
    }
}
