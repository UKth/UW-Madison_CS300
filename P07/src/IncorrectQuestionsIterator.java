import java.util.Iterator;
import java.util.NoSuchElementException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    IncorrectQuestionsIterator class for P07
//Course:   CS 300 Fall 2022
//
//Author:   Seungwook Seo
//Email:    sseo36@wisc.edu
//Lecturer: Mouna Kacem
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    N/A
//Partner Email:   N/A
//Partner Lecturer's Name: N/A
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         None
//Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

//Below is a javadoc class header to complete
/**
* 
* @author Seungwook Seo
*/

public class IncorrectQuestionsIterator implements Iterator<MultipleChoiceQuestion> {
	private LinkedNode<MultipleChoiceQuestion> next;

	public IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
		next = startNode;
		setNext();
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public MultipleChoiceQuestion next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException("No next item.");
		}
		LinkedNode<MultipleChoiceQuestion> p = next;
		next = next.getNext();
		setNext();
		
		return p.getData();
	}
	
	public void setNext() {
		while (next != null && next.getData().isCorrect()) {
			next = next.getNext();
		}
	}
}
