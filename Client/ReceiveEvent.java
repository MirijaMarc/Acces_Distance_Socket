package event;

import java.io.DataInputStream;
import java.net.Socket;
import java.awt.*;

public class ReceiveEvent extends Thread{
    Socket socket;
    Robot r;
    DataInputStream dis;

    public ReceiveEvent(Socket s){
        try {
            r = new Robot();
            socket = s;
            dis = new DataInputStream(socket.getInputStream());
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void run(){
        System.out.println("hello");
        try {
            while (true){
                
                int action = dis.readInt();
                System.out.println(action);
                switch (action) {
                    case 1:
                        r.mouseMove(dis.readInt(),dis.readInt());
                        break;
                    case 2:
                        r.mousePress(dis.readInt());
                        break;
                    case 3:
                        r.mouseRelease(dis.readInt());
                        break;
                    case 4:
                        r.keyPress(dis.readInt());
                        break;
                    case 5:
                        r.keyPress(dis.readInt());
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}