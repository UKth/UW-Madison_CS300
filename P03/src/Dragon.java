//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Game
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
 * Dragon class for Dragon Treasure Game
 *
 */

import java.util.Random;
import java.util.ArrayList;

public class Dragon {
	private Room currentRoom; // current location of the dragon
	private Random randGen; // random num generator used for moving
	private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

	/**
	 * Constructor for a dragon object. Assigns values to all non-static fields.
	 * 
	 * @param currentRoom - the current location of the dragon
	 */
	public Dragon(Room currentRoom) {
		this.currentRoom = currentRoom;
		randGen = new Random();
	}

	/**
	 * Getter for this Dragon's currentRoom
	 * 
	 * @return this Dragon's current room
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Dragon picks one of the rooms at random and moves there if possible. If it is
	 * not a valid move, then it will pick again. Dragons abide by the follow rules
	 * when moving: 1) The dragon can only move into rooms that are adjacent to it.
	 * 2) The dragon CANNOT move into portal rooms.
	 * 
	 */
	public void changeRooms() {
		ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
		while (true) {
			int nextRoomIdx = randGen.nextInt(adjRooms.size());
			Room nextRoom = adjRooms.get(nextRoomIdx);
			if (nextRoom.getType() != RoomType.PORTAL) {
				currentRoom = nextRoom;
				break;
			}
		}
	}

	/**
	 * Returns the string that is the dragon class's warning, indicating that there
	 * is one nearby.
	 * 
	 * @return The dragon warning message string
	 */
	public static String getDragonWarning() {
		return DRAGON_WARNING;
	}

}
