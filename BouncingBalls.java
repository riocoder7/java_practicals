import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BouncingBalls extends JPanel implements Runnable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int NUM_BALLS = 5;
    private List<Ball> balls;

    public BouncingBalls() {
        balls = new ArrayList<>();
        // Create and add random balls
        Random random = new Random();
        for (int i = 0; i < NUM_BALLS; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int xSpeed = random.nextInt(5) + 1;
            int ySpeed = random.nextInt(5) + 1;
            Color color = new Color(random.nextInt(256),
                    random.nextInt(256), random.nextInt(256));
            balls.add(new Ball(x, y, xSpeed, ySpeed, color));
        }
    }

    @Override
    public void run() {
        while (true) {
            for (Ball ball : balls) {
                ball.move();
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("5 Colors Bouncing Balls");
        BouncingBalls bouncingBalls = new BouncingBalls();
        frame.add(bouncingBalls);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Thread thread = new Thread(bouncingBalls);
        thread.start();
    }
}

class Ball {
    private int x, y, xSpeed, ySpeed;
    private Color color;

    public Ball(int x, int y, int xSpeed, int ySpeed, Color color) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > BouncingBalls.WIDTH) {
            xSpeed = -xSpeed;
        }

        if (y < 0 || y > BouncingBalls.HEIGHT) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20); // Assuming a ball is represented as an oval
    }
}
