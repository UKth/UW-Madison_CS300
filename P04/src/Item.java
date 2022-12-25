
public class Item {
	private String description;
	private int expirationDate;

	public Item(String description, int expirationDate) {
		if (description == null || description.trim().equals("") ||  expirationDate < 0) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.description = description;
		this.expirationDate = expirationDate;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	@Override
	public String toString() {
		return description + ": " + expirationDate;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Item) {
			Item otherItem = (Item) other;
			return description.equals(otherItem.description);
		}
		return false;
	}

}
