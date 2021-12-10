import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    Socket socket;
    ServerSocket serverSocket;
    int porta;

    public ServidorSocket(int porta) {
        this.porta = porta;
    }

    public void conect() {
        try {

            serverSocket = new ServerSocket(porta);
            socket = serverSocket.accept();

        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
