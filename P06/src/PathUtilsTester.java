//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    PathUtilsTester class for P06
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
import java.util.Scanner;

public class PathUtilsTester {
	public PathUtilsTester() {

	}

	public static boolean testCountPathsNoPath() {
		if (PathUtils.countPaths(new Intersection(1, 0), new Intersection(0, 0)) != 0) {
			System.out.println("testCountPathsNoPath failed.");
			return false;
		}
		if (PathUtils.countPaths(new Intersection(0, 1), new Intersection(0, 0)) != 0) {
			System.out.println("testCountPathsNoPath failed.");
			return false;
		}
		return true;
	}

	public static boolean testCountPathsOnePath() {
		if (PathUtils.countPaths(new Intersection(0, 0), new Intersection(0, 0)) != 1) {
			System.out.println("testCountPathsOnePath failed.");
			return false;
		}
		if (PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 0)) != 1) {
			System.out.println("testCountPathsOnePath failed.");
			return false;
		}
		return true;
	}

	public static boolean testCountPathsRecursive() {
		if (PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 2)) != 3) {
			System.out.println("testCountPathsRecursive failed.");
			return false;
		}
		if (PathUtils.countPaths(new Intersection(0, 0), new Intersection(2, 1)) != 3) {
			System.out.println("testCountPathsRecursive failed.");
			return false;
		}
		return true;
	}

	public static boolean testFindAllPathsNoPath() {
		ArrayList<Path> paths = PathUtils.findAllPaths(new Intersection(1, 0), new Intersection(0, 0));

		if (!paths.isEmpty()) {
			System.out.println("testFindAllPathsNoPath failed.");
			return false;
		}
		paths = PathUtils.findAllPaths(new Intersection(0, 1), new Intersection(0, 0));
		if (!paths.isEmpty()) {
			System.out.println("testFindAllPathsNoPath failed.");
			return false;
		}
		return true;
	}

	public static boolean testFindAllPathsOnePath() {
		ArrayList<Path> paths = PathUtils.findAllPaths(new Intersection(0, 0), new Intersection(0, 0));

		if (paths.size() != 1) {
			System.out.println("testFindAllPathsOnePath failed1.");
			return false;
		}
		Path path = paths.get(0);
		if (path.length() != 1 || !path.getHead().equals(new Intersection(0, 0))) {
			System.out.println("testFindAllPathsOnePath failed2.");
			return false;
		}
		paths = PathUtils.findAllPaths(new Intersection(0, 0), new Intersection(0, 1));
		if (paths.size() != 1) {
			System.out.println("testFindAllPathsOnePath failed3.");
			return false;
		}
		path = paths.get(0);
		if (path.length() != 2 || !path.getHead().equals(new Intersection(0, 0))
				|| !path.getTail().equals(new Intersection(0, 1))) {
			System.out.println("testFindAllPathsOnePath failed4.");
			return false;
		}
		return true;
	}

	public static boolean testFindAllPathsRecursive() {
		return true;
	}

	public static void main(String[] args) {
		if (!testCountPathsNoPath()) {
			return;
		}

		if (!testCountPathsOnePath()) {
			return;
		}

		if (!testCountPathsRecursive()) {
			return;
		}

		if (!testFindAllPathsNoPath()) {
			return;
		}

		if (!testFindAllPathsOnePath()) {
			return;
		}

		if (!testFindAllPathsRecursive()) {
			return;
		}
		System.out.println("All tests passed");
		try (Scanner keyboard = new Scanner(System.in)) {
			int startX, startY, endX, endY;
			String input = "Y";
			while (input.equalsIgnoreCase("Y")) {
				System.out.print("Enter starting X coordinate: ");
				startX = keyboard.nextInt();
				System.out.print("Enter starting Y coordinate: ");
				startY = keyboard.nextInt();
				System.out.print("Enter ending X coordinate: ");
				endX = keyboard.nextInt();
				System.out.print("Enter ending Y coordinate: ");
				endY = keyboard.nextInt();
				Intersection start = new Intersection(startX, startY);
				Intersection end = new Intersection(endX, endY);
				System.out.println("Number of paths from start to end: " + PathUtils.countPaths(start, end));
				System.out.println("List of possible paths:");
				for (Path p : PathUtils.findAllPaths(start, end)) {
					System.out.println(p);
				}
				do {
					System.out.print("Try another route? (Y/N): ");
					input = keyboard.next();
				} while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
			}
		}
	}
}
