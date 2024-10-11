package com.adventuregame;

public class CellImpl implements Cell {
  private final Position position;
  private String name;
  private String description;
  private boolean visited;
  private Inventory chest;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException("cannot have null values for name or description");
    }
    this.chest = null;
    this.visited = false;
    this.position = new PositionImpl(x, y);
    this.name = name;
    this.description = description;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  // getter methods
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Position getPosition() {
    return position;
  }

  public Inventory getChest() {
    return chest;
  }

  public boolean getIsVisited() {
    return visited;
  }

  public boolean hasChest() {
    return chest != null;
  }

  // setter methods
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("has to have name");
    }
    this.name = name;
  }

  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("has to have description");
    }
    this.description = description;
  }

  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("has to have chest");
    }
    this.chest = chest;
  }

  public void visit() {
    this.visited = true;
  }
}
