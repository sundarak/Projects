package com.adventuregame;

public interface Cell {
  // ********************************************************************************
  // GETTER METHODS

  /** Getter method for the cell's name */
  String getName();

  /** Getter method for the cell's description */
  String getDescription();

  /** Getter method for the position of the cell */
  Position getPosition();

  /** Getter method for the "chest" Inventory object stored at the cell */
  Inventory getChest();

  /** Getter method which returns true if the cell has been visited */
  boolean getIsVisited();

  /** Returns true if the cell has a chest */
  boolean hasChest();

  // ********************************************************************************
  // SETTER METHODS

  // Note: The setName(), setDescription(), and setChest() methods should perform setter validation
  // and throw an IllegalArgumentException for incoming "null" values

  /** Setter method for changing the cell's name */
  void setName(String name);

  /** Setter method for changing the cell's description */
  void setDescription(String description);

  /** Setter method for the "chest" Inventory object stored at the cell */
  void setChest(Inventory chest);

  /** Marks that the cell has been visited */
  void visit();
}
