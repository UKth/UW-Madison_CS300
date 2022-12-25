import java.lang.Comparable;

public class Chugimon implements Comparable<Chugimon> {
	public static final int MIN_ID = ChugidexUtility.MIN_CHUGI_ID;
	public static final int MAX_ID = ChugidexUtility.MAX_CHUGI_ID;
	private final String NAME;
	private final int FIRST_ID;
	private final int SECOND_ID;
	private final ChugiType PRIMARY_TYPE;
	private final ChugiType SECONDARY_TYPE;
	private final double HEIGHT;
	private final double WEIGHT;

	public Chugimon(int firstID, int secondID) {
		if (151 < firstID || firstID < 1) {
			throw new IllegalArgumentException("");
		}
		if (151 < secondID || secondID < 1) {
			throw new IllegalArgumentException("");
		}
		if (firstID == secondID) {
			throw new IllegalArgumentException("");
		}

		FIRST_ID = firstID;
		SECOND_ID = secondID;
		NAME = ChugidexUtility.getChugimonName(firstID, secondID);
		ChugiType[] types = ChugidexUtility.getChugimonTypes(firstID, secondID);
		PRIMARY_TYPE = types[0];
		if (types.length > 1) {
			SECONDARY_TYPE = types[1];
		} else {
			SECONDARY_TYPE = null;
		}
		HEIGHT = ChugidexUtility.getChugimonHeight(firstID, secondID);
		WEIGHT = ChugidexUtility.getChugimonWeight(firstID, secondID);
	}

	public String getName() {
		return NAME;
	}

	public int getFirstID() {
		return FIRST_ID;
	}

	public int getSecondID() {
		return SECOND_ID;
	}

	public ChugiType getPrimaryType() {
		return PRIMARY_TYPE;
	}

	public ChugiType getSecondaryType() {
		return SECONDARY_TYPE;
	}

	public double getHeight() {
		return HEIGHT;
	}

	public double getWeight() {
		return WEIGHT;
	}

	public int compareTo(Chugimon otherChugi) {
		String otherChugiName = otherChugi.getName();
		if (NAME != otherChugiName) {
			return NAME.compareTo(otherChugiName);
		}
		int otherChugiFID = otherChugi.getFirstID();
		if (FIRST_ID != otherChugiFID) {
			return FIRST_ID - otherChugiFID;
		}
		return SECOND_ID - otherChugi.getSecondID();
	}

	public String toString() {
		return NAME + "#" + FIRST_ID + "." + SECOND_ID;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Chugimon)) {
			return false;
		}
		Chugimon otherChugi = (Chugimon) other;
		return NAME.equals(otherChugi.getName()) && FIRST_ID == otherChugi.getFirstID()
				&& SECOND_ID == otherChugi.getSecondID();
	}
}
