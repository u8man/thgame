package th.engine.graphics.shapes;

import org.lwjgl.opengl.GL11;
import th.engine.graphics.Shape;

public class Triangle extends Shape {

    private float[] mA, mB, mC;

    public Triangle(float[] a, float[] b, float[] c) {
        super(0, 0);
        mA = a;
        mB = b;
        mC = c;
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_TRIANGLES);
        GL11.glVertex2f(mA[0] + getPosX(), mA[1] + getPosY());
        GL11.glVertex2f(mB[0] + getPosX(), mB[1] + getPosY());
        GL11.glVertex2f(mC[0] + getPosX(), mC[1] + getPosY());
        GL11.glEnd();
    }
}
