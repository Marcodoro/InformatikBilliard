import sum.kern.*;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Bildschirm screen;
    private Tastatur key;
    private Buntstift pen;
    private Maus mouse;
    private final int height = 720;
    private final int width = 1280;
    private Button tisch;
    private Button ball;
    private float dx;
    private float dy;
    private Boolean gedrueckt = false;

    public Game() {
        screen = new Bildschirm(width, height);
        key = new Tastatur();
        pen = new Buntstift();
        mouse = new Maus();
        tisch = new Button(100, 100, height - 200, width - 200, 0, pen);
        tisch.drawButton(pen);
        ball = new Button(width / 2, height / 2, 30, 30, 1 , pen);
    }
    public void start() {
        while (true) {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tisch.drawButton(pen);

            if (Math.abs(dx) > 0.1f || Math.abs(dy) > 0.1f) {
                ball.loeschen(pen);
                float setx = ball.getX() + dx;
                float setY = ball.getY() + dy;

                ball.setX((int)setx);
                ball.setY((int) setY);
                ball.drawCircle(pen, ball.getX(), ball.getY());
            }
            else {
                dx = 0;
                dy = 0;
                ball.drawCircle(pen, ball.getX(), ball.getY());
                float setx = ball.getX() + dx;
                ball.setX((int)setx);
            }
            if ((ball.getX() > width - 120) || (ball.getX() < 120)) {
                dx = -dx;
            }
            if ((ball.getY() > height - 120) || (ball.getY() < 120)) {
                dy = -dy;
            }

            if (mouse.istGedrueckt()) {
                int radius = ball.getSizeX();

                if (mouse.hPosition() >= ball.getX() - radius && mouse.hPosition() <= ball.getX() + radius) {
                    if (mouse.vPosition() >= ball.getY() - radius && mouse.vPosition() <= ball.getY() + radius) {
                        gedrueckt = true;
                    }
                }
            }
            dx = dx * 0.95f;
            dy = dy * 0.95f;
            if (!mouse.istGedrueckt() && gedrueckt == true) {
                gedrueckt = false;
                System.out.println(ball.getX() - mouse.hPosition());
                System.out.println(ball.getY() - mouse.vPosition());

                dx = (ball.getX() - mouse.hPosition()) * 0.2f;
                dy = (ball.getY() - mouse.vPosition()) * 0.2f;

            }
        }
    }
}
