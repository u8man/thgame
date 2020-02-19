package th.engine.graphics.shapes;

import org.lwjgl.opengl.GL11;
import th.engine.graphics.Shape;

public class Line extends Shape {
    private float[] mB;
    public Line(float[] a, float[] b) {
        super(a[0], a[1]);
        mB = b;
    }

    @Override
    public void draw() {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(mPosX, mPosY);
        GL11.glVertex2f(mB[0], mB[1]);
        GL11.glEnd();
    }
}
