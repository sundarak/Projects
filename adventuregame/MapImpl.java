package com.adventuregame;

public class MapImpl implements Map {
  private final Cell[][] grid;
  private final int HiddenItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("height and width of grid have to be positive");
    }
    this.grid = new Cell[width][height];
    this.HiddenItems = numItems;
  }

  @Override
  public int getWidth() {
    if (grid.length > 0) {
      return grid.length;
    } else {
      return 0;
    }
  }

  @Override
  public int getHeight() {
    return grid[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      throw new IndexOutOfBoundsException("x or y is not in range of grid");
    }
    return grid[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    return getCell(position.getX(), position.getY());
  }

  @Override
  public void initCell(int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
      throw new IndexOutOfBoundsException("x or y is not in range of grid");
    }
    grid[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return HiddenItems;
  }
}
