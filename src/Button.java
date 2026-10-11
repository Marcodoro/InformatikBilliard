import sum.kern.*;

public class Button {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private int color;
    private String text;
    private int breite;

    public Button(int x, int y, int sizeY, int sizeX, int color, Buntstift pen) {
        this.x = x;
        this.y = y;
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.color = color;
    }
    public void drawButton(Buntstift pen) {
        pen.hoch();
        pen.setzeFarbe(this.color);
        pen.setzeLinienBreite(this.breite);
        pen.bewegeBis((double) this.x, (double) this.y);
        pen.zeichneRechteck(this.sizeX, this.sizeY);
    }
    public void drawCircle(Buntstift pen, int x, int y) {
        pen.normal();
        pen.hoch();
        pen.setzeLinienBreite(this.breite);
        pen.bewegeBis((double) this.x, (double) this.y);
        pen.zeichneKreis(sizeX);
    }
    public void loeschen(Buntstift pen) {
        pen.radiere();
        pen.hoch();
        pen.bewegeBis(this.x, this.y);
        pen.runter();
        pen.zeichneKreis(this.sizeX);
        pen.normal();
    }
    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getSizeX()  {
        return this.sizeX;
    }
    public int getSizeY() {
        return this.sizeY;
    }
    public void setX(int changeX) {
        this.x = changeX;
    }
    public void setY(int changeY) {
        this.y = changeY;
    }
    public String getText() {
        return this.text;
    }
}
