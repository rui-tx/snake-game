package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Position;
import academy.mindswap.util.Random;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Fruit {
    
    private Position position;
    private Terminal.Color color;
    private String string;
    private int growValue;

    public Fruit() {
        position = new Position(Random.getRandomNumber(5, 95), Random.getRandomNumber(5, 15));
        this.growValue = 1;
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

    public int getGrowValue() {
        return growValue;
    }

    public void setGrowValue(int growValue) {
        this.growValue = growValue;
    }
}
