package de.example;

import java.util.ArrayList;
import java.util.List;

import de.example.dataobjects.Meal;
import de.example.dataobjects.Order;
import de.example.dataobjects.OrderPosition;
import de.example.dataobjects.enums.MealCategory;
import de.example.ordering.impl.business.OrderReaderWriter;
import de.example.ordering.impl.business.OrderServiceImpl;

/**
 * Main class
 */
public class Main {

  // dummy data
  private static final String waiter1 = "Waiter #1";
  private static final String waiter2 = "Waiter #2";
  private static final String guest1 = "Guest #1" ;
  private static final String guest2 = "Guest #2" ;
  
  private static final int table1 = 1;
  
  private static final Meal coke = new Meal("Coke", 2.0, MealCategory.DRINK, 1);
  private static final Meal fries = new Meal("Fries", 2.5, MealCategory.MAIN_DISH , 1);
  private static final Meal steak = new Meal("Steak", 7.5, MealCategory.MAIN_DISH, 5);
  
	public static void main(String[] args) {
		testOrderingService();
	}

	private static void testOrderingService() {
	   // Open order with 3 positions
    System.out.println("Opening order");
    System.out.println("-------------------------------------------");
    System.out.println();
    OrderServiceImpl orderSystem = new OrderServiceImpl();
    int orderNumber = orderSystem.openOrder(guest1, waiter1, table1);
    orderSystem.openOrderPosition(guest1, orderNumber, coke);
    orderSystem.openOrderPosition(guest1, orderNumber, fries);
    orderSystem.openOrderPosition(guest2, orderNumber, steak);
    
    // Try to open order for existing customer
    orderSystem.openOrder(guest1, waiter1, 1);
    
    // Print order
    System.out.println("Printing order information for table 1 ...");
    int retrievedOrderNumber = orderSystem.getOrderNumberForTable(table1);
    Order retrievedOrder = orderSystem.getOrders().get(retrievedOrderNumber);
    System.out.println("-------------------------------------------");
    System.out.println("Order number : " + retrievedOrderNumber);
    System.out.println("Information  : " + orderSystem.getOrders().get(orderNumber).toString());
    for(OrderPosition position : retrievedOrder.getOrderPositions()) {
      System.out.println("Position: " + position.toString());
    }
    System.out.println("-------------------------------------------");
    System.out.println();
    
    // Close order
    System.out.println("Closing order ...");
    System.out.println("-------------------------------------------");
    orderSystem.billOrder(orderNumber, 2);
    System.out.println("-------------------------------------------");
    System.out.println();
	}
	
	@SuppressWarnings("unused")
  private static void testSerialization() {
	   List<Order> orderList = new ArrayList<Order>();
	    Order order1 = new Order(guest1, waiter1, 1);
	    Order order2 = new Order(guest2, waiter2, 2);
	    order1.addMeal(guest1, fries);
	    order2.addMeal(guest2, steak);
	    order2.addMeal(guest2, coke);
	    
	    order1.setTip(5.0);
	    order2.setTip(4.0);
	    
	    orderList.add(order1);
	    orderList.add(order2);
	    
	    OrderReaderWriter orderReaderWriter = new OrderReaderWriter();
	    orderReaderWriter.writeToFile(orderList);
	    List<Order> inputOrderList = (List<Order>) orderReaderWriter.readFromFile();
	    
	    System.out.println("Print list: \n" + inputOrderList.toString());
	    System.out.println("Print position #1 from order #1: \n" + inputOrderList.get(0).getOrderPositions().get(0).toString());
	}
}
