/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package panelLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author fifin
 */
public class panelLogin extends JPanel {
    private Image img;
    public panelLogin(){
        img=new ImageIcon(getClass().getResource("/img/emptyLogin.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g.create();
        gd.drawImage(img, 0, 0,getWidth(),getHeight(), null);
        gd.dispose();
    }
    
}
