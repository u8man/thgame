package th;

import th.engine.*;
import th.engine.game.ObjectManager;
import th.engine.graphics.Color;
import th.engine.input.Keyboard;
import th.game.objects.Player;
import th.game.objects.Railway;
import th.game.objects.Train;

public class Game extends Core {

    private ObjectManager mOM;

    public static void main(String[] args) {
        new Game().run();
    }


    public Game() {
        super(360, 640, "TH Game 0.1.0", true, true);
    }

    @Override
    public void init() {
        setBackgroundColor(new Color(80, 140, 100));
        mOM = new ObjectManager(this);

        Railway rWay = new Railway(180, 0);
        mOM.add("Railway", rWay);
        rWay.setSpeed(2);
        rWay.move();

        Train train = new Train(120, -550);
        mOM.add("Train", train);

        Player player = new Player(167, 400);
        mOM.add("Player", player);
        player.setSpeed(1.8f);

        resume();
    }

    @Override
    public void terminate() {
        mOM.clear();
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

