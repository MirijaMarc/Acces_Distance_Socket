package moteur;
import java.net.*;
import event.*;

public class Client extends Thread{
    Socket socket;

    public Client(Socket s){
        socket=s;
    }

    public void run(){
        SendEcran sendE = new SendEcran(getSocket());
        ReceiveEvent recE = new ReceiveEvent(getSocket());
    }

    public Socket getSocket() {
        return socket;
    }
    
    
}
