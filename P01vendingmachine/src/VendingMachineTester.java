//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Vending machine testing code by java
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

import java.util.Arrays;

/**
 * 
 * @author Seungwook Seo
 * 
 *         Vending machine tester class
 *
 */

public class VendingMachineTester {
	/**
	 * Testing getIndexNextItem
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testGetIndexNextItem() {
		// Test scenarios normal and edge cases
		// Recall that the VendingMachine.getNextItem method gets the next item to be
		// dispensed given
		// its description without removing it.

		// 1. Next item to be dispensed is NOT found: the expected output is -1
		{
			// define the vending machine
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
				System.out.println(
						"testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
								+ "-1 when no match found.");
				return false;
			}
			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 2. Next item to be dispensed is at index 0
		{
			String[][] items = new String[][] { { "Water", "1" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			int itemsCount = 7;

			// check the correctness of the output
			if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
				System.out.println(
						"testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
								+ "the expected output when the vending machines contains multiple matches with the "
								+ "provided item description and the matching item with the soonest expiration date "
								+ "is at index 0.");
				return false;
			}
			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "1" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 3. Next item to be dispensed is at the end of the array
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "20" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			int itemsCount = 7;

			// check the correctness of the output
			if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
				System.out.println(
						"testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
								+ "the expected output when the vending machines contains multiple matches with the "
								+ "provided item description and the matching item with the soonest expiration date "
								+ "is at the end of the array");
				return false;
			}
			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "20" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 4. Next item to be dispensed is at the middle of the array
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			int itemsCount = 7;

			// check the correctness of the output
			if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
				System.out.println(
						"testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
								+ "the expected output when the vending machines contains matches with the provided "
								+ "item description with different expiration dates.");
				return false;
			}
			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		return true; // No bug detected
	}

	/**
	 * Testing containsItem defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testContainsItem() {
		// Define at least two test scenarios: (1) successful search returning true and
		// (2) unsuccessful
		// search returning false.

		// 1. Successful search returning true
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.containsItem("Water", items, itemsCount) != true) {
				System.out.println("testContainsItem-scenario 1. Problem detected: Your containsItem did not return "
						+ "true for successful search");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testContainsItem-scenario 1. Problem detected: Your containsItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 2. Unsuccessful search returning false.
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.containsItem("soda", items, itemsCount) != false) {
				System.out.println("testContainsItem-scenario 2. Problem detected: Your containsItem did not return "
						+ "false for unsuccessful search");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testContainsItem-scenario 2. Problem detected: Your containsItem did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		return true;
	}

	/**
	 * Testing getItemAtIndex defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testGetItemAtIndex() {
		// Define at least two test scenarios: (1) the provided index is out of the
		// range
		// 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
		// For each test scenario, ensure that the method returned the exact expected
		// string output
		// without making any changes to the contents of the array.

		// 1. Valid index returning a string representation
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (!VendingMachine.getItemAtIndex(1, items, itemsCount).equals("Chocolate (10)")) {
				System.out.println(
						"testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return a "
								+ "correct string representation for valid index");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 2. Invalid index returning a error message
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.getItemAtIndex(4, items, itemsCount) != "ERROR INVALID INDEX") {
				System.out.println(
						"testGetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did not return a "
								+ "error message for invalid index");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println("testGetItemAtIndex-scenario 2. Problem detected: Your getItemAtIndex did make "
						+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		return true;
	}

	/**
	 * Testing getItemOccurrences defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testGetItemsOccurrences() {
		// Define at least two test scenarios: (1) no match found so that the method
		// returns zero,
		// (2) the items array contains multiple occurrences of the provided item
		// description.

		// 1. No match found and returning zero.
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			int itemsCount = 7;

			// check the correctness of the output
			if (VendingMachine.getItemOccurrences("Soda", items, itemsCount) != 0) {
				System.out.println(
						"testGetItemsOccurrences-scenario 1. Problem detected: Your getItemOccurrences did not return zero "
								+ "for no match found");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println(
						"testGetItemsOccurrences-scenario 1. Problem detected: Your getItemOccurrences did make "
								+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		// 2. Items array contains multiple occurrences of the provided item and
		// returning its count
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			int itemsCount = 7;

			// check the correctness of the output
			if (VendingMachine.getItemOccurrences("Water", items, itemsCount) != 3) {
				System.out.println(
						"testGetItemsOccurrences-scenario 2. Problem detected: Your getItemOccurrences did not return "
								+ "exact count of items in vending machine");
				return false;
			}

			// Check that the method did not make change to the contents of the array items
			// passed as
			// input
			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "5" }, { "Candy", "30" }, { "Water", "15" }, { "Chocolate", "10" }, null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println(
						"testGetItemsOccurrences-scenario 2. Problem detected: Your getItemOccurrences did make "
								+ "changes to the content of the array passed as input.");
				return false;
			}
		}

		return true;
	}

	/**
	 * Testing addItem defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */

	public static boolean testAddItem() {
		// Define at least three test scenarios: (1) adding a new item to an empty
		// vending machine whose
		// size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty
		// non-full
		// vending machine, and (3) adding a new item to a full vending machine where
		// the provided
		// itemsCount equals the length of the provided items array.

		// For each tester scenario, check for the expected returned size of the vending
		// machine and
		// the expected content of the items array after the method call returns.

		// 1. adding a new item to an empty vending machine whose size is zero
		{
			String[][] items = new String[][] { null, null, null, null, null, null };
			int itemsCount = 0;

			// check the correctness of the output
			if (VendingMachine.addItem("Water", "15", items, itemsCount) != 1) {
				System.out.println("testAddItem-scenario 1. Problem detected: Your addItem did not return 1 "
						+ "for adding a new item to an empty vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, null, null, null, null, null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println("testAddItem-scenario 1. Problem detected: Your addItem didn't add "
						+ "a new item to an empty vending machine");
				return false;
			}
		}

		// 2. adding a new item to a non-empty non-full vending machine
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.addItem("Water", "20", items, itemsCount) != 4) {
				System.out
						.println("testAddItem-scenario 2. Problem detected: Your addItem did not return expected size "
								+ "for adding new item to a non-empty non-full vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "20" }, null, null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println("testAddItem-scenario 2. Problem detected: Your addItem didn't add "
						+ "a new item to a non-empty non-full vending machine");
				return false;
			}
		}

		// 3. adding a new item to a full vending machine
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" } };
			int itemsCount = 3;

			// check the correctness of the output
			if (VendingMachine.addItem("Water", "20", items, itemsCount) != 3) {
				System.out
						.println("testAddItem-scenario 3. Problem detected: Your addItem did not return expected size "
								+ "for adding new item to a full vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" } };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println("testAddItem-scenario 3. Problem detected: Your addItem make some change for adding "
						+ "a new item to a full vending machine");
				return false;
			}
		}

		return true;
	}

	/**
	 * Testing removeNextItem defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	
	public static boolean testRemoveNextItem() {
		// Define at least four test scenarios: (1) trying to remove a non-existing item
		// from a vending
		// machine (the vending machine can be empty or not), (2) the next item to be
		// removed matching
		// the provided description is at index 0 of the array, (3) the next item to be
		// removed is at
		// index itemsCount of the array (at the end of the array), and (4) the next
		// item to be removed
		// is at a middle index of the provided items array.

		// For each tester scenario, check for the expected returned size of the vending
		// machine and
		// the expected content of the items array after the method call returns.

		// 1. trying to remove a non-existing item from a vending machine
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output

			if (VendingMachine.removeNextItem("Soda", items, itemsCount) != 3) {
				System.out.println(
						"testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem did not return expected size "
								+ "for removing a non-existing item from a vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null,
					null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println(
						"testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem did make some change "
								+ "for removing a non-existing item from a vending machine");
				return false;
			}
		}

		// 2. the next item to be removed matching the provided description is at index
		// 0 of the array,
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output

			if (VendingMachine.removeNextItem("Water", items, itemsCount) != 2) {
				System.out.println(
						"testRemoveNextItem-scenario 2. Problem detected: Your removeNextItem did not return expected size "
								+ "for removing a item from a vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Chocolate", "10" }, { "Juice", "20" }, null, null, null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println(
						"testRemoveNextItem-scenario 2. Problem detected: Your removeNextItem didn't work as expected"
								+ "for removing a item from a vending machine");
				return false;
			}
		}

		// 3. the next item to be removed is at index itemsCount of the array
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "20" }, { "Chocolate", "5" } };
			int itemsCount = 5;

			// check the correctness of the output

			if (VendingMachine.removeNextItem("Chocolate", items, itemsCount) != 4) {
				System.out.println(
						"testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem did not return expected size "
								+ "for removing a item from a vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "20" }, null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println(
						"testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem didn't work as expected"
								+ "for removing a item from a vending machine");
				return false;
			}
		}

		// 4. the next item to be removed is at a middle index of the provided items
		// array.
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null,
					null };
			int itemsCount = 3;

			// check the correctness of the output

			if (VendingMachine.removeNextItem("Juice", items, itemsCount) != 2) {
				System.out.println(
						"testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem did not return expected size "
								+ "for removing a item from a vending machine");
				return false;
			}

			String[][] newItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, null, null, null };
			if (!Arrays.deepEquals(items, newItems)) {
				System.out.println(
						"testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem didn't work as expected"
								+ "for removing a item from a vending machine");
				return false;
			}
		}

		return true;
	}

	/**
	 * Testing getItemsSummary defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testGetItemsSummary() {
		// Define at least three scenarios: (1) the vending machine is empty, (2) the
		// vending machine
		// contains non duplicate items (no multiple items with the same description),
		// (3) the vending
		// machine contains multiple items with the same description at various index
		// locations.

		// 1. The vending machine is empty
		{
			String[][] items = new String[][] { null, null };
			int itemsCount = 0;

			// check the correctness of the output

			if (!VendingMachine.getItemsSummary(items, itemsCount).equals("")) {
				System.out.println(
						"testGetItemsSummary-scenario 1. Problem detected: Your getItemsSummary did not return expected output");
				return false;
			}

			String[][] originalItems = new String[][] { null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println(
						"testGetItemsSummary-scenario 1. Problem detected: Your getItemsSummary did make some change "
								+ "to a vending machine");
				return false;
			}
		}

		// 2. The vending machine contains non duplicate items
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" }, null,
					null };
			int itemsCount = 3;
			String[] summary_ans = new String[] { "Chocolate (1)", "Juice (1)", "Water (1)" };

			String summary_s = VendingMachine.getItemsSummary(items, itemsCount);

			String[] summary_arr = summary_s.split("\n", 0); // ??
			Arrays.sort(summary_arr);

			// check the correctness of the output

			if (!Arrays.equals(summary_arr, summary_ans)) {// needs check
				System.out.println(
						"testGetItemsSummary-scenario 2. Problem detected: Your getItemsSummary did not return expected output");
				return false;
			}

			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					null, null };
			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println(
						"testGetItemsSummary-scenario 2. Problem detected: Your getItemsSummary did make some change "
								+ "to a vending machine");
				return false;
			}
		}

		// 3. The vending machine contains multiple items with the same description at
		// various index locations.
		{
			String[][] items = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "20" }, { "Chocolate", "5" } };
			int itemsCount = 5;

			String summary_s = VendingMachine.getItemsSummary(items, itemsCount);
			String[] summary_ans = new String[] { "Chocolate (2)", "Juice (1)", "Water (2)" };

			String[] summary_arr = summary_s.split("\n", 0); // ??
			Arrays.sort(summary_arr);

			// check the correctness of the output

			if (!Arrays.equals(summary_arr, summary_ans)) {// needs check
				System.out.println(
						"testGetItemsSummary-scenario 3. Problem detected: Your getItemsSummary did not return expected output");
				return false;
			}

			String[][] originalItems = new String[][] { { "Water", "15" }, { "Chocolate", "10" }, { "Juice", "20" },
					{ "Water", "20" }, { "Chocolate", "5" } };

			if (!Arrays.deepEquals(items, originalItems)) {
				System.out.println(
						"testGetItemsSummary-scenario 3. Problem detected: Your getItemsSummary did make some change "
								+ "to a vending machine");
				return false;
			}
		}

		return true;
	}

	// This method returns false if any of the tester methods defined in this class
	// fails, and true
	// if no bug detected.
	/**
	 * Testing getItemsSummary defined in the VendingMachine
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 *         	// This method returns false if any of the tester methods defined in this class
	// fails, and true
	// if no bug detected.
	 */
	public static boolean runAllTests() {
		if (!testGetIndexNextItem()) {
			return false;
		}
		if (!testContainsItem()) {
			return false;
		}
		if (!testGetItemAtIndex()) {
			return false;
		}
		if (!testGetItemsOccurrences()) {
			return false;
		}
		if (!testAddItem()) {
			return false;
		}
		if (!testRemoveNextItem()) {
			return false;
		}
		if (!testGetItemsSummary()) {
			return false;
		}

		return true;
	}

	// main method to call the tester methods defined in this class
	public static void main(String[] args) {
		System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
		System.out.println("runAllTests(): " + runAllTests());
	}

}
