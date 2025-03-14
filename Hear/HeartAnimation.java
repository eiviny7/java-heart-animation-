import java.awt.*;
import javax.swing.*;

public class HeartAnimation extends JPanel {

    private int lines = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Animation");
        HeartAnimation heart = new HeartAnimation();

        frame.add(heart);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            heart.repaint();
            heart.lines++;
            if (heart.lines > 100) heart.lines = 0;
            try {
                Thread.sle(80); // Velocidade da animação
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 3;

        for (int i = 0; i < lines; i++) {
            double t = Math.toRadians(i * 4); // Angulo
            int x = (int) (16 * Math.pow(Math.sin(t), 3) * 20) + centerX;
            int y = (int) (- (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)) * 20) + centerY;

            if (i < 50) {
                g.setColor(Color.RED); // Primeira metade
            } else {
                g.setColor(Color.pink); // Segunda metade
            }
    

            g.drawLine(centerX, centerY + 100, x, y);
        }
        g.setColor(Color.BLACK); // Cor do texto
        g.setFont(new Font("Arial", Font.BOLD, 28)); // Fonte personalizada
        g.drawString("Eu te amo <3", centerX - 70, centerY + 350); // Texto centralizado 
    }
}
