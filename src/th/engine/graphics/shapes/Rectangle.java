package th.engine.graphics.shapes;

import th.engine.Graphics;
import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle extends Shape {

    protected float mWidth;
    protected float mHeight;

    public Rectangle(float width, float height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void draw(Graphics g) {
        glBegin(GL_QUADS);
        glVertex2f(mXPos, mYPos);
        glVertex2f(mXPos + mWidth, mYPos);
        glVertex2f(mXPos + mWidth, mYPos + mHeight);
        glVertex2f(mXPos, mYPos + mHeight);
        glEnd();
    }
}

