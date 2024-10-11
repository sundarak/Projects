package com.adventuretest;

import static org.junit.Assert.*;

import com.adventuregame.Item;
import com.adventuregame.ItemImpl;
import com.adventuregame.Inventory;
import com.adventuregame.InventoryImpl;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

/** Write unit tests for the InventoryImpl class here */
public class JediInventoryTests {
  @Test
  public void testConstructor() {
    Inventory mine = new InventoryImpl();
    assertNotNull(mine.getItems());
    assertTrue(mine.isEmpty());
    assertEquals(0, mine.getNumItems());
  }

  /*
  Hint: Add more unit tests to check the getItems() method. Here are some things to try:
    1. Add a unit test to check adding and removing multiple items from the inventory
    2. Add a unit test to verify that the list returned by getItems() is a clone of the encapsulated list
    3. Add a unit test to verify that the items stored in getItems() are correct. You can use assertArrayEquals() to make this easy!

  */
  @Test
  public void testMethodAddAndRemove() {
    Inventory mine = new InventoryImpl();
    Item flower = new ItemImpl("Flower");
    Item poppy = new ItemImpl("Poppy");
    mine.addItem(flower);
    assertFalse(mine.isEmpty());
    mine.addItem(poppy);
    assertEquals(2, mine.getNumItems());
    mine.removeItem(poppy);
    assertEquals(1, mine.getNumItems());
    mine.removeItem(flower);
    assertTrue(mine.isEmpty());
  }

  @Test
  public void testGetItemsMethod() {
    Inventory mine = new InventoryImpl();
    Item sunflower = new ItemImpl("Sunflower");
    Item rose = new ItemImpl("Rose");
    mine.addItem(sunflower);
    mine.addItem(rose);
    List<Item> items = mine.getItems();
    assertNotSame(items, mine.getItems());
  }

  @Test
  public void testEqualArrays() {
    Inventory mine = new InventoryImpl();
    Item tulip = new ItemImpl("Tulip");
    Item lily = new ItemImpl("Lily");
    mine.addItem(tulip);
    mine.addItem(lily);
    String[] expected = {"Tulip", "Lily"};
    String[] actual = new String[mine.getItems().size()];
    for (int i = 0; i < mine.getItems().size(); i++) {
      actual[i] = mine.getItems().get(i).getName();
    }
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testClearMethod() {
    Inventory mine = new InventoryImpl();
    Item daisy = new ItemImpl("Daisy");
    Item violet = new ItemImpl("Violet");
    mine.addItem(daisy);
    mine.addItem(violet);
    mine.clear();
    assertTrue(mine.isEmpty());
    assertEquals(0, mine.getNumItems());
    mine.clear();
    assertTrue(mine.isEmpty());
    assertEquals(0, mine.getNumItems());
  }

  @Test()
  public void testTransferFromMethod() {
    Inventory mine = new InventoryImpl();
    Inventory other = new InventoryImpl();
    Item sunflower = new ItemImpl("Sunflower");
    Item rose = new ItemImpl("Rose");
    Item tulip = new ItemImpl("Tulip");
    Item lily = new ItemImpl("Lily");
    Item daisy = new ItemImpl("Daisy");
    Item violet = new ItemImpl("Violet");
    try {
      mine.transferFrom(null);
    } catch (IllegalArgumentException e) {

    }
    mine.addItem(sunflower);
    mine.addItem(rose);
    mine.addItem(daisy);
    other.addItem(tulip);
    other.addItem(lily);
    other.addItem(violet);
    mine.transferFrom(other);
    assertEquals(6, mine.getNumItems());
    assertEquals(0, other.getNumItems());
  }
}
