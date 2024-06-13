package academy.mindswap.gameobjects.fruit;

import com.googlecode.lanterna.terminal.Terminal;

public class Apple extends Fruit {

    public Apple() {
        this.setColor(Terminal.Color.GREEN);
        this.setString("@");
    }

}
