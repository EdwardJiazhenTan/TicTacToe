import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class draw extends JPanel {


    private class Effect implements MouseListener {

        Effect(){
            addMouseListener(this);
            setLayout(null);
            setVisible(true);
        }
        public void mouseClicked(MouseEvent e) {

            Graphics g = getGraphics();
            g.drawOval(e.getX(),e.getY(),100,100);
            g.setColor(Color.GREEN);
            System.out.println("click");
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.drawOval(20,20,100,100);
    }

}
