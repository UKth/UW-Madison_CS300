/**
 * A class representing a single UFO object that can move, fire, and be hit.
 * 
 */
public class UFO {

	public static final int SIMPLE_SAUCER = 0;

	private int xPosition; // current x position of UFO's center
	private int yPosition; // current y position of UFO's center
	private int UFOType; // type of UFO
	public int direction = 1;
	public int tick = 0;
	public int hit_cnt = 0;

	/**
	 * Constructs an UFO object given its type and initial position
	 * 
	 * @param startX  initial x coordinate
	 * @param startY  initial y coordinate
	 * @param UFOType int representing the type of UFO this is.
	 */
	public UFO(int startX, int startY, int UFOType) {
		// TODO: TASK 1 - write your code here
	}

	/**
	 * Get the current x coordinate of the center of this UFO.
	 * 
	 * @return The current x coordinate of the center of this UFO.
	 */
	public int getXPosition() {
		// TODO: TASK 1 - write your code
		// replace the return statement below
		return this.xPosition;
	}

	/**
	 * Get the current y coordinate of the center of this UFO.
	 * 
	 * @return The current y coordinate of the center of this UFO.
	 */
	public int getYPosition() {
		// TODO: TASK 1 - write your code
		// replace the return statement below
		return this.yPosition;
	}

	/**
	 * Get an int represented the type for this UFO
	 * 
	 * @return The int representing the type of this UFO
	 */
	public int getUFOType() {
		// TODO: TASK 1 - write your code
		// replace the return statement below
		return this.UFOType;
	}

	/**
	 * Updates the position of the UFO for the next time it is redrawn.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may be used later
	 *                 in the lab to determine movement some UFO types.
	 */
	public void takeOneStep(Defender defender) {
		// TODO: TASK 2 - write your code here
		this.xPosition += 3 * direction;
		if (this.xPosition + SpaceGame.UFO_SIZE / 2 > SpaceGame.getMaximumX() && direction == 1) {
			direction = -1;
		} else if (this.xPosition - SpaceGame.UFO_SIZE / 2 < 0 && direction == -1) {
			direction = 1;
		}
	}

	/**
	 * Return true if this UFO fires this during this tick.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may be used later
	 *                 in the lab to determine firing for some UFO types.
	 * @return Whether or not this UFO shoots on this tick.
	 */
	public boolean shootsThisTurn(Defender defender) {
		// TODO: TASK 3 - write your code here
		// replace the return statement below
		if (tick >= 6) {
			tick = 0;
			return true;
		}
		tick += 1;
		return false;
	}

	/**
	 * Return the bullet this UFO is about to fire.
	 * 
	 * @param defender The Defender object. Ignore for now, but it may be used later
	 *                 in the lab to determine firing for some UFO types.
	 * @return The bullet this UFO is about to fire.
	 */
	public Laser fireWeapon(Defender defender) {
		// TODO: TASK 3 - write your code here
		// replace the return statement below
		Laser l = new Laser(this.xPosition, this.yPosition, 0, 4);

		return l;
	}

	/**
	 * Returns whether this UFO intersects this Laser
	 * 
	 * @param theLaser a laser that may be near the UFO.
	 * @return true if this UFO intersects this Laser
	 */
	public boolean isHitByLaser(Laser theLaser) {
		// TODO: TASK 4 - write your code here
		// replace the return statement below
		int d_x = this.xPosition - theLaser.getXPosition();
		int d_y = this.yPosition - theLaser.getYPosition();
		double d = Math.pow(Math.pow(d_x, 2) + Math.pow(d_y, 2), 0.5);
		int min_d = SpaceGame.UFO_SIZE / 2;
		
		return d < min_d;
	}

	/**
	 * Updates the Object to record that it has been hit by a Laser. This method is
	 * called every time the UFO is struck by a Laser.
	 */
	public void recordHit() {
		hit_cnt += 1;
		System.out.println(hit_cnt);
	}

	/**
	 * Returns true if this UFO has been destroyed.
	 * 
	 * @return true if the UFO has been destroyed.
	 */
	public boolean removeMeFromGame() {
		if(hit_cnt >= 2) {
			return true;
		}
		return false;
	}

}
