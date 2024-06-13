package academy.mindswap.gameobjects.fruit;

import com.googlecode.lanterna.terminal.Terminal;

public class Banana extends Fruit {

    public Banana() {
        this.setColor(Terminal.Color.YELLOW);
        this.setString("(");
    }
}
