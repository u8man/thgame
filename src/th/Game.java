package th;

import th.engine.*;
import th.engine.game.ObjectManager;
import th.engine.graphics.Color;
import th.engine.input.Keyboard;
import th.game.Railway;

public class Game extends Core {

    private ObjectManager mOM;

    public static void main(String[] args) {
        new Game().run();
    }


    public Game() {
        super(360, 640, "TH Game 0.1.0", false, true);
    }

    @Override
    public void init() {
        setBackgroundColor(new Color(80, 140, 100));
        mOM = new ObjectManager(this);

        Railway rWay = new Railway(180, 0);
        rWay.setSpeed(2);
        rWay.setMove(true);
        mOM.add(rWay);

        resume();
    }

    @Override
    public void terminate() {
        //
    }

    @Override
    public void input(Input input) {
        if (input.isKeyPressed(Keyboard.KEY_ESCAPE)) {
            stop();
        }

        mOM.input(input);
    }

    @Override
    public void update() {
        mOM.update();
    }

    @Override
    public void render(Graphics g) {
        mOM.render(g);
    }
}

