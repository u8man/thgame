package th.engine.graphics.shapes;

import th.engine.Log;
import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Shape {

    private float mRadius;

    public Circle(float radius) {
        mRadius = radius;
    }

    @Override
    public void draw() {
        float step = 3.0f;

        glBegin(GL_POLYGON);

        for (float a = 0.0f; a < 360.0; a += step) {
            float theta = 2.0f * (float) Math.PI * a / 180.0f;
            glVertex2f(mRadius * (float) Math.cos(theta) + (mXPos + mRadius),
                    mRadius * (float) Math.sin(theta) + (mYPos + mRadius));
        }

        glEnd();
    }
}

