package affichage;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;

import java.awt.Color;

public class ClientMain {
    public static void main(String[] args) {
       
        try {
            //System.out.println(InetAddress.getByName("0.0.0.0/0.0.0.0"));
            Socket theSocket = new Socket(InetAddress.getLocalHost(),4567);
            Robot robot = new Robot();
            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
      
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle(dim);
            while (true){
                BufferedImage image = robot.createScreenCapture(rec);
                OutputStream ois = theSocket.getOutputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image,"jpeg",baos);
                byte[] bytes = baos.toByteArray();
                System.out.println(bytes.length);
                ois.write(bytes);
                Thread.sleep(1);

            }
            // = ImageIO.read(new File("E:/S3/ProgSys/chat2/Client/Capture.jpeg"));
        //     JFrame frame = new JFrame();
        //     frame.setSize(1000,1000);
        //     frame.setVisible(true);
        //     JPanel panel = new JPanel();
        //     panel.setBackground(Color.BLACK);
        //     //panel.setSize(400,400);

        //     frame.add(panel);

 
        //     Graphics g = panel.getGraphics();
        //     g.setColor(Color.WHITE);
        //     g.drawOval(200,200,200,200);
        //     g.fillOval(200,200,200,200);
        //     System.out.println(g);
        //    // panel.paint(g);
        //     panel.paint(g);
            
      
            
                // String theLine ="";
                 //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                // while (true) {
                // theLine = input.readLine();
                // OutputStream ois = theSocket.getOutputStream();
                // ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // ImageIO.write(image,"jpeg",baos);
                // byte[] bytes = baos.toByteArray();
                // System.out.println(bytes.length);
                // ois.write(bytes);
                // ois.close();
                // if (theLine.equals(".")){
                //     break;
                // } 
                //System.out.println(theInputStream.readLine());
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception en){
            en.printStackTrace();
        }
    }    
}