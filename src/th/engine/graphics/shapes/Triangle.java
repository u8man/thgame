package th.engine.graphics.shapes;

import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Triangle extends Shape {

    private float mWidth;
    private float mHeight;

    public Triangle(float width, float height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void draw() {
        glBegin(GL_TRIANGLES);
        glVertex2f(mXPos + (mWidth / 2), mYPos);
        glVertex2f(mXPos, mYPos + mHeight);
        glVertex2f(mXPos + mWidth, mYPos + mHeight);
        glEnd();
    }
}

