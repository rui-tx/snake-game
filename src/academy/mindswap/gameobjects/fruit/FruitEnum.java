package academy.mindswap.gameobjects.fruit;

import academy.mindswap.util.Random;
import com.googlecode.lanterna.terminal.Terminal;

public enum FruitEnum {
    APPLE(1, "@", Terminal.Color.GREEN),
    BANANA(2, ")", Terminal.Color.YELLOW),
    PEACH(3, "Ô", Terminal.Color.MAGENTA);

    private final int numberOfNodes;
    private final String string;
    private final Terminal.Color color;

    FruitEnum(int numberOfNodes, String string, Terminal.Color color) {
        this.numberOfNodes = numberOfNodes;
        this.string = string;
        this.color = color;
    }

    public static FruitEnum getRandomFruit() {
        int random = Random.getRandomNumber(0, FruitEnum.values().length - 1);
        return switch (random) {
            case 0 -> APPLE;
            case 1 -> BANANA;
            case 2 -> PEACH;
            default -> null;
        };
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public String getString() {
        return string;
    }

    public Terminal.Color getColor() {
        return color;
    }
}
