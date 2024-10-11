package com.adventuregame;

import java.util.List;
import java.util.ArrayList;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("map or player cannot have null values");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    return player.getInventory().getItems().size() >= map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    Position pos = player.getPosition();
    Cell cell = map.getCell(pos);
    System.out.println("Location: " + cell.getName());
    System.out.println(cell.getDescription());
    if (cell.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (cell.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    cell.visit();
  }

  @Override
  public void openChest() {
    Position pos = player.getPosition();
    Cell cell = map.getCell(pos);
    if (cell.hasChest()) {
      Inventory chest = cell.getChest();
      if (chest.isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        List<Item> itemsInChest = chest.getItems();
        player.getInventory().transferFrom(chest);
        System.out.println("You collected these items: " + itemsInChest);
      }
    } else {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position pos = player.getPosition();
    Position moveTo = pos.getNeighbor(direction);
    if (moveTo.getX() < 0
        || moveTo.getX() >= map.getWidth()
        || moveTo.getY() < 0
        || moveTo.getY() >= map.getHeight()) {
      return false;
    } else {
      Cell moveToCell = map.getCell(moveTo);
      return moveToCell != null;
    }
  }

  @Override
  public void move(Direction direction) {
    if (canMove(direction)) {
      player.move(direction);
      printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
