package aplicaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SerpienteVentana extends JFrame {

    public SerpienteVentana() {
        setTitle("Serpiente Nokia");
        setSize(400, 440); // espacio para puntaje
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);
        addKeyListener(panel); // teclas capturadas por panel
        setVisible(true);
    }

    // ----------------- Panel de juego -----------------
    private class GamePanel extends JPanel implements KeyListener {
        private final int TILE_SIZE = 20;
        private final int WIDTH = 400;
        private final int HEIGHT = 400;

        private ArrayList<Point> snake;
        private Point fruta;
        private char direccion = 'R';
        private boolean gameOver = false;
        private int puntaje = 0;

        public GamePanel() {
            setBackground(Color.BLACK);
            snake = new ArrayList<>();
            snake.add(new Point(5,5));
            generarFruta();

            Timer timer = new Timer(200, e -> {
                mover();
                repaint();
            });
            timer.start();
        }

        private void generarFruta() {
            Random r = new Random();
            int x = r.nextInt(WIDTH / TILE_SIZE);
            int y = r.nextInt(HEIGHT / TILE_SIZE);
            fruta = new Point(x, y);
        }

        private void mover() {
            if(gameOver) return;

            Point cabeza = snake.get(0);
            Point nuevaCabeza = new Point(cabeza.x, cabeza.y);

            switch(direccion) {
                case 'R': nuevaCabeza.x++; break;
                case 'L': nuevaCabeza.x--; break;
                case 'U': nuevaCabeza.y--; break;
                case 'D': nuevaCabeza.y++; break;
            }

            // colisiones
            if(nuevaCabeza.x < 0 || nuevaCabeza.x >= WIDTH / TILE_SIZE
            || nuevaCabeza.y < 0 || nuevaCabeza.y >= HEIGHT / TILE_SIZE
            || snake.contains(nuevaCabeza)) {
                gameOver = true;
                return;
            }

            snake.add(0, nuevaCabeza);

            // comer fruta
            if(nuevaCabeza.equals(fruta)) {
                puntaje += 10;
                generarFruta();
            } else {
                snake.remove(snake.size()-1);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // cuadrícula estilo Nokia
            g.setColor(Color.DARK_GRAY);
            for(int x = 0; x < WIDTH; x += TILE_SIZE) {
                g.drawLine(x, 40, x, HEIGHT);
            }
            for(int y = 40; y < HEIGHT; y += TILE_SIZE) {
                g.drawLine(0, y, WIDTH, y);
            }

            // fruta
            g.setColor(Color.RED);
            g.fillRect(fruta.x * TILE_SIZE, fruta.y * TILE_SIZE + 40, TILE_SIZE, TILE_SIZE);

            // serpiente
            g.setColor(Color.GREEN);
            for(Point p : snake) {
                g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE + 40, TILE_SIZE, TILE_SIZE);
            }

            // puntaje
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("Puntaje: " + puntaje, 10, 30);

            // game over
            if(gameOver) {
                g.setFont(new Font("Arial", Font.BOLD, 36));
                g.setColor(Color.RED);
                g.drawString("GAME OVER", 80, HEIGHT/2);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            char nuevaDir = direccion;
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP: nuevaDir = 'U'; break;
                case KeyEvent.VK_DOWN: nuevaDir = 'D'; break;
                case KeyEvent.VK_LEFT: nuevaDir = 'L'; break;
                case KeyEvent.VK_RIGHT: nuevaDir = 'R'; break;
            }
            if((direccion == 'U' && nuevaDir != 'D') ||
               (direccion == 'D' && nuevaDir != 'U') ||
               (direccion == 'L' && nuevaDir != 'R') ||
               (direccion == 'R' && nuevaDir != 'L')) {
                direccion = nuevaDir;
            }
        }
        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
    }
}
