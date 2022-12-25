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
 * Player class for Dragon Treasure Game
 *
 */

import java.util.ArrayList;

public class Player {
	private Room currentRoom;

	/**
	 * Constructor for a player object. Assigns values to all non-static fields.
	 * 
	 * @param currentRoom - the current location of the player
	 */
	Player(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * Getter for this player's current room.
	 * 
	 * @return The current location of the player
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Setter for this player's current room.
	 * 
	 * @param newRoom - the location that the player is moving to
	 */
	public void changeRoom(Room newRoom) {
		currentRoom = newRoom;
	}

	/**
	 * Determines whether or not the player can move to the given destination room.
	 * A valid player move is ONLY to adjacent rooms.
	 * 
	 * @param destination - room player wants to move to
	 * 
	 * @return true if it is a valid movement, false otherwise
	 */
	public boolean canMoveTo(Room destination) {
		boolean ret = currentRoom.isAdjacent(destination);
		return ret;
	}

	/**
	 * Determines whether or not the player needs to teleport. Players teleport when
	 * their current room is of type PORTAL
	 * 
	 * @return true if they should teleport, false otherwise
	 */
	public boolean shouldTeleport() {
		return currentRoom.getType() == RoomType.PORTAL;
	}

	/**
	 * Gets the list of rooms adjacent to where the player is currently at.
	 * 
	 * @return list of rooms adjacent to the current room
	 */
	public ArrayList<Room> getAdjacentRoomsToPlayer() {
		return currentRoom.getAdjacentRooms();
	}

	/**
	 * Determines whether or not the given dragon is in a nearby room.
	 * 
	 * @param d - the dragon to check if nearby
	 * 
	 * @return true if the dragon is nearby, false otherwise
	 */
	public boolean isDragonNearby(Dragon d) {
		return currentRoom.isAdjacent(d.getCurrentRoom());
	}

	/**
	 * Determines whether or not a portal room is in a nearby room.
	 * 
	 * @return true if a portal room is nearby, false otherwise
	 */
	public boolean isPortalNearby() {
		ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
		for (int i = 0; i < adjRooms.size(); i++) {
			if (adjRooms.get(i).getType() == RoomType.PORTAL) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines whether or not the treasure room is in a nearby room.
	 * 
	 * @return true if the treasure room is nearby, false otherwise
	 */
	public boolean isTreasureNearby() {
		ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
		for (int i = 0; i < adjRooms.size(); i++) {
			if (adjRooms.get(i).getType() == RoomType.TREASURE) {
				return true;
			}
		}
		return false;
	}

}
