import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class WebSokcet {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        ServerSocket serverSocket = new ServerSocket(5012);
        try{
            System.out.println("server started at lovalhost at portt 5012");

            Socket client = serverSocket.accept();
            System.out.println(client.getInetAddress() + " connected");

        }catch (IOException e)
        {}

    }
}
