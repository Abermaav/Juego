import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Juego extends JPanel {
    public static Boolean HaChocado = false;
    Piedras rocas = new Piedras(this);
    Insecto bicho = new Insecto();

    public Juego() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                bicho.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        URL imageUrl = getClass().getResource("/tela.png");
        if (imageUrl != null) {
            ImageIcon tela = new ImageIcon(imageUrl);
            g.drawImage(tela.getImage(), 0, 0, 700, 700, null);
        } else {
            System.err.println("Image not found: /tela.png");
        }

        Font score = new Font("Arial", Font.BOLD, 25);
        g.setFont(score);
        g.setColor(new Color(255, 255, 255));
        g.drawString("Puntaje: " + rocas.getPuntos(), 520, 50);

        bicho.paint(g);
        rocas.paint(g);
        rocas.mover();
    }
}