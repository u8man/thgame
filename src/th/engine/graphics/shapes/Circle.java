package th.engine.graphics.shapes;

import org.lwjgl.opengl.GL11;
import th.engine.graphics.Shape;

public class Circle extends Shape {

    float[] mCenter;
    float mRadius;

    public Circle(float radius) {
        super(0.0f, 0.0f);
        mRadius = radius;
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_POLYGON);
        int segments = 12;
        for (int i = 0; i < segments; i++) {
            GL11.glVertex2f((float)Math.sin((i / (float) segments) * Math.PI * 2) * mRadius + getPosX(), (float) Math.cos((i / (float) segments) * Math.PI * 2) * mRadius + getPosY());
        }
        GL11.glEnd();
    }
}