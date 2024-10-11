package com.adventuregame;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("there has to be a name");
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    Item item = (Item) other;
    return this.name.equals(item.getName());
  }

  @Override
  public String toString() {
    return name;
  }
}
