import java.util.Scanner;

public class PrincipalCliente {
    Scanner mensagem;
    String msg;

    ClienteProdutor clienteProdutor = null;
    Servidor.ClienteConsumidor clienteConsumidor;

    MensagemBuffer mensagensClienteEnvio = new MensagemBuffer(10);
    MensagemBuffer mensagensClienteRecepcao = new MensagemBuffer(10);
    ClienteSocket clienteSocket = new ClienteSocket("127.0.0.1", 8889);

    clienteSocket.conect();

    if(clienteSocket.getSocket()!=null)

    {
        clienteConsumidor = new Servidor.ClienteConsumidor(mensagensClienteRecepcao, clienteSocket.getSocket());
        clienteProdutor = new ClienteProdutor(mensagensClienteEnvio, clienteSocket.getSocket());
    }

    try

    {
        while (true) {
            System.out.println("Mensagem: ");
            msg = mensagem.nextline();

            ClienteProdutor.enviarMensagem("Mensagem pelo cliente: " + msg);
            System.out.println(mensagensClienteRecepcao.get());
        }
    }catch(
    Exception e)

    {
        e.printStackTrace();
    }


}
