package th.engine.graphics.shapes;

import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

public class Circle extends Shape {

    protected float mRadius;
    protected float mStep;

    // Конструктор (1)
    public Circle(float radius) {
        this(radius, 10.0f);
    }

    // Конструктор (2)
    public Circle(float radius, float step) {
        mRadius = radius;
        // Если вдруг шаг меньше 1-го градуса, делаем его 1 градус
        mStep = step < 1 ? 1 : step;
    }

    @Override
    // Рисует фигуру (круг)
    public void draw() {
        glBegin(GL_TRIANGLE_FAN);
        for (float a = 0.0f; a < 360.0; a += mStep) {
            float theta = 1.0f * (float) Math.PI * a / 180.0f;
            glVertex2f(mRadius * (float) Math.cos(theta) + (mXPos + mRadius),
                    mRadius * (float) Math.sin(theta) + (mYPos + mRadius));
        }
        glEnd();
    }
}

