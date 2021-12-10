public class PrincipalServidor {
    ServidorProdutor servidorProdutor = null;
    ServidorConsumidor servidorConsumidor = null;

    MensagemBuffer mensagensServidorEnvio = new MensagemBuffer(10);
    MensagemBuffer mensagensServidorRecepcao = new MensagemBuffer(10);
    ServidorSocket servidorSocket = new ServidorSocket(8889);
    servidorSocket.conect();

    if(servidorSocket.getSocket()!=null)

    {
        servidorProdutor = new ServidorProdutor(mensagensServidorEnvio, servidorSocket.getSocket());
        servidorConsumidor = new ServidorConsumidor(mensagensServidorRecepcao, servidorSocket.getSocket());
    }
}
