package th.game.objects;

import th.engine.Graphics;
import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;
import th.game.ObjectType;
import th.game.shapes.SRailway;

/**
 * Железная дорога
 */
public class Railway extends Object implements Renderable, Updatable {

    protected SRailway mRailwayShape;
    protected float mSpeed = 1.4f;
    protected boolean mMove = false;

    public Railway(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Railway);
        mRailwayShape = new SRailway(this, xPos, yPos);
    }

    // Устанавливает скорость движения
    public void setSpeed(float speed) {
        mSpeed = speed;
    }

    // Получает скорость движения
    public float getSpeed() {
        return mSpeed;
    }

    // Запускает движение
    public void move() {
        mMove = true;
    }

    // Oстанавливает движение
    public void stop() {
        mMove = false;
    }

    // Проверят, движется или нет железная дорога
    public boolean isMove() {
        return mMove;
    }

    @Override
    public void update() {
        mRailwayShape.update();
    }

    @Override
    public void render(Graphics g) {
        mRailwayShape.draw(g);
    }
}

