package com.adventuregame;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // getter methods
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Position getNeighbor(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("needs to have a direction");
    }
    // goes one unit towards direction and return new position as neighbor
    switch (direction) {
      case NORTH:
        return new PositionImpl(this.x, this.y + 1);
      case SOUTH:
        return new PositionImpl(this.x, this.y - 1);
      case EAST:
        return new PositionImpl(this.x + 1, this.y);
      case WEST:
        return new PositionImpl(this.x - 1, this.y);
      default:
        return null;
    }
  }
}
