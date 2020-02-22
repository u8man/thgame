package th;

import th.engine.*;
import th.engine.game.ObjectManager;
import th.engine.graphics.Color;
import th.engine.input.Keyboard;
import th.game.objects.Player;
import th.game.objects.Railway;
import th.game.objects.Train;

public class THGame extends th.engine.Game {

    private ObjectManager mOm;

    public static void main(String[] args) {
        new THGame().run();
    }


    public THGame() {
        super(360, 640, "TH Game 0.1.1", true, true);
    }

    @Override
    public void init() {
        setBackgroundColor(new Color(80, 140, 100));
        mOm = new ObjectManager(this);

        Railway rWay = (Railway) mOm.add("Railway", new Railway(180, 0));
        rWay.setSpeed(2);
        rWay.move();

        Train train = (Train) mOm.add("Train", new Train(120, -650));
        train.init();

        Player player1 = (Player) mOm.add("Player", new Player(167, 400), 999);
        player1.setSpeed(1.5f);

        resume();
    }

    @Override
    public void terminate() {
        mOm.clear();
    }

    @Override
    public void input(Input input) {
        if (input.isKeyPressed(Keyboard.KEY_ESCAPE)) {
            stop();
        }

        mOm.input(input);
    }

    @Override
    public void update() {
        mOm.update();
    }

    @Override
    public void render(Graphics g) {
        mOm.render(g);
    }
}

