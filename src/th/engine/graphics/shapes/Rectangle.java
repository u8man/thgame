package th.engine.graphics.shapes;

import org.lwjgl.opengl.GL11;
import th.engine.graphics.Shape;

public class Rectangle extends Shape {

    private float mWidth;
    private float mHeight;

    public Rectangle(float width, float height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(0.0f + getPosX(), 0.0f + getPosY());
        GL11.glVertex2f(mWidth + getPosX(), 0.0f + getPosY());
        GL11.glVertex2f(mWidth + getPosX(), mHeight + getPosY());
        GL11.glVertex2f(0.0f + getPosX(), mHeight + getPosY());
        GL11.glEnd();
    }
}

