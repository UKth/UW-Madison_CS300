//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    PathUtils class for P06
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

public class PathUtils {
	public PathUtils() {

	}


	public static int countPaths(Intersection start, Intersection end) {
		if(start.getX() > end.getX()) {
			return 0;
		}
		if(start.getY() > end.getY()) {
			return 0;
		}
		int cnt = 0;
		int s_x = start.getX();
		int s_y = start.getY();
		int e_x = end.getX();
		int e_y = end.getY();

		if (s_x == e_x && s_y == e_y) {
			return 1;
		}

		if (s_x < e_x) {
			cnt += countPaths(new Intersection(s_x + 1, s_y), end);
		}
		if (s_y < e_y) {
			cnt += countPaths(new Intersection(s_x, s_y + 1), end);
			
		}
		return cnt;
	}

	public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
		if(start.getX() > end.getX()) {
			return new ArrayList<Path>();
		}
		if(start.getY() > end.getY()) {
			return new ArrayList<Path>();
		}
		
		ArrayList<Path> allPaths = new ArrayList<Path>();
		int s_x = start.getX();
		int s_y = start.getY();
		int e_x = end.getX();
		int e_y = end.getY();

		if (s_x == e_x && s_y == e_y) {
			Path path = new Path();
			path.addTail(end);
			allPaths.add(path);
			return allPaths;
		}

		if (s_x < e_x) {
			ArrayList<Path> x_paths = findAllPaths(new Intersection(s_x + 1, s_y), end);
			for (int i = 0; i < x_paths.size(); i++) {
				Path path = x_paths.get(i);
				path.addHead(start);
				allPaths.add(path);
			}
		}
		if (s_y < e_y) {
			ArrayList<Path> y_paths = findAllPaths(new Intersection(s_x, s_y + 1), end);
			for (int i = 0; i < y_paths.size(); i++) {
				Path path = y_paths.get(i);
				path.addHead(start);
				allPaths.add(path);
			}
		}
		return allPaths;
	}
}
