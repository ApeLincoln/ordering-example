package de.example.dataobjects;

import java.io.Serializable;

import de.example.dataobjects.enums.OrderPositionStatus;

public class OrderPosition implements Serializable{
	
	private static final long serialVersionUID = -7762496512089027413L;
	
	private final String guest;
	private final Meal meal;
	private OrderPositionStatus status;
	
	public OrderPosition(String guest, Meal meal) {
		this.guest = guest;
	  this.meal = meal;
		this.status = OrderPositionStatus.ORDERD;
	}
	
  public String getGuest() {
    return this.guest;
  }
	
	public Meal getMeal() {
		return this.meal;
	}
	
	public OrderPositionStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(OrderPositionStatus status) {
		this.status = status;
	}
	
	public String toString() {
		return "{ guest: " + this.guest + ", meal: " + this.meal + ", status: " + this.status + " }";
	}
}
