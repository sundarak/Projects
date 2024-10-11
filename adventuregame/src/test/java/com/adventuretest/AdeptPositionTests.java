package com.adventuretest;

import static org.junit.Assert.*;

import com.adventuregame.Direction;
import com.adventuregame.Position;
import com.adventuregame.PositionImpl;

import org.junit.Test;

/** Write unit tests for the PositionImpl class here */
public class AdeptPositionTests {
  @Test
  public void testConstructor() {
    Position position = new PositionImpl(6, 9);
    assertEquals(6, position.getX());
    assertEquals(9, position.getY());
  }

  @Test
  public void testGetter() {
    Position position = new PositionImpl(13, 26);
    int XBefore = position.getX();
    int YBefore = position.getY();
    int XAfter = position.getX();
    int YAfter = position.getY();
    assertEquals(XBefore, XAfter);
    assertEquals(YBefore, YAfter);
  }

  @Test
  public void testGetNeighborNull() {
    Position position = new PositionImpl(25, 14);
    try {
      position.getNeighbor(null);
      fail();
    } catch (Exception e) {

    }
  }

  @Test
  public void getNeighborNorth() {
    Position position = new PositionImpl(5, 5);
    Position neighbor = position.getNeighbor(Direction.NORTH);
    assertEquals(6, neighbor.getY());
  }

  @Test
  public void getNeighborSouth() {
    Position position = new PositionImpl(5, 5);
    Position neighbor = position.getNeighbor(Direction.SOUTH);
    assertEquals(4, neighbor.getY());
  }

  @Test
  public void getNeighborEast() {
    Position position = new PositionImpl(5, 5);
    Position neighbor = position.getNeighbor(Direction.EAST);
    assertEquals(6, neighbor.getX());
  }

  @Test
  public void getNeighborWest() {
    Position position = new PositionImpl(5, 5);
    Position neighbor = position.getNeighbor(Direction.WEST);
    assertEquals(4, neighbor.getX());
  }
}
