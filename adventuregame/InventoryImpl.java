package com.adventuregame;

import java.util.List;
import java.util.ArrayList;

public class InventoryImpl implements Inventory {
  private final List<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<>();
  }

  // methods
  public boolean isEmpty() {
    return items.isEmpty();
  }

  public int getNumItems() {
    return items.size();
  }

  public List<Item> getItems() {
    return new ArrayList<>(items);
  }

  public void addItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("item to be added cannot be null");
    }
    items.add(item);
  }

  public void removeItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("item to be removed cannot be null");
    }
    items.remove(item);
  }

  public void clear() {
    items.clear();
  }

  public void transferFrom(Inventory other) {
    if (other == null) {
      throw new IllegalArgumentException("other inventory cannot be null");
    }
    List<Item> itemsToTransfer = new ArrayList<>(other.getItems());
    for (Item item : itemsToTransfer) {
      if (item != null) {
        other.removeItem(item);
        this.addItem(item);
      }
    }
  }
}
