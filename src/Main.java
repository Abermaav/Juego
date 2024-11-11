import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame miVentana = new JFrame("Running Spider");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(700, 700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);

        while (true) {
            if (Piedras.nivel == 5) {
                int reiniciarJuego = JOptionPane.showConfirmDialog(null, "Has Ganado!!! ¿Quieres jugar de nuevo?", "Fin del Juego", JOptionPane.YES_NO_OPTION);
                if (reiniciarJuego == JOptionPane.YES_OPTION) {
                    reiniciarValores();
                } else {
                    System.exit(0);
                }
            }

            if (Juego.HaChocado) {
                int reiniciarJuego = JOptionPane.showConfirmDialog(null, "Has Perdido!!! ¿Quieres jugar de nuevo?", "Fin del Juego", JOptionPane.YES_NO_OPTION);
                if (reiniciarJuego == JOptionPane.YES_OPTION) {
                    reiniciarValores();
                } else {
                    System.exit(0);
                }
            }

            game.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reiniciarValores() {
        Piedras.xRoca1 = 600;
        Piedras.yRoca1 = 700;
        Piedras.xRoca2 = 700;
        Piedras.yRoca2 = 100;
        Piedras.xRoca3 = -20;
        Piedras.yRoca3 = 600;
        Piedras.xRoca4 = 300;
        Piedras.yRoca4 = -20;
        Insecto.x = 10;
        Insecto.y = 10;
        Piedras.puntos = 0;
        Piedras.nivel = 1;
        Juego.HaChocado = false;
    }
}