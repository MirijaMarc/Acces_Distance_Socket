package affichage;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;
import java.io.*;

public class ClientPanel extends JPanel {
    BufferedImage img;

    public ClientPanel(){
        this.setSize(new Dimension(1000,600));
        // setImg(img);
    }
    public ClientPanel(BufferedImage img){
        setImg(img);
    }


    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }


    public void paint(Graphics g){
        try {
           // BufferedImage image= ImageIO.read(new File("E:/S3/ProgSys/chat2/Client/Capture.PNG"));
            super.paint(g);
            //g.setColor(Color.BLACK);
            // g.drawOval(200,200,200,200);
            // g.fillOval(200,200,200,200);
            if (this.getImg()!=null){
                g.drawImage(this.getImg(), 0, 0,this);  
                this.setImg(null);
            }
             Thread.sleep(1);
            // repaint();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
