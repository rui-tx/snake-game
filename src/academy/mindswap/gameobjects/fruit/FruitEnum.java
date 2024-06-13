package academy.mindswap.gameobjects.fruit;

import com.googlecode.lanterna.terminal.Terminal;

public enum FruitEnum {
    APPLE(1, "@", Terminal.Color.GREEN),
    BANANA(2, ")", Terminal.Color.YELLOW),
    PEACH(3, "Ô", Terminal.Color.MAGENTA);

    private int numberOfNodes;
    private String string;
    private Terminal.Color color;

    FruitEnum(int numberOfNodes, String string, Terminal.Color color) {
        this.numberOfNodes = numberOfNodes;
        this.string = string;
        this.color = color;
    }
}
