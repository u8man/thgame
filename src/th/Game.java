package th;

import th.engine.*;
import th.engine.graphics.Color;
import th.engine.input.Keyboard;

public class Game extends Core {

    public static void main(String[] args) {
        new Game().run();
    }


    public Game() {
        super(360, 640, "TH Game 0.1.0", false, true);
    }

    @Override
    public void init() {
        setBackgroundColor(new Color(80, 140, 100));
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
    }

    @Override
    public void update() {
        //
    }

    @Override
    public void render(Graphics g) {
        //
    }
}

