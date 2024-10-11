package com.adventuretest;

import static org.junit.Assert.*;

import com.adventuregame.*;

import org.junit.Test;

/** Write unit tests for the PlayerImpl class here */
public class JediPlayerTests {
  @Test
  public void testConstructorThrowsExceptionOnWrongName() {
    try {
      Player player = new PlayerImpl(null, 3, 3);
      fail();
    } catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void testConstructor() {
    Player player = new PlayerImpl("Gold", 3, 4);
    assertEquals("Gold", player.getName());
    assertEquals(3, player.getPosition().getX());
    assertEquals(4, player.getPosition().getY());
  }

  @Test
  public void testMoveEast() {
    Player player = new PlayerImpl("Oxygen", 3, 3);
    player.move(Direction.EAST);
    assertEquals(4, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
  }

  @Test
  public void testMoveWest() {
    Player player = new PlayerImpl("Hydrogen", 3, 3);
    player.move(Direction.WEST);
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
  }

  @Test
  public void testMoveNorth() {
    Player player = new PlayerImpl("Helium", 3, 3);
    player.move(Direction.NORTH);
    assertEquals(3, player.getPosition().getX());
    assertEquals(4, player.getPosition().getY());
  }

  @Test
  public void testMoveSouth() {
    Player player = new PlayerImpl("Uranium", 3, 3);
    player.move(Direction.SOUTH);
    assertEquals(3, player.getPosition().getX());
    assertEquals(2, player.getPosition().getY());
  }

  @Test
  public void testNullMove() {
    Player player = new PlayerImpl("Potassium", 3, 3);
    try {
      player.move(null);
    } catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void testMultipleMoves() {
    Player player = new PlayerImpl("Zinc", 3, 3);
    player.move(Direction.EAST);
    player.move(Direction.SOUTH);
    player.move(Direction.WEST);
    player.move(Direction.NORTH);
    assertEquals(3, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
  }

  @Test
  public void testInventory() {
    Player player = new PlayerImpl("Plutonium", 3, 3);
    Item item = new ItemImpl("pen");
    assertNotNull(player.getInventory());
    assertTrue(player.getInventory().isEmpty());
    player.getInventory().addItem(item);
    assertEquals(1, player.getInventory().getNumItems());
    player.getInventory().removeItem(item);
    assertEquals(0, player.getInventory().getNumItems());
  }
}
