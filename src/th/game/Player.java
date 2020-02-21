package th.game;

import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Inputable;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Circle;
import th.engine.graphics.shapes.Rectangle;
import th.engine.input.Keyboard;

/**
 * Игрок
 */
public class Player extends Object implements Inputable, Updatable, Renderable {

    private int mDirectionOfMove = 0;
    private float mSpeed = 1.0f;

    public Player(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Player);
    }

    // Устанавливает направление движения вверх
    public void moveUp() {
        mDirectionOfMove = 1;
    }

    // Устанавливает направление движения вниз
    public void moveDown() {
        mDirectionOfMove = -1;
    }

    // Останавливает движение
    public void stopMove() {
        mDirectionOfMove = 0;
    }

    // Получает направление движения
    public int getDirectionOfMove() {
        return mDirectionOfMove;
    }

    // Устанавливает скорость движения
    public void setSpeed(float speed) {
        mSpeed = speed;
    }

    // Получает скорость движения
    public float getSpeed() {
        return mSpeed;
    }

    @Override
    public void input(Input input) {
        if (input.isKeyPressed(Keyboard.KEY_UP)) {
            moveUp();
        }
        if (input.isKeyPressed(Keyboard.KEY_DOWN)) {
            moveDown();
        }
        if (input.isKeyPressed(Keyboard.KEY_SPASE)) {
            stopMove();
        }
    }

    @Override
    public void update() {
        //
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(250, 250, 250));
        // Плечи
        g.draw(new Rectangle(36, 10), getXPos(), getYPos()+5);
        // Голова
        g.draw(new Circle(10), getXPos()+8, getYPos());
    }
}

