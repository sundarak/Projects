package com.adventuregame;

public class PlayerImpl implements Player {
  private final String name;
  private Position position;
  private final Inventory inventory;

  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("has to have name");
    }
    this.name = name;
    this.position = new PositionImpl(startX, startY);
    this.inventory = new InventoryImpl();
  }

  // getter methods
  public Position getPosition() {
    return position;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public String getName() {
    return name;
  }

  // Blindly moves the player's position one unit in the indicated direction, without checking
  // whether the new location is valid
  // player object should replace its private Position field with a new
  // Position according to the indicated direction of the movement.
  // using the getNeighbor() method.
  public void move(Direction direction) {
    this.position = position.getNeighbor(direction);
  }
}
