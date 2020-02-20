package th.engine.graphics.shapes;

import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Line extends Shape {

    private float[] mB;

    public Line(float[] a, float[] b) {
        mB = b;
    }

    @Override
    public void draw() {
        glBegin(GL_LINES);
        glVertex2f(mXPos, mYPos);
        glVertex2f(mB[0], mB[1]);
        glEnd();
    }
}

