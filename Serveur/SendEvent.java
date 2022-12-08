package event;

import java.io.DataOutputStream;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class SendEvent implements MouseMotionListener, MouseListener,KeyListener {
    Socket sc;
    DataOutputStream dos;

    public SendEvent(Socket s){
        try {
            sc = s;
            dos =new DataOutputStream(sc.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseDragged(MouseEvent e){

    }
    public void	mouseMoved(MouseEvent e){
        try {
            dos.writeInt(1);
            dos.writeInt(e.getX());
            dos.writeInt(e.getY());
            dos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }
   
    public void mouseExited(MouseEvent e){

    }
   
    public void mousePressed(MouseEvent e){
        try {
            dos.writeInt(2);
            int bouton =16;
            if (e.getButton()==MouseEvent.BUTTON3){
                bouton=4;
            }
            dos.writeInt(bouton);
            dos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mouseReleased(MouseEvent e){
        try {
            dos.writeInt(3);
            int bouton =16;
            if (e.getButton()==MouseEvent.BUTTON3){
                bouton=4;
            }
            dos.writeInt(bouton);
            dos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void keyPressed(KeyEvent e){
        try {
            dos.writeInt(4);
            dos.writeInt(e.getKeyCode());
            dos.flush();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }






}
