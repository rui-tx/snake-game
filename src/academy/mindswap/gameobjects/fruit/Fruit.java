package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Position;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Fruit {

    private Position position;
    private Terminal.Color color;
    private String string;

    public Fruit() {
        position = new Position(getRandomNumber(5, 95), getRandomNumber(5, 15));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public Position getPosition() {
        return this.position;
    }

    public Terminal.Color getColor() {
        return color;
    }

    public void setColor(Terminal.Color color) {
        this.color = color;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
