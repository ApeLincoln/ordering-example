package de.example.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.example.dataobjects.enums.OrderStatus;
import de.example.utility.ArgumentChecker;

/**
 * Class to represent orders
 */
public class Order implements Serializable{
	
	private static final long serialVersionUID = -3499338217614173411L;
	
	private final String guest;
	private final String waiter;
	private final int table;
	
	private List<OrderPosition> positions = new ArrayList<OrderPosition>();
	
	private OrderStatus status;
	private double tip;
	
	/**
	 * Constructor
	 * 
	 * @param customer: name of customer, cannot be null
	 * @param waiter: name of waiter, cannot be null
	 * @param table: number of table, cannot be negative
	 */
	public Order(final String customer, final String waiter, final int table) {
		// Validation of input parameter
	  ArgumentChecker.isNotNull(customer);
		ArgumentChecker.isNotNull(waiter);
		ArgumentChecker.isNotNegative(table);
		
		this.guest = customer;
		this.waiter = waiter;
		this.table = table;
		
		this.status = OrderStatus.OPEN;
		this.tip = 0;
	}
	
	 /**
   * Creates an orderPosition and saves it in positions
   * 
   * @param meal: used for creating an orderPosition
   */
  public void addMeal(String guest, Meal meal) {
    positions.add(new OrderPosition(guest, meal));
  }
  
  /**
   * Returns orderPositions
   * 
   * @return list of all orderPositions
   */
  public List<OrderPosition> getOrderPositions() {
    return Collections.unmodifiableList(this.positions);
  }
  
  /**
   * Updates status of a position
   * 
   * @param position: orderPosition that will be updated
   * @param status: new status for the orderPosition 
   */
  public void updateStatusOfOrderPosition(int position) {
    // TODO
  }

  // Getter Setter
	public String getGuest() {
		return guest;
	}

	public String getWaiter() {
		return waiter;
	}

	public int getTable() {
		return table;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		ArgumentChecker.isNotNull(status);
		
		this.status = status;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		ArgumentChecker.isNotNegative(tip);
		
		this.tip = tip;
	}
	
  @Override
  public String toString() {
    return "{ guest: " + this.guest + ", waiter: " + this.waiter + ", table: " + table + ", status: " + this.status + ", tip: " + this.tip + " }";
  }
}
