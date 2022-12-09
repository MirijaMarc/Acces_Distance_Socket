package event;

import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;


public class SendEcran extends Thread{
    Socket socket;
    Robot robot;

    public SendEcran(Socket c){
        try {
            socket =c;
            robot = new Robot();
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void run(){
        try {
            // GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle(dim);
            OutputStream ois = socket.getOutputStream();
            while (true){
                BufferedImage image = robot.createScreenCapture(rec);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image,"png",baos);
                byte[] size =ByteBuffer.allocate(4).putInt(baos.size()).array();
                ois.write(size);
                ois.write(baos.toByteArray());
                ois.flush();
                Thread.sleep(4);
            }           
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception en){
            en.printStackTrace();
        }
    }

    

}