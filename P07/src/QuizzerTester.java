//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    QuizzerTester class for P07
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
 */

public class QuizzerTester {

	public static boolean testMultipleChoiceQuestion() {
		return true;

	}

	public static boolean testLinkedNode() {
		return true;

	}

	public static boolean testCorrectQuestionsIterator() {
		return true;

	}

	public static boolean testInCorrectQuestionsIterator() {
		return true;

	}

	public static boolean testQuizQuestionsIterator() {
		return true;

	}

	public static boolean testAddLast() {
		return true;

	}

	public static boolean testRemoveLast() {
		return true;

	}

	public static boolean testRemoveFirst() {
		return true;

	}

	public static boolean testRemove() {
		return true;

	}

	public static boolean testAdd() {
		return true;

	} 

	public static boolean testAddFirst() {
		return true;

	}

	public static boolean runAllTests() {
		if (!testMultipleChoiceQuestion()) {
			System.out.println("testMultipleChoiceQuestion failed.");
			return false;
		}
		if (!testLinkedNode()) {
			System.out.println("testLinkedNode failed.");
			return false;
		}
		if (!testCorrectQuestionsIterator()) {
			System.out.println("testCorrectQuestionsIterator failed.");
			return false;
		}
		if (!testInCorrectQuestionsIterator()) {
			System.out.println("testInCorrectQuestionsIterator failed.");
			return false;
		}
		if (!testQuizQuestionsIterator()) {
			System.out.println("testQuizQuestionsIterator failed.");
			return false;
		}
		if (!testAddLast()) {
			System.out.println("testAddLast failed.");
			return false;
		}
		if (!testRemoveLast()) {
			System.out.println("testRemoveLast failed.");
			return false;
		}
		if (!testRemoveFirst()) {
			System.out.println("testRemoveFirst failed.");
			return false;
		}
		if (!testRemove()) {
			System.out.println("testRemove failed.");
			return false;
		}
		if (!testAdd()) {
			System.out.println("testAdd failed.");
			return false;
		}
		if (!testAddFirst()) {
			System.out.println("testAddFirst failed.");
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		runAllTests();
	}
}
