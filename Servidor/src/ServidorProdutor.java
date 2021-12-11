import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorProdutor extends Thread {
    private static MensagemBuffer B;
    Socket socket;
    PrintWriter pw;

    public ServidorProdutor(MensagemBuffer b, Socket socket) {
        super();
        B = b;
        this.socket = socket;
        try {
            synchronized (this.socket) {
                pw = new PrintWriter(this.socket.getOutputStream());
            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        super.start();
    }

    public static void enviarMensagem(String mensagem) {
        synchronized (B) {
            B.put(mensagem);
        }
    }

    public void run() {
        while (true) {
            synchronized (B) {
                pw.println(B.get());
                pw.flush();
            }
        }
    }
}
