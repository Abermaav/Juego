import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.awt.geom.*;
import java.net.URL;

public class Insecto implements KeyListener {
    public static int x = 10, y = 10;

    public void paint(Graphics g) {
        URL hoyoUrl = getClass().getResource("src/hoyo.png");
        if (hoyoUrl != null) {
            ImageIcon hoyo = new ImageIcon(hoyoUrl);
            g.drawImage(hoyo.getImage(), 500, 500, 150, 150, null);
        } else {
            System.err.println("Image not found: /hoyo.png");
        }

        URL arañaUrl = getClass().getResource("src/araña.png");
        if (arañaUrl != null) {
            ImageIcon araña = new ImageIcon(arañaUrl);
            g.drawImage(araña.getImage(), x, y, 100, 100, null);
        } else {
            System.err.println("Image not found: /araña.png");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x = x + 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x = x - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y = y - 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y = y + 10;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public Ellipse2D getBoundsBicho() {
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }

    public boolean llegaFinal() {
        Rectangle cuadrado = new Rectangle(520, 520, 110, 110);
        Area cuadradoArea = new Area(cuadrado);
        return cuadradoArea.contains(getBoundsBicho().getBounds());
    }
}