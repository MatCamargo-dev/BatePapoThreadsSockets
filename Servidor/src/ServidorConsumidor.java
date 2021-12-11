import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServidorConsumidor extends Thread {
    Socket socket;
    MensagemBuffer B;
    BufferedReader lei;

    public ServidorConsumidor(MensagemBuffer b, Socket socket) {
        super();
        B = b;
        this.socket = socket;
        try {
            lei = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        super.start();
    }

    public void run() {
        String mensagem;
        while (true) {
            try {
                mensagem = lei.readLine();
                B.put(mensagem);
                //System.out.println("Valor Consumido: "+mensagem);
            } catch (IOException ex) {
                ex.getStackTrace();
            }

        }
    }
}
