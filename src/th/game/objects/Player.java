package th.game.objects;

import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.Object;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Inputable;
import th.engine.input.Keyboard;
import th.game.ObjectType;
import th.game.shapes.SPlayer;

/**
 * Класс игрока
 */
public class Player extends Object implements Inputable, Renderable {

    protected SPlayer mPlayerShape;
    protected int mDirectionOfMove = 0;
    protected float mSpeed = 0.0f;

    public Player(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Player);
        mPlayerShape = new SPlayer(xPos, yPos);
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
        } else if (input.isKeyPressed(Keyboard.KEY_DOWN)) {
            moveDown();
        } else if (input.isKeyPressed(Keyboard.KEY_SPASE)) {
            stopMove();
        }
    }

    @Override
    public void render(Graphics g) {
        mPlayerShape.draw(g);
    }
}

