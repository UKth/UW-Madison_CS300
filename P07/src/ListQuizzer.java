import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ListQuizzer class for P07
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
 */

public class ListQuizzer implements Iterable<MultipleChoiceQuestion> {
	private LinkedNode<MultipleChoiceQuestion> head;
	private LinkedNode<MultipleChoiceQuestion> tail;
	private int size;
	private ListingMode listingMode;

	public ListQuizzer() {
		listingMode = ListingMode.ALL;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void switchMode(ListingMode listingMode) {
		this.listingMode = listingMode;
	}

	public void add(int index, MultipleChoiceQuestion question) throws NullPointerException, IndexOutOfBoundsException {
		if (question == null) {
			throw new NullPointerException("Invalid question.");
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		if (size == 0) {
			LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question, head);
			head = newNode;
			tail = newNode;
			size = 1;
			return;
		}


		if (index == 0) {
			LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question, head);
			head = newNode;
			size += 1;
			return;
		}

		LinkedNode<MultipleChoiceQuestion> p = head; // will be i-1th node
		for (int i = 0; i < index - 1; i++) {
			p = p.getNext();
		}
		LinkedNode<MultipleChoiceQuestion> q = p.getNext();
		p.setNext(new LinkedNode<MultipleChoiceQuestion>(question, q));
		size += 1;
	}

	public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {
		if (question == null) {
			throw new NullPointerException("Invalid question.");
		}
		if (size == 0) {
			LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question, head);
			head = newNode;
			tail = newNode;
			size = 1;
			return;
		}
		LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question, head);
		head = newNode;
		size += 1;
	}

	public void addLast(MultipleChoiceQuestion question) throws NullPointerException {
		if (question == null) {
			throw new NullPointerException("Invalid question.");
		}
		if (size == 0) {
			LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question, head);
			head = newNode;
			tail = newNode;
			size = 1;
			return;
		}
		LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question);
		tail.setNext(newNode);
		tail = newNode;
		size += 1;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean contains(MultipleChoiceQuestion someQuestion) {
		LinkedNode<MultipleChoiceQuestion> p = head;
		while (p != null) {
			if (p.getData().equals(someQuestion)) {
				return true;
			}
			p = p.getNext();
		}
		return false;
	}

	public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		LinkedNode<MultipleChoiceQuestion> p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		return p.getData();
	}

	public MultipleChoiceQuestion getFirst() throws NoSuchElementException {
		if (size == 0 || head == null || tail == null) {
			throw new NoSuchElementException("Empty list");
		}
		return head.getData();
	}

	public MultipleChoiceQuestion getLast() throws NoSuchElementException {
		if (size == 0 || head == null || tail == null) {
			throw new NoSuchElementException("Empty list");
		}
		return tail.getData();
	}

	public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		if (size == 1) {
			LinkedNode<MultipleChoiceQuestion> p = head;
			head = null;
			tail = null;
			size = 0;
			return p.getData();
		}
		if (index == 0) {
			MultipleChoiceQuestion deleted = removeFirst();
			return deleted;
		}
		if (index == size - 1) {
			MultipleChoiceQuestion deleted = removeLast();
			return deleted;
		}
		LinkedNode<MultipleChoiceQuestion> p = head; // will be i-1th node
		for (int i = 0; i < index - 1; i++) {
			p = p.getNext();
		}
		LinkedNode<MultipleChoiceQuestion> q = p.getNext();

		p.setNext(q.getNext());
		size -= 1;
		return q.getData();

	}

	public MultipleChoiceQuestion removeFirst() throws NoSuchElementException {
		if (size == 0 || head == null || tail == null) {
			throw new NoSuchElementException("Empty list");
		}
		if (size == 1) {
			LinkedNode<MultipleChoiceQuestion> p = head;
			head = null;
			tail = null;
			size = 0;
			return p.getData();
		}
		MultipleChoiceQuestion q = head.getData();
		head = head.getNext();

		size -= 1;
		return q;
	}

	public MultipleChoiceQuestion removeLast() throws NoSuchElementException {
		if (size == 0 || head == null || tail == null) {
			throw new NoSuchElementException("Empty list");
		}
		if (size == 1) {
			LinkedNode<MultipleChoiceQuestion> p = head;
			head = null;
			tail = null;
			size = 0;
			return p.getData();
		}
		LinkedNode<MultipleChoiceQuestion> p = head;
		for (int i = 0; i < size - 2; i++) {
			p = p.getNext();
		}

		LinkedNode<MultipleChoiceQuestion> q = p.getNext();
		p.setNext(null);
		tail = p;
		size -= 1;
		return q.getData();

	}

	public Iterator<MultipleChoiceQuestion> iterator() {
		if (listingMode == ListingMode.CORRECT) {
			return new CorrectQuestionsIterator(head);
		}
		if (listingMode == ListingMode.INCORRECT) {
			return new IncorrectQuestionsIterator(head);
		}
		return new QuizQuestionsIterator(head);
	}

	public int calculateScore() {
		LinkedNode<MultipleChoiceQuestion> p = head;
		int cnt = 0;
		while (p != null) {
			if (p.getData().isCorrect()) {
				cnt += p.getData().getPointsPossible();
			}
			p = p.getNext();
		}
		return cnt;
	}

	public int calculateTotalPoints() {
		LinkedNode<MultipleChoiceQuestion> p = head;
		int cnt = 0;
		while (p != null) {
			cnt += p.getData().getPointsPossible();
			p = p.getNext();
		}
		return cnt;
	}

	public ListQuizzer copy() {
		ListQuizzer copiedListQuizzer = new ListQuizzer();
		copiedListQuizzer.switchMode(listingMode);
		LinkedNode<MultipleChoiceQuestion> p = head;
		while (p != null) {
			copiedListQuizzer.addLast(p.getData().copy());
			p = p.getNext();
		}
		return copiedListQuizzer;
	}

	/**
	 * Loads MultipleChoiceQuestions from a file
	 * 
	 * @author Jeff and Mouna
	 * 
	 * @param file file to read
	 * @return the number of added MultipleChoiceQuestions to this list
	 * @throws FileNotFoundException if the file is not found
	 */
	public int loadQuestions(File file) throws FileNotFoundException {
		int loadedCount = 0; // count of loaded multiple choice questions
		int answerCount = 0; // count of possible answers per question
		int indexCorrectAnswer = 0; // index of the correct answer
		int points = 0; // possible points for a multiple choice question
		// try to read the file
		Scanner reader = null; // scanner to read the file line by line
		int lineNumber = 0; // number of the last read line

		try {
			reader = new Scanner(file);
			// parse the file lines - while loop to read parts of each multiple choice
			// question
			while (reader.hasNextLine()) { // no more lines to read
				// read title
				String title = reader.nextLine();
				lineNumber++;

				// read question stem
				if (!reader.hasNextLine()) { // no more lines to read
					return loadedCount;
				}
				String question = reader.nextLine();
				lineNumber++;

				// read possible answers count
				if (!reader.hasNextLine()) { // no more lines to read
					return loadedCount;
				}
				String count = reader.nextLine();
				lineNumber++;
				// check the validity of count
				try {
					answerCount = Integer.parseInt(count.trim());
					if (answerCount <= 0 || answerCount > 10) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException e) { // count invalid - print an error message and return
					System.out.println("Syntax error! A positive integer less or equal to 10 is expected at line "
							+ lineNumber + (". Load questions operation interrupted!"));
					return loadedCount;
				}
				// valid count -> create the answerList array
				String[] answerList = new String[answerCount];
				int index = 0;
				while (index < answerCount && reader.hasNextLine()) {
					String answer = reader.nextLine();
					lineNumber++;
					answerList[index] = answer;
					index++;
				}

				// read index of the correct answer
				if (!reader.hasNextLine()) { // no more lines to read
					return loadedCount;
				}
				String line = reader.nextLine();
				lineNumber++;
				try { // check the validity of the index of the correct answer
					indexCorrectAnswer = Integer.parseInt(line.trim());
					if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return
					System.out.println("Syntax error! A positive integer less than " + answerCount
							+ " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
					return loadedCount;
				}
				// valid index of the correct answer -> read possible points
				// read points
				if (!reader.hasNextLine()) { // no more lines to read
					return loadedCount;
				}
				line = reader.nextLine();

				lineNumber++;
				try { // check the validity of the index of the correct answer
					points = Integer.parseInt(line.trim());

					if (points < 0) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException e) { // invalid points - print error message and return
					System.out.println("Syntax error! A positive integer for possible points " + " is expected at line "
							+ lineNumber + (". Load questions operation interrupted!"));

					return loadedCount;
				}
				// create and add quizQuestion
				MultipleChoiceQuestion quizQuestion = new MultipleChoiceQuestion(title, question, answerList,
						indexCorrectAnswer, points);

				this.addLast(quizQuestion);
				loadedCount += 1;
				System.out.println("Question " + loadedCount + " loaded!");

			}
		} finally {
			if (reader != null)
				reader.close();
		}

		return loadedCount;
	}

	/**
	 * Allows a user to take this quiz. The quiz should be taken on a deep copy of
	 * this ListQuizzer. This method should not make any changes to the contents of
	 * this ListQuizzer.
	 * 
	 * @author Jeff and Mouna
	 * 
	 * @return the instance of ListQuizzer taken by the user. It should include the
	 *         user's responses.
	 */
	public ListQuizzer takeQuiz() {

		ListQuizzer copy = this.copy();
		copy.switchMode(ListingMode.ALL);
		Scanner input = new Scanner(System.in);
		for (MultipleChoiceQuestion question : copy) {
			System.out.println(question);
			System.out.print("Enter your answer: ");
			int entry = input.nextInt();
			question.setStudentAnswerIndex(entry - 1);
			if (question.isCorrect()) {
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect!");
			}
		}
		int correctPoints = copy.calculateScore();
		int totalPoints = copy.calculateTotalPoints();
		System.out.println("Your Score: " + correctPoints);
		System.out.println("Percentage: " + correctPoints / totalPoints);
		input.close();
		return copy;
	}

	/**
	 * Returns true if o is a ListQuizzer which has the exact same contents as this
	 * ListQuizzer
	 * 
	 * @author Mouna
	 *
	 * @param o an object to compare with
	 * @return true if o is instanceof ListQuizzer with the exact same contents as
	 *         this ListQuizzer
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof ListQuizzer) {
			ListQuizzer other = (ListQuizzer) o;
			if (this.size() != other.size())
				return false;
			this.switchMode(ListingMode.ALL);
			other.switchMode(ListingMode.ALL);
			Iterator<MultipleChoiceQuestion> iterator = this.iterator();
			Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
			while (iterator.hasNext()) {
				if (!iterator.next().equals(otherIterator.next()))
					return false;
			}
			return true;
		}
		return false;
	}

}
