package de.example.ordering.impl.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import de.example.dataobjects.Meal;
import de.example.dataobjects.Order;
import de.example.dataobjects.OrderPosition;
import de.example.dataobjects.enums.OrderStatus;
import de.example.ordering.facade.OrderService;

public class OrderServiceImpl implements OrderService{
	private static final int NUMBER_OF_TABLES = 5;
	
	private List<Order> orders = new ArrayList<Order>(NUMBER_OF_TABLES);
	HashMap<Integer, Integer> tableOrderMapping = new HashMap<Integer, Integer>();
	
	public OrderServiceImpl() {
		
	}
	
	/**
	 * Opens a new order
	 * 
	 * @param customer: name of customer, cannot be null
	 * @param waiter: name of waiter, cannot be null
	 * @param table: number of table, cannot negative
	 * 
	 * @return orderNumber
	 */
	public int openOrder(String guest, String waiter, int table) {
		
	  int orderNumber = checkForOpenOrder(guest);
	  if(orderNumber != 999) {
	    return orderNumber;
	  }
		
		orders.add(new Order(guest, waiter, table));
		tableOrderMapping.put(table, orders.size()-1);
		
		return orders.size()-1;
	}
	
	/**
	 * Checks if the guest has an open Order
	 * 
	 * @param guest
	 * @return order number or 999 if no order exists
	 */
	private int checkForOpenOrder(String guest) {
	   for(int i = 0; i < orders.size(); i++) {
	      if(orders.get(i).getGuest() == guest && orders.get(i).getStatus() == OrderStatus.OPEN) {
	        System.out.println("Warning!");
	        System.out.println("-------------------------------------------");
	        System.out.println("Found existing order for this guest.");
	        System.out.println("Use order #" + i + " instead.");
	        System.out.println("-------------------------------------------");
	        System.out.println();
	        
	        return i;
	      }
	   }
     
     return 999;
  }
	
	
	/**
	 * Bills order and closes it
	 * 
	 * @param orderNumber: number of the order
	 * @param tip: tip given by customer
	 */
	public void billOrder(int orderNumber, double tip) {
		
		double price = 0;
		
		this.orders.get(orderNumber).setTip(tip);
		
		for(OrderPosition position: this.orders.get(orderNumber).getOrderPositions()) {
			price += position.getMeal().getPrice();
		}
		
		System.out.println("Customer paid " + price + " and tipped " + this.orders.get(orderNumber).getTip() + ".");
		
		this.orders.get(0).setStatus(OrderStatus.CLOSED);
	}
	
	/**
	 * Opens orderPosition in order
	 * 
	 * @params orderNumber: number of the order
	 * @params meal: used for creating an orderPosition
	 */
	public void openOrderPosition(String guest, int orderNumber, Meal meal) {
		this.orders.get(orderNumber).addMeal(guest, meal);
	}
	
	/** 
	 * Return orders
	 * 
	 * @return list of all orders
	 */
	public List<Order> getOrders() {
		return Collections.unmodifiableList(this.orders);
	}
	
	/**
	 * Returns the current order number of a table
	 * 
	 * @param tableNumber
	 * @return number of the order
	 */
	public int getOrderNumberForTable(int tableNumber) {
		return (int) tableOrderMapping.get(tableNumber);
	}
}
