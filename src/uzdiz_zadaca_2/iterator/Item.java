/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.iterator;

/**
 *
 * @author abenkovic
 */
public class Item {

  private ItemType_e type;
  private String name;

  public Item(ItemType_e type, String name) {
    this.setType(type);
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public ItemType_e getType() {
    return type;
  }

  public final void setType(ItemType_e type) {
    this.type = type;
  }
}
