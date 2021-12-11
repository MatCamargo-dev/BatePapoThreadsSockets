import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteProdutor extends Thread {

    private static MensagemBuffer B;
    Socket ss;
    PrintWriter pw;

    public ClienteProdutor(MensagemBuffer b, Socket ss) {
        super();
        B = b;
        this.ss = ss;
        try {
            pw = new PrintWriter(this.ss.getOutputStream());
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
