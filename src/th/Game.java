package th;

import org.lwjgl.opengl.GL11;
import th.engine.*;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Circle;
import th.engine.graphics.shapes.Rectangle;
import th.engine.graphics.shapes.Triangle;

public class Game extends Core {

    public static void main(String[] args) {
        new Game().run();
    }


    public Game() {
        super(360, 640, "TH Game 0.1.0", false, true);
    }

    @Override
    public void init() {
        setBackgroundColor(new Color(80, 140, 100));
    }

    @Override
    public void terminate() {
        //
    }

    @Override
    public void input(Input input) {
        //
    }

    @Override
    public void update(double delta) {
        //
    }

    @Override
    public void render(Graphics g) {
        //
        GL11.glColor4f(0.0f, 0.5f, 0.0f, 0.7f);
        float[] a = {0.0f, 0.0f};
        float[] b = {50.0f, -50.0f};
        float[] c = {100.0f, 0.0f};
        Triangle t = new Triangle(a, b, c);
        t.setPosX((float)mWindow.getWidth() / 2);
        t.setPosY((float)mWindow.getHeight() / 2);
        t.draw();
        t.setPosY((float)mWindow.getHeight() / 2 + 50);
        t.draw();
        t.setPosY((float)mWindow.getHeight() / 2 + 100);
        t.draw();
        GL11.glColor4f(0.5f, 0.5f, 0.0f, 0.3f);
        Rectangle r = new Rectangle(25.0f, 50.0f);
        r.setPosX((float)mWindow.getWidth() / 2 + 37.5f);
        r.setPosY((float)mWindow.getHeight() / 2 + 100);
        r.draw();
        GL11.glColor4f(0.0f, 0.0f, 1.0f, 0.5f);
        float[] center = {(float)mWindow.getWidth() / 2, (float)mWindow.getHeight() / 2};
        Circle circle = new Circle(10.0f);
        circle.setPosX((float)mWindow.getWidth() / 2);
        circle.setPosY((float)mWindow.getHeight() / 2);
        circle.draw();
    }
}

