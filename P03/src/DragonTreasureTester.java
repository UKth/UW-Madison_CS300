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
 * Tester class for Dragon Treasure Game
 *
 */

import java.util.ArrayList;

public class DragonTreasureTester {

	/**
	 * Main method, executes every test methods
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("testRoomInstanceMethods: " + testRoomInstanceMethods());
		System.out.println("testRoomStaticMethods: " + testRoomStaticMethods());

		System.out.println("testPlayerCanMoveTo:" + testPlayerCanMoveTo());
		System.out.println("testPlayerShouldTeleport: " + testPlayerShouldTeleport());
		System.out.println("testPlayerDetectNearbyRooms: " + testPlayerDetectNearbyRooms());
		System.out.println("testDragonChangeRooms: " + testDragonChangeRooms());
	}

	/**
	 * Test every instance methods of Room class
	 * 
	 */
	public static boolean testRoomInstanceMethods() {

		try {
			Room testRoom1 = new Room(1, "Test room1");
			Room testRoom2 = new Room(2, "Test room2");
			Room testRoom3 = new Room(3, "Test room3");

			if (testRoom1.getType() != RoomType.NORMAL) {
				throw new Exception("Room type isn't NORMAL");
			}

			if (testRoom1.getID() != 1) {
				throw new Exception("Room id isn't same with parameter");
			}
			testRoom1.addToAdjacentRooms(testRoom2);
			testRoom1.addToAdjacentRooms(testRoom3);

			ArrayList<Room> adjRooms = testRoom1.getAdjacentRooms();
			if (adjRooms.size() != 2) {
				throw new Exception("getAdjacentRooms doesn't worked as expected");
			}
			if (!adjRooms.get(0).equals(testRoom2) || !adjRooms.get(1).equals(testRoom3)) {
				throw new Exception("addToAdjacentRooms or getAdjacentRooms doesn't worked as expected");
			}

			if (testRoom1.getRoomDescription() != "Test room1") {
				throw new Exception("Room description isn't same with parameter");
			}

			testRoom1.setRoomType(RoomType.PORTAL);
			if (testRoom1.getType() != RoomType.PORTAL) {
				throw new Exception("setRoomType doesn't worked as expected");
			}

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Test every static methods of Room class
	 * 
	 */
	public static boolean testRoomStaticMethods() {

		try {
			Room.assignTeleportLocation(2);

			if (Room.getPortalWarning() != "You feel a distortion in space nearby.\n") {
				throw new Exception("getPortalWarning doesn't worked as expected");
			}
			if (Room.getTreasureWarning() != "You sense that there is treasure nearby.\n") {
				throw new Exception("getTreasureWarning doesn't worked as expected");
			}
			if (Room.getTeleportationRoom() != 2) {
				throw new Exception("assignTeleportLocation or getTeleportationRoom doesn't worked as expected");
			}

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;

	}

	/**
	 * Test canMoveTo method of Player class
	 * 
	 */
	public static boolean testPlayerCanMoveTo() {
		try {

			Room testRoom1 = new Room(1, "Test room1");
			Room testRoom2 = new Room(2, "Test room2");

			testRoom1.addToAdjacentRooms(testRoom2);

			Player testPlayer = new Player(testRoom1);

			if (!testPlayer.canMoveTo(testRoom2)) {
				throw new Exception("canMoveTo doesn't worked as expected");
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Test shouldTeleport method of Player class
	 * 
	 */
	public static boolean testPlayerShouldTeleport() {
		try {

			Room testRoom1 = new Room(1, "Test room1");

			testRoom1.setRoomType(RoomType.PORTAL);

			Player testPlayer = new Player(testRoom1);

			if (!testPlayer.shouldTeleport()) {
				throw new Exception("shouldTeleport doesn't worked as expected");
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Test isPortalNearby and isTreasureNearby method of Player class
	 * 
	 */
	public static boolean testPlayerDetectNearbyRooms() {

		try {

			Room testRoom1 = new Room(1, "Test room1");
			Room testRoom2 = new Room(2, "Test room2");
			Room testRoom3 = new Room(3, "Test room3");

			testRoom1.addToAdjacentRooms(testRoom2);
			testRoom1.addToAdjacentRooms(testRoom3);

			testRoom2.setRoomType(RoomType.PORTAL);
			testRoom3.setRoomType(RoomType.TREASURE);

			Player testPlayer = new Player(testRoom1);

			if (!testPlayer.isPortalNearby()) {
				throw new Exception("isPortalNearby doesn't worked as expected");
			}
			if (!testPlayer.isTreasureNearby()) {
				throw new Exception("isTreasureNearby doesn't worked as expected");
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Test changeRooms method of Dragon class
	 * 
	 */
	public static boolean testDragonChangeRooms() {

		try {
			Room testRoom1 = new Room(1, "Test room1");
			Room testRoom2 = new Room(2, "Test room2");
			Room testRoom3 = new Room(3, "Test room3");

			testRoom1.addToAdjacentRooms(testRoom2);
			testRoom1.addToAdjacentRooms(testRoom3);

			Dragon d = new Dragon(testRoom1);

			d.changeRooms();

			if (!testRoom1.getAdjacentRooms().contains(d.getCurrentRoom())) {
				throw new Exception("changeRooms doesn't worked as expected");
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
