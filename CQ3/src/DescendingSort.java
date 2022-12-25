///////////////////////// CUMULATIVE QUIZ FILE HEADER //////////////////////////
// Full Name: Seungwook Seo
// Campus ID: 9084030874
// WiscEmail: sseo36@wisc.edu
// (TODO: fill this out)
////////////////////////////////////////////////////////////////////////////////

/**
 * This is a static, utility class containing methods to accomplish a recursive
 * sort of an array of Story objects. You do NOT have to implement the Story
 * class; it is provided for you in its entirety at the bottom of this file.
 */
public class DescendingSort {

	/**
	 * Finds the longest Story using a recursive helper method.
	 * 
	 * @param shelf a full, perfect-size array of Stories with length >= 1
	 * @return the Story from that shelf which is longer than every other Story
	 */
	public static Story getLongestStory(Story[] shelf) {
		// suppose the last element of the shelf is the longest
		Story maxStory = shelf[shelf.length - 1];

		// get the larger of maxStory and the elements in the rest of the array
		return getLongestStoryHelper(maxStory, shelf, shelf.length - 2);
	}

	/**
	 * A recursive helper method to find the larger of: - the argument maxStory, and
	 * - the longest Story in the rest of shelf, from 0 to index (inclusive)
	 * 
	 * @param maxStory the maximum value over all indexes from index+1 to the end of
	 *                 the shelf
	 * @param shelf    a full, perfect-size array of Stories with length >= 1
	 * @param index    the last index of the un-searched part of the shelf. valid
	 *                 values: -1 to shelf.length-2 (inclusive) If index == -1, the
	 *                 un-searched part of the shelf is empty.
	 * @return the maximum value over all indexes
	 */
	private static Story getLongestStoryHelper(Story maxStory, Story[] shelf, int index) {
		/////////// BASE CASE ///////////
		// TODO
		// 1. If the un-searched part of the shelf is empty, return the longest story
		if (index == -1) {
			return maxStory;
		}

		///////// RECURSIVE CASE ////////
		// TODO
		// 2. Define the recursive case for this algorithm
		Story mx = maxStory;
		if (maxStory.compareTo(shelf[index]) < 0) {
			mx = shelf[index];
//		 System.out.println("change");
		}

		// 3. Return the longest story
		return getLongestStoryHelper(mx, shelf, index - 1);
	}

	/**
	 * A tester method for getLongestStory, which you must complete. This method
	 * WILL be tested.
	 * 
	 * @return true if getLongestStory produces the expected result; false otherwise
	 */
	public static boolean testGetLongestStory() {
		// TODO
		// 4. Create a Story[] array containing at least 3 Story objects with different
		// titles and wordcounts (see
		// testDescendingSort() below for examples)

		Story[] testShelf = new Story[] { new Story("Troll-Bridge", 428), new Story("Murder Mysteries", 2075),
				new Story("Harlequin Valentine", 826), new Story("How To Talk To Girls At Parties", 1833) };

		// 5. Create a NEW Story object that matches the Story in the array that has the
		// longest word count
		// (e.g. for Stories with word counts [532, 715, 456], you'd create a new Story
		// with word count 715).
		Story longest = new Story("Murder Mysteries", 2075);

		// 6. Call getLongestStory() on your Story[] array and save the result
		Story getLongest = getLongestStory(testShelf);

		// 7. Compare this result against your expected value and return false if they
		// do not match.
		// CAREFUL: the equals() method is NOT overridden in the Story class. To find
		// equivalent Story
		// objects, use Story's compareTo() method.

		return longest.compareTo(getLongest) == 0;

		// OPTIONAL: implement additional tests to verify the method works!

		// 8. Return true if all tests in this method are passed.
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	// //
	// Checkpoint: SAVE YOUR SOURCE FILE (Ctrl/Cmd + S) and RUN THIS TEST before you
	///////////////////////////////////////////////////////////////////////////////////////////// continue.
	///////////////////////////////////////////////////////////////////////////////////////////// //
	// //
	/////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns a new array of size shelf.length-1 which contains every Story in
	 * shelf that is NOT the Story to remove. The method should NOT make any changes
	 * to the contents of shelf.
	 *
	 * Note that while there is no equals() method defined in Story, equal Stories
	 * will have a compareTo() value of 0.
	 * 
	 * @param shelf    a full, perfect-size array of Stories with length >= 1
	 * @param toRemove the Story to remove from the shelf
	 * @return an array containing every Story from shelf EXCEPT toRemove, and NO
	 *         null values
	 */
	public static Story[] remove(Story[] shelf, Story toRemove) {
		// TODO
		// 9. Create a new Story array of the correct size
		Story[] newShelf = new Story[shelf.length - 1];

		// 10. Iterate through the shelf and add all Stories that are NOT the Story
		// toRemove
		// (You may assume there are no duplicates.)
		int deleted = 0;
		for (int i = 0; i < shelf.length - 1; i++) {
			if (shelf[i].compareTo(toRemove) == 0) {
				deleted = 1;
			}
			newShelf[i] = shelf[i + deleted];
		}

		// 11. Return the resulting array
		return newShelf; // default return statement added to avoid compiler errors. Feel free to change
							// it.
	}

	/**
	 * A tester method for remove(), which you must complete. This method WILL be
	 * tested.
	 * 
	 * @return true if remove() produces the expected result; false otherwise
	 */
	public static boolean testRemove() {
		// TODO
		// 12. Create a Story[] array containing at least 3 Story objects with different
		// titles and wordcounts (see
		// testDescendingSort() below for examples)

		Story[] testShelf = new Story[] { new Story("Troll-Bridge", 428), new Story("Murder Mysteries", 2075),
				new Story("Harlequin Valentine", 826), new Story("How To Talk To Girls At Parties", 1833) };

		// 13. Create a NEW Story object that is identical to one of the Story objects
		// from your array
		Story toRemove = new Story("Troll-Bridge", 428);

		// 14. Call remove() on your array and Story object and save the result
		Story[] removedShelf = remove(testShelf, toRemove);

		// 15. Verify that the length of the result is 1 less than your input array, and
		// that the Story
		// you passed in the second argument is NOT present, and return false if either
		// test does
		// not pass.
		if (removedShelf.length != testShelf.length - 1) {
			return false;
		}
		for (int i = 0; i < removedShelf.length; i++) {
			if (removedShelf[i].compareTo(toRemove) == 0) {
				return false;
			}
		}

		// OPTIONAL: implement additional tests to verify the method works!

		// 16. Return true if all tests in this method are passed.
		return true; // default return statement added to avoid compiler errors. Feel free to change
						// it.
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	// NOTE: THERE IS NO MORE CODE REQUIRED FROM YOU AFTER THIS POINT!
	//
	// What follows is another test for you to run locally to help assure you that
	///////////////////////////////////////////////////////////////////////////////////////////////// your
	///////////////////////////////////////////////////////////////////////////////////////////////// program
	// works as expected, and a main method. The Story class is included at the
	///////////////////////////////////////////////////////////////////////////////////////////////// bottom
	///////////////////////////////////////////////////////////////////////////////////////////////// of
	///////////////////////////////////////////////////////////////////////////////////////////////// the
	///////////////////////////////////////////////////////////////////////////////////////////////// file.
	//
	// SAVE YOUR CODE (Ctrl/Cmd + S) and RUN ALL TESTS, and SUBMIT YOUR FILE TO
	///////////////////////////////////////////////////////////////////////////////////////////////// GRADESCOPE!!
	/////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * A recursive method to sort an array of Stories in-place.
	 * 
	 * @param shelf a full, perfect-size array of Stories with length >= 1
	 */
	public static void descendingSort(Story[] shelf) {
		/////////// BASE CASE ///////////
		// an array of length 1 is sorted
		if (shelf.length == 1)
			return;

		///////// RECURSIVE CASE ////////

		// use the helper methods to pre-process the data
		Story maxStory = getLongestStory(shelf);
		Story[] newShelf = remove(shelf, maxStory);
		descendingSort(newShelf);

		// copy the processed data back into the original shelf
		shelf[0] = maxStory;
		for (int i = 0; i < newShelf.length; i++) {
			shelf[i + 1] = newShelf[i];
		}
	}

	/**
	 * A tester method for descendingSort, provided for you in its entirety. You may
	 * add code if you wish, but you are not required to. This method will not be
	 * tested.
	 * 
	 * @return true if descendingSort produces the expected result; false otherwise
	 */
	public static boolean testDescendingSort() {
		// try sorting a one-story shelf:
		Story[] simpleShelf = new Story[] { new Story("Chivalry", 3406) };
		Story contents = new Story("Chivalry", 3406);
		try {
			descendingSort(simpleShelf);
		} catch (NullPointerException npe) {
			System.err.println("ascendingSort() NullPointerException!");
			return false;
		}

		if (simpleShelf.length != 1)
			return false;
		if (simpleShelf[0] == null || simpleShelf[0].compareTo(contents) != 0)
			return false;

		// try sorting a shelf with multiple stories:
		Story[] testShelf = new Story[] { new Story("Troll-Bridge", 428), new Story("Murder Mysteries", 2075),
				new Story("Harlequin Valentine", 826), new Story("How To Talk To Girls At Parties", 1833) };
		Story[] expectedShelf = new Story[] { new Story("Murder Mysteries", 2075),
				new Story("How To Talk To Girls At Parties", 1833), new Story("Harlequin Valentine", 826),
				new Story("Troll-Bridge", 428) };
		try {
			descendingSort(testShelf);
		} catch (NullPointerException npe) {
			System.err.println("descendingSort() NullPointerException!");
			return false;
		}

		if (testShelf.length != expectedShelf.length)
			return false;
		for (int i = 0; i < expectedShelf.length; i++) {
			if (testShelf[i] == null || testShelf[i].compareTo(expectedShelf[i]) != 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("getLongestStory test result: " + testGetLongestStory());
		System.out.println("remove test result: " + testRemove());
		System.out.println("descendingSort test result: " + testDescendingSort());
	}

}

/**
 * The objects to be sorted by the DescendingSort class. DO NOT MODIFY THIS
 * CLASS IN ANY WAY.
 */
class Story {
	private String title;
	private int wordCount;

	/**
	 * Create a new Story object
	 * 
	 * @param title     the title of the story
	 * @param wordCount the number of words in the story
	 */
	public Story(String title, int wordCount) {
		this.title = title;
		this.wordCount = wordCount;
	}

	/**
	 * Compare first on the basis of word count, and if the word counts are the
	 * same, compare on the title.
	 * 
	 * @param s the Story to compare this to
	 * @return value less than 0 if this story is shorter/alphabetically before s,
	 *         greater than 0 if this story is longer/alphabetically after s, and 0
	 *         if they have the same title and word count.
	 */
	public int compareTo(Story s) {
		if (this.wordCount != s.wordCount)
			return this.wordCount - s.wordCount;
		return this.title.compareTo(s.title);
	}

	/**
	 * For debugging purposes, a way to System.out.println(Story)
	 * 
	 * Results are formatted roughly as: "Title" (wordCount)
	 */
	@Override
	public String toString() {
		return "\"" + this.title + "\" (" + wordCount + ")";
	}
}
