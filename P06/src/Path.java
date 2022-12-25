//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Path class for P06
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


import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Path {
	private ArrayList<Intersection> intersections;

	public Path() {
		intersections = new ArrayList<Intersection>();
	}

	public void addHead(Intersection toAdd) {
		if (intersections.isEmpty()) {
			intersections.add(toAdd);
			return;
		}
		Intersection head = getHead();
		int h_x = head.getX();
		int h_y = head.getY();
		int a_x = toAdd.getX();
		int a_y = toAdd.getY();
		if (!intersections.isEmpty()) {
			if (!((h_x == a_x && h_y - 1 == a_y) || (h_x - 1 == a_x && h_y == a_y))) {
				throw new IllegalArgumentException("Intersection to add is not valid");
			}
		}
		intersections.add(0, toAdd);
	}

	public void addTail(Intersection toAdd) {
		if (intersections.isEmpty()) {
			intersections.add(toAdd);
			return;
		}
		Intersection tail = getTail();
		int t_x = tail.getX();
		int t_y = tail.getY();
		int a_x = toAdd.getX();
		int a_y = toAdd.getY();
		if (!intersections.isEmpty()) {
			if (!((t_x + 1 == a_x && t_y == a_y) || (t_x == a_x && t_y + 1 == a_y))) {
				throw new IllegalArgumentException("Intersection to add is not valid");
			}
		}
		intersections.add(toAdd);
	}

	public Intersection getHead() {
		if (intersections.isEmpty()) {
			throw new NoSuchElementException("Path is empty");
		}
		return intersections.get(0);
	}

	public Intersection getTail() {
		if (intersections.isEmpty()) {
			throw new NoSuchElementException("Path is empty");
		}
		return intersections.get(intersections.size() - 1);
	}

	public int length() {
		return intersections.size();
	}

	public String toString() {
		if (intersections.isEmpty()) {
			return "Empty";
		}
		String ret = "";
		int l = length();
		for (int i = 0; i < l - 1; i++) {
			ret += intersections.get(i).toString() + "->";
		}
		ret += intersections.get(l - 1);
		return ret;
	}
}
