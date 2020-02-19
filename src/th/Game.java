package th;

import th.engine.*;
import th.engine.graphics.Color;

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
        //
    }

    @Override
    public void update(double delta) {
        //
    }

    @Override
    public void render(Graphics g) {
        //
    }
}

