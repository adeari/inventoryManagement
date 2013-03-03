/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelLayout;

/**
 *
 * @author fifin
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class txAreaDescription extends  JTextArea {

    private Paint paint;


    private Paint glass;

    public txAreaDescription() {
        
        setRows(4);
        
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
        public void keyReleased(java.awt.event.KeyEvent evt) {
            setFokus();
        }
    });
        

        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                setFokus();
            }

            @Override
            public void focusLost(FocusEvent e) {
                setFokus();
            }
        });
    }


    public void setFokus() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();
        if (getText().equalsIgnoreCase("Description")) {
            setForeground(Color.GRAY);
        } else {
            setForeground(Color.BLACK);
        }
        super.paintComponent(g);
        gd.dispose();
    }
}
