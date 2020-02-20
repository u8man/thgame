package th.game;

import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.Object;
import th.engine.game.ObjectManager;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Inputable;

/**
 * Игрок
 */
public class Player extends Object implements Inputable, Updatable, Renderable {

    public Player(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Player);
    }

    @Override
    public void input(Input input) {
        //
    }

    @Override
    public void update(ObjectManager om) {

    }

    @Override
    public void render(Graphics g) {
        //
    }
}

