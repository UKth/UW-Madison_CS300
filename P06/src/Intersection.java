//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Intersection class for P06
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

public class Intersection {
	private final int x;
	private final int y;

	public Intersection(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public boolean equals(Object o) {
		if(o instanceof Intersection) {
			Intersection t = (Intersection) o;
			return t.getX() == x && t.getY() == y;
		}
		return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Intersection goEast() {
		return new Intersection(x + 1, y);
	}

	public Intersection goNorth() {
		return new Intersection(x, y + 1);
	}

	public Intersection goSouth() {
		return new Intersection(x, y - 1);
	}

	public Intersection goWest() {
		return new Intersection(x - 1, y);
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
