//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Java GUI Walking simulator file
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

import java.io.File;
import java.util.Random;
import processing.core.PImage;

/**
 * 
 * @author Seungwook Seo
 * 
 *         Java GUI walking simulator class
 *
 */

public class WalkingSim {
	private static Random randGen;
	private static int bgColor;
	private static PImage[] frames;
	private static Walker[] walkers;

	/**
	 * main method
	 * 
	 * Run GUI application/
	 * 
	 */
	public static void main(String[] args) {
		Utility.runApplication();
	}

	/**
	 * setup method
	 * 
	 * Initialize randGen, bgcolor, loadImages in framse, create walkers.
	 * 
	 */
	public static void setup() {
		randGen = new Random();
		bgColor = randGen.nextInt();

		frames = new PImage[Walker.NUM_FRAMES];

		for (int index = 0; index < Walker.NUM_FRAMES; index++) {
			frames[index] = Utility.loadImage("images" + File.separator + "walk-" + index + ".png");
		}

		walkers = new Walker[8];

		int iter = randGen.nextInt(1, walkers.length + 1);
		for (int i = 0; i < iter; i++) {
			walkers[i] = new Walker(randGen.nextFloat(0, Utility.width()), randGen.nextFloat(0, Utility.height()));

		}

	}

	/**
	 * draw method
	 * 
	 * Draw every walkers in every frames.
	 * 
	 */
	public static void draw() {
		Utility.background(bgColor);
		for (int i = 0; i < walkers.length; i++) {
			Walker walker = walkers[i];
			if (walker == null) {
				break;
			}
			if (walker.isWalking()) {
				walker.setPositionX((walker.getPositionX() + 3) % Utility.width());
				walker.update();
			}
			Utility.image(frames[walker.getCurrentFrame()], walker.getPositionX(), walker.getPositionY());
		}
	}

	/**
	 * isMouseOver method
	 * 
	 * check if the coordinate of mouse is on the walker's image.
	 * 
	 */
	public static boolean isMouseOver(Walker walker) {
		int mx = Utility.mouseX();
		int my = Utility.mouseY();
		float wx = walker.getPositionX();
		float wy = walker.getPositionY();
		PImage frame = frames[walker.getCurrentFrame()];
		int half_w = frame.width / 2;
		int half_h = frame.height / 2;

		return (wx - half_w < mx && mx < wx + half_w) && (wy - half_h < my && my < wy + half_h);
	}

	/**
	 * mousePressed method
	 * 
	 * check if mouse's coordinate is on any walker's image.
	 * 
	 */
	public static void mousePressed() {
		for (int i = 0; i < walkers.length; i++) {
			Walker walker = walkers[i];
			if (walker == null) {
				break;
			}
			if (isMouseOver(walker)) {
				walker.setWalking(true);
				return;
			}
		}
	}

	/**
	 * keyPressed method
	 * 
	 * Add another walker if a/A pressed, and stop every walkers if s/S pressed.
	 * 
	 */
	public static void keyPressed(char key) {
		if (key == 'a' || key == 'A') {
			for (int i = 0; i < walkers.length; i++) {
				if (walkers[i] == null) {
					walkers[i] = new Walker(randGen.nextFloat(0, Utility.width()),
							randGen.nextFloat(0, Utility.height()));
					break;
				}
			}
		}
		if (key == 's' || key == 'S') {
			for (int i = 0; i < walkers.length; i++) {
				Walker walker = walkers[i];
				if (walker == null) {
					break;
				}
				walker.setWalking(false);
			}
		}
	}

}
