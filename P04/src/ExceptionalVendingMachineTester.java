import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine Tester
// Course:   CS 300 Fall 2022
//
// Author:   Seungwook Seo
// Email:    sseo36@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

// Below is a javadoc class header to complete
/**
 * 
 * @author Seungwook Seo
 * 
 * Tester class for Exceptional Vending Machine
 *
 */

/**
 * This class implements testers to check the correctness of the methods
 * implemented in p04 Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {

	/**
	 * Checks the correctness of the constructor of the class Item when passed
	 * invalid inputs
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemConstructorNotValidInput() {
		try {
			new Item("", 1);
			return false;
		} catch (IllegalArgumentException e) {
		}

		try {
			new Item(null, 1);
			return false;
		} catch (IllegalArgumentException e) {
		}

		try {
			new Item("soda", -1);
			return false;
		} catch (IllegalArgumentException e) {
		}

		return true;
	}

	/**
	 * Checks the correctness of the constructor of the class Item,
	 * Item.getDescription(), Item.getExpirationDate(), Item.setDescription(), and
	 * Item.toString() when passed valid inputs
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemConstructorGettersSetters() {
		Item item1 = new Item("soda", 1);

		if (item1.getDescription() != "soda") {
			return false;
		}
		
		item1.setDescription("cake");
		
		if (item1.getDescription() !="cake") {
			return false;
		}

		if (item1.getExpirationDate() != 1) {
			return false;
		}

		if (!item1.toString().equals("cake: 1")) {
			return false;
		}



		return true;
	}

	/**
	 * Checks the correctness of the Item.equals() method. You should consider at
	 * least the following four scenarios. (1) Create an item with valid description
	 * and expiration date, comparing it to itself should return true. (2) Two items
	 * having the same description but different expiration dates should be equal.
	 * (3) Passing a null reference to the Item.equals() method should return false.
	 * (4) An item MUST NOT be equal to an object NOT instance of the class Item,
	 * for instance a string object.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemEquals() {
		Item item1 = new Item("soda", 1);
		Item item2 = new Item("soda", 1);
		Item item3 = new Item("soda", 2);
		
		if (!item1.equals(item2)) {
			return false;
		}
		if (!item1.equals(item3)) {
			return false;
		}
		if (item1.equals(null)) {
			return false;
		}
		if (item1.equals("soda")) {
			return false;
		}
		return true;
	}

	/**
	 * Checks the correctness of the constructor of the ExceptionalVendingMachine
	 * when passed invalid input
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineConstructor() {
		try {
			new ExceptionalVendingMachine(0);
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		try {
			new ExceptionalVendingMachine(-1);
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		return true;
	}

	/**
	 * Checks the correctness of the following methods defined in the
	 * ExceptionalVendingMachine class when an exception is expected to be thrown:
	 * 
	 * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(),
	 * getItemOccurrences(), getItemOccurrencesByExpirationDate(), removeNextItem().
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
		ExceptionalVendingMachine evm = new ExceptionalVendingMachine(2);

		try {
			evm.addItem("", 1);
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		evm.addItem("soda", 1);
		evm.addItem("soda", 1);
		try {
			evm.addItem("soda", 1);
			return false;
		} catch (IllegalStateException e) {
		}
		try {
			evm.containsItem("");
			return false;
		} catch (IllegalArgumentException e) {
		}
		try {
			evm.getIndexNextItem("");
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		try {
			evm.getIndexNextItem("cake");
			return false;
		} catch (NoSuchElementException e) {
		}
		
		try {
			evm.getItemAtIndex(-1);
			return false;
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			evm.getItemOccurrences("");
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		try {
			evm.getItemOccurrencesByExpirationDate("", 1);
			return false;
		} catch (IllegalArgumentException e) {
		}
		
		try {
			evm.removeNextItem("cake");
			return false;
		} catch (NoSuchElementException e) {
		}
		
		return true;
	}

	/**
	 * Checks the correctness of isEmpty(), size(), and isFull() methods defined in
	 * the ExceptionalVendingMachine class
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testEmptySizeFullExceptionalVendingMachine() {
		ExceptionalVendingMachine evm = new ExceptionalVendingMachine(2);

		if(!evm.isEmpty()) {
			return false;
		}
		
		evm.addItem("soda", 1);
		
		
		if(evm.size() != 1) {
			return false;
		}
		
		evm.addItem("soda", 1);
		
		if(!evm.isFull()) {
			return false;
		}
		
		return true; // default return statement added to resolve compiler errors
	}

	/**
	 * Checks the correctness of loadOneItem method with respect to its
	 * specification. Consider at least the four following scenarios. (1) Successful
	 * scenario for loading one item with a valid string representation to a
	 * non-full vending machine. (2) Unsuccessful scenario for passing null or a
	 * blank string (for instance one space or empty string) to the loadOneItem()
	 * method call, an IllegalArgumentEXception is expected to be thrown. (3)
	 * Unsuccessful scenario for passing a badly formatted string to the loadOneItem
	 * method. A DataFormatException is expected to be thrown. (4) Unsuccessful
	 * scenario for trying to load an item with a valid representation to a full
	 * vending machine. An IllegalStateException is expected to be thrown.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testLoadOneItem() {
		ExceptionalVendingMachine evm = new ExceptionalVendingMachine(2);

		try {
			evm.loadOneItem("soda: 1");
			
		} catch (Exception e) {
			return false;
		}
		
		try {
			evm.loadOneItem("");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			return false;
		}
		
		try {
			evm.loadOneItem("Hello, world!");
			return false;
		} catch (DataFormatException e) {
		} catch (Exception e) {
			return false;
		}
		
		try {
			evm.loadOneItem("soda: 1");
			evm.loadOneItem("soda: 1");
			return false;
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			return false;
		}
		
		return true; // default return statement added to resolve compiler errors
	}

	/**
	 * Invokes all the public tester methods implemented in this class
	 * 
	 * @return true if all testers pass with no errors, and false if any of the
	 *         tester fails.
	 */
	public static boolean runAllTests() {
		if (!testItemConstructorNotValidInput()) {
			System.out.println("testItemConstructorNotValidInput: false");
			return false;
		}
		if (!testItemConstructorGettersSetters()) {
			System.out.println("testItemConstructorGettersSetters: false");
			return false;
		}
		if (!testItemEquals()) {
			System.out.println("testItemEquals: false");
			return false;
		}
		if (!testExceptionalVendingMachineAddContainsRemoveGetters()) {
			System.out.println("testExceptionalVendingMachineAddContainsRemoveGetters: false");
			return false;
		}
		if (!testEmptySizeFullExceptionalVendingMachine()) {
			System.out.println("testEmptySizeFullExceptionalVendingMachine: false");
			return false;
		}
		if (!testLoadOneItem()) {
			System.out.println("testLoadOneItem: false");
			return false;
		}
		

		return true;
	}

	/**
	 * Main method for the tester class
	 * 
	 * @param args list of input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("runAllTests: " + runAllTests());
	}

}
