package th.engine.graphics.shapes;

import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Rectangle extends Shape {

    private float mWidth;
    private float mHeight;

    public Rectangle(float width, float height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void draw() {
        glBegin(GL_QUADS);
        glVertex2f(getXPos(), getYPos());
        glVertex2f(getXPos() + mWidth, getYPos());
        glVertex2f(getXPos() + mWidth, getYPos() + mHeight);
        glVertex2f(getXPos(), getYPos() + mHeight);
        glEnd();
    }
}

