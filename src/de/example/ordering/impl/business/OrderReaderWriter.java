package de.example.ordering.impl.business;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import de.example.dataobjects.Order;

/**
 * Used for writing orders to file and reading them
 */
public class OrderReaderWriter {
	
	OutputStream outputStream = null;
	InputStream inputStream = null;

	public OrderReaderWriter() {

	}	
	
	public void writeToFile(List<Order> order) {
		try {
			outputStream = new FileOutputStream("order.ser");
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);
			
			objectOutput.writeObject(order);
			objectOutput.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				outputStream.close();
			} catch (Exception e) {
				// Do nothing
			}
		}
	}
	
	public List<Order> readFromFile() {
		try {
			inputStream = new FileInputStream("order.ser");
			
			ObjectInputStream objectInput = new ObjectInputStream(inputStream);
			
			@SuppressWarnings("unchecked")
      List<Order> inputList = (List<Order>) objectInput.readObject();
			inputStream.close();
			
			return inputList;
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputStream.close();
			} catch (Exception e) {
				// Do nothing
			}
		}		
	}
}
