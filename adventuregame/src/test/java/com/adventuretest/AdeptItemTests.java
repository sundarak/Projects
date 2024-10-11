package com.adventuretest;

import static org.junit.Assert.*;
import org.junit.Test;

import com.adventuregame.Item;
import com.adventuregame.ItemImpl;

/** Write unit tests for the ItemImpl class here */
public class AdeptItemTests {
  @Test
  public void testItemConstructor() {
    Item item = new ItemImpl("Rachel");
    assertEquals("Rachel", item.getName());
  }

  @Test
  public void testConstructorThrowsException() {
    try {
      Item item = new ItemImpl(null);
      fail();
    } catch (IllegalArgumentException e) {

    }
  }

  @Test
  public void testEquals() {
    Item item = new ItemImpl("Chandler");
    Item item2 = new ItemImpl("Chandler");
    Item item3 = new ItemImpl("Joey");
    assertFalse(item.equals(null));
    assertFalse(item2.equals(item3));
    assertTrue(item.equals(item2));
  }
}
