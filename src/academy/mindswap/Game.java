package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.*;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

import java.util.Iterator;


public class Game {

    private Snake snake;
    private Fruit fruit;
    private int delay;
    private int cols;
    private int rows;
    private int timeSurvived;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        snake = new Snake(cols / 2, rows / 2);
        this.delay = delay;
        this.cols = cols;
        this.rows = rows;
    }

    public void start() throws InterruptedException {

        while (snake.isAlive()) {
            Thread.sleep(delay);
            Field.clearTail(snake);
            this.generateFruit(); // uncomment when it's time to introduce fruits
            Field.drawFruit(this.fruit);
            moveSnake();
            checkCollisions();
            Field.drawSnake(snake);
            this.timeSurvived++;
        }

        this.endGame();
    }

    private void generateFruit() {
        if (this.fruit != null) {
            return;
        }

        this.fruit = this.getNewFruit();
    }

    private Fruit getNewFruit() {
        FruitEnum pick = FruitEnum.getRandomFruit();
        if (pick == null) {
            return new Apple();
        }

        switch (pick) {
            case BANANA:
                return new Banana();
            case PEACH:
                return new Peach();
            default:
                return new Apple();
        }
    }

    private void moveSnake() {

        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    break;

                case ArrowDown:
                    snake.move(Direction.DOWN);
                    break;

                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    break;

                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    break;

                case Escape:
                    System.exit(1);
            }
        }
        snake.move();
    }

    private void checkCollisions() {
        if (this.isSnakeOutOfBounds()) {
            snake.die();
            return;
        }

        // snake collision with itself check
        Iterator<Position> it = snake.getFullSnake().iterator();
        it.next(); //skip head
        while (it.hasNext()) {
            Position currentBodyPosition = it.next();
            if (this.isSnakeCollidingWith(currentBodyPosition)) {
                snake.die();
                return;
            }
        }

        // fruit check
        if (this.isSnakeCollidingWith(this.fruit.getPosition())) {
            snake.increaseSize(this.fruit.getGrowValue());
            // increase game seed per fruit eaten
            if (this.delay > 10)
                this.delay -= 5;
            this.fruit = null;
        }
    }

    private boolean isSnakeCollidingWith(Position currentPosition) {
        return snake.getHead().getCol() == currentPosition.getCol()
                && snake.getHead().getRow() == currentPosition.getRow();
    }

    private boolean isSnakeOutOfBounds() {
        return (snake.getHead().getCol() >= this.cols - 1) || (snake.getHead().getCol() <= 0)
                || (snake.getHead().getRow() >= this.rows - 1) || (snake.getHead().getRow() <= 0);
    }

    private void endGame() {
        int totalScore = this.snake.getSnakeSize() + this.timeSurvived - this.delay;
        System.out.println("Game ended!");
        System.out.println("Snake had size of " + this.snake.getSnakeSize() + " units");
        System.out.println("Game speed was " + this.delay + " ms per tick");
        System.out.println("Player survived for " + this.timeSurvived + " units of time");
        System.out.println("Score: " + totalScore);
    }
}
