package de.example.dataobjects;

import java.io.Serializable;

import de.example.dataobjects.enums.MealCategory;
import de.example.utility.ArgumentChecker;

/**
 * Class to represent meals
 * 
 * @author SBecker
 *
 */
public class Meal implements Serializable {
	
	private static final long serialVersionUID = -3644935720876364745L;
	
	private String name;
	private double price;
	private MealCategory category;
	private int prepTimeInMinutes;

	/**
	 * Constructor
	 * 
	 * @param name: Name of meal, cannot be null
	 * @param price: Price of meal, cannot be negative
	 * @param category: Category of meal, cannot be null
	 * @param prepTimeInMinutes: Time needed for preparing meal, cannot be negative
	 */
	public Meal(String name, double price, MealCategory category, int preperationTime) {
		// Validation of input paramters
	  ArgumentChecker.isNotNull(name);
		ArgumentChecker.isNotNull(category);
		ArgumentChecker.isNotNegative(price);
		ArgumentChecker.isNotNegative(preperationTime);
		
		this.name = name;
		this.price = price;
		this.category = category;
		this.prepTimeInMinutes = preperationTime;
	}

	// Getter/Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		ArgumentChecker.isNotNull(name);
		
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		ArgumentChecker.isNotNegative(price);
		
		this.price = price;
	}

	public MealCategory getCategory() {
		return category;
	}

	public void setCategory(MealCategory category) {
		ArgumentChecker.isNotNull(category);
		
		this.category = category;
	}

	public int getPreperationTime() {
		return prepTimeInMinutes;
	}

	public void setPreperationTime(int preperationTime) {
		ArgumentChecker.isNotNull(preperationTime);
		
		this.prepTimeInMinutes = preperationTime;
	}
	
	@Override
	public String toString() {
		return "{ name: " + this.name + ", price: " + this.price + ", category: " + this.category + ", preperationTime: " + prepTimeInMinutes + " }";
	}
	
}
