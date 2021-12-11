import java.util.Scanner;

public class PrincipalCliente {

    public static void main(String[] args) {
        Scanner mensagem = new Scanner(System.in);
        Scanner mensagem2 = new Scanner(System.in);
        String msg = "";
        String nome = "";

        ClienteProdutor clienteProdutor = null;
        ClienteConsumidor clienteConsumidor;

        MensagemBuffer mensagensClienteEnvio = new MensagemBuffer(10);
        MensagemBuffer mensagensClienteRecepcao = new MensagemBuffer(10);
        ClienteSocket clienteSocket = new ClienteSocket("127.0.0.1", 8889);

        clienteSocket.conect();

        if (clienteSocket.getSocket() != null) {
            clienteConsumidor = new ClienteConsumidor(mensagensClienteRecepcao, clienteSocket.getSocket());
            clienteProdutor = new ClienteProdutor(mensagensClienteEnvio, clienteSocket.getSocket());

        }

        try {
            while (true) {
                System.out.println("Quem quer enviar a mensagem: ");
                nome = mensagem.nextLine();

                System.out.println("Mensagem: ");
                msg = mensagem2.nextLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClienteProdutor.enviarMensagem("Mensagem enviado por: " + nome + "\nMensagem pelo cliente: " + msg);
        System.out.println(mensagensClienteRecepcao.get());
    }
}
