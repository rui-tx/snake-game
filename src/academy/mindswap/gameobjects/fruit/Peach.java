package academy.mindswap.gameobjects.fruit;

import academy.mindswap.util.Random;
import com.googlecode.lanterna.terminal.Terminal;

public class Peach extends Fruit {

    public Peach() {
        this.setColor(Terminal.Color.RED);
        this.setString("Ô");
        this.setGrowValue(Random.getRandomNumber(1, 10));
    }
}
