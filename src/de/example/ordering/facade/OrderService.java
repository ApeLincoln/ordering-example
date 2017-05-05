package de.example.ordering.facade;

import java.util.List;

import de.example.dataobjects.Meal;
import de.example.dataobjects.Order;

public interface OrderService {
  
  /**
   * Opens a new order
   * 
   * @param customer: name of customer, cannot be null
   * @param waiter: name of waiter, cannot be null
   * @param table: number of table, cannot negative
   * 
   * @return orderNumber
   */
  public int openOrder(String customer, String waiter, int table);
  
  /**
   * Bills order and closes it
   * 
   * @param orderNumber: number of the order
   * @param tip: tip given by customer
   */
  public void billOrder(int orderNumber, double tip);
  
  /**
   * Opens orderPosition in order
   * 
   * @params orderNumber: number of the order
   * @params meal: used for creating an orderPosition
   */
  public void openOrderPosition(String guest, int orderNumber, Meal meal);
  
  /** 
   * Return orders
   * 
   * @return list of all orders
   */
  public List<Order> getOrders();
  
  /**
   * Returns the current order number of a table
   * 
   * @param tableNumber
   * @return number of the order
   */
  public int getOrderNumberForTable(int tableNumber);
}
