package affichage;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.net.*;
import event.*;

public class Fenetre extends JFrame {
    Canvas cpanel;
    BufferedImage img;
    BufferStrategy bs;
    Graphics g;


    public Fenetre(Socket s){
        cpanel = new Canvas();
        cpanel.addMouseListener(new SendEvent(s));
        cpanel.addKeyListener(new SendEvent(s));
        cpanel.addMouseMotionListener(new SendEvent(s));
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.add(cpanel);
        cpanel.createBufferStrategy(3);
        bs = cpanel.getBufferStrategy();
        g = bs.getDrawGraphics();
    }


    public Canvas getCpanel() {
        return cpanel;
    }

    public BufferedImage getImg() {
        return img;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public Graphics getG() {
        return g;
    }

    public void setCpanel(Canvas cpanel) {
        this.cpanel = cpanel;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public void update(){
        g.drawImage(getImg(), 0, 0,img.getWidth(),img.getHeight(), null);
        bs.show();
    }
    

    


}
