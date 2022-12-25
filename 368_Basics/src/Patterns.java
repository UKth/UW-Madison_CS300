
public class Patterns {
	public static String getNStars(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += "* ";
		}
		return s;
	}

	public static String getNSquare(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += getNStars(n) + "\n";
		}
		return s;
	}

	public static String getRightTriangle(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += getNStars(i + 1) + "\n";
		}
		return s;
	}

	public static String getCenteredTriangle(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				s += " ";
			}
			s += getNStars(i + 1) + "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(getNStars(3));
		System.out.println();
		System.out.println(getNSquare(3));
		System.out.println(getRightTriangle(3));
		System.out.println(getCenteredTriangle(3)); // CHALLENGE METHOD
	}
}
