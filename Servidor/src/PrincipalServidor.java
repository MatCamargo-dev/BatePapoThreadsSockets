import java.util.Scanner;

public class PrincipalServidor {
    public static void main(String[] args) {
        Scanner mensagem = new Scanner(System.in);
        Scanner mensagem2 = new Scanner(System.in);
        String msg = "";
        String nome = "";

        ServidorProdutor servidorProdutor = null;
        ServidorConsumidor servidorConsumidor = null;

        MensagemBuffer mensagensServidorEnvio = new MensagemBuffer(10);
        MensagemBuffer mensagensServidorRecepcao = new MensagemBuffer(10);
        ServidorSocket servidorSocket = new ServidorSocket(8889);
        servidorSocket.conect();

        if (servidorSocket.getSocket() != null) {
            servidorProdutor = new ServidorProdutor(mensagensServidorEnvio, servidorSocket.getSocket());
            servidorConsumidor = new ServidorConsumidor(mensagensServidorRecepcao, servidorSocket.getSocket());
        }

        try {
            System.out.println(mensagensServidorRecepcao.get());
            System.out.println("Quem quer enviar a mensagem: ");
            nome = mensagem.nextLine();

            System.out.println("Mensagem: ");
            msg = mensagem2.nextLine();
            ServidorProdutor.enviarMensagem("Mensagem enviado por: " + nome + "\nMensagem pelo cliente: " + msg);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
