package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 10;
    private final LinkedList<Position> body;
    private Direction direction;
    private boolean alive;

    public Snake(int col, int row) {
        this.direction = Direction.LEFT;
        this.alive = true;
        this.body = new LinkedList<>();

        this.init(col, row);
    }

    private void init(int col, int row) {
        Position initialPosition = new Position(col, row);
        this.body.addFirst(initialPosition);
        for (int i = 0; i < SNAKE_INITIAL_SIZE - 1; i++) {
            this.body.add(new Position(++col, row));
        }
    }

    //TODO: refactor this, it doesn't feel quite quite right
    public boolean increaseSize(int size) {
        Position newNode;
        if (this.direction == Direction.LEFT) {
            newNode = new Position(this.body.getLast().getCol() + 1, this.body.getLast().getRow());
        } else {
            newNode = new Position(this.body.getLast().getCol() - 1, this.body.getLast().getRow());
        }

        this.body.add(newNode);
        
        return size == 0 || this.increaseSize(size - 1);
    }

    public void move(Direction nextDirection) {
        if (this.direction == Direction.LEFT && !(nextDirection == Direction.RIGHT)) {
            this.direction = nextDirection;
            return;
        }

        if (this.direction == Direction.RIGHT && !(nextDirection == Direction.LEFT)) {
            this.direction = nextDirection;
            return;
        }

        if (this.direction == Direction.UP && !(nextDirection == Direction.DOWN)) {
            this.direction = nextDirection;
            return;
        }

        if (this.direction == Direction.DOWN && !(nextDirection == Direction.UP)) {
            this.direction = nextDirection;
        }
    }

    public void move() {
        if (this.direction == Direction.LEFT) {
            this.updateHeadPosition(new Position(
                    this.body.getFirst().getCol() - 1,
                    this.body.getFirst().getRow()));
            return;
        }

        if (this.direction == Direction.DOWN) {
            this.updateHeadPosition(new Position(
                    this.body.getFirst().getCol(),
                    this.body.getFirst().getRow() + 1));
            return;
        }

        if (this.direction == Direction.UP) {
            this.updateHeadPosition(new Position(
                    this.body.getFirst().getCol(),
                    this.body.getFirst().getRow() - 1));
            return;
        }

        if (this.direction == Direction.RIGHT) {
            this.updateHeadPosition(new Position(
                    this.body.getFirst().getCol() + 1,
                    this.body.getFirst().getRow()));
        }
    }

    private void updateHeadPosition(Position newPosition) {
        this.body.addFirst(newPosition);
        this.body.removeLast();
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return this.body.getFirst();
    }

    public Position getTail() {
        return this.body.getLast();
    }

    public LinkedList<Position> getFullSnake() {
        return this.body;
    }

    public int getSnakeSize() {
        return this.body.size();
    }
}