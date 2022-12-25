import java.util.Random;
import processing.core.PImage;

public class Lab4Main {
	private static int color;
	private static Random rand;
	private static PImage button;
	
	
	public static void main(String[] args) {
		Utility.runApplication();
	}
	public static void setup() {
		rand = new Random();

		color = Utility.color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		
		
		button = Utility.loadImage("button.png");
		
	}
	public static void draw() {
		Utility.background(color);
		Utility.image(button, Utility.width()/2, Utility.height()/2);
	}
	private static boolean isMouseOverButton(int x, int y) {
		
		
		return true;
	}
}
