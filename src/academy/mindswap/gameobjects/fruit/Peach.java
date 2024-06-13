package academy.mindswap.gameobjects.fruit;

import com.googlecode.lanterna.terminal.Terminal;

public class Peach extends Fruit {

    public Peach() {
        this.setColor(Terminal.Color.RED);
        this.setString("Ô");
    }
}
