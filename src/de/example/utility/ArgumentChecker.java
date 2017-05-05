package de.example.utility;

/**
 * Utility class used for checking arguments 
 * 
 * @author SBecker
 *
 */
public class ArgumentChecker {

	/**
	 * Checks if the argument is null
	 * 
	 * @param arg
	 */
	public static void isNotNull(Object arg) {
		if(arg == null) 
			throw new IllegalArgumentException("Argument cannot be null");			
	}
	
	/**
	 * Checks if the argument is negative
	 * 
	 * @param arg
	 */
	public static void isNotNegative(double arg) {
		if(arg <= 0)
			throw new IllegalArgumentException("Argument cannot be negative");
	}
}
