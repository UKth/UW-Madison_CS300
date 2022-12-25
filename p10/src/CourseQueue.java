
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseQueue class for P10
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Courses.
 * Guarantees the max-heap invariant, so that the Course at the root should have
 * the highest score, and all children always have a score lower than or equal
 * to their parent's.
 * 
 * The root of a non-empty queue is always at index 0 of this array-heap.
 */
public class CourseQueue
		implements Iterable<Course> /* TODO: add PriorityQueueADT<Course> once Course is Comparable */ {

	// data fields
	private Course[] queue; // array max-heap of courses representing this priority queue
	private int size; // number of courses currently in this priority queue

	/**
	 * Creates a new, empty CourseQueue with the given capacity
	 * 
	 * @param capacity the capacity of this CourseQueue
	 * @throws IllegalArgumentException if the capacity is not a positive integer
	 */
	public CourseQueue(int capacity) {
		Course[] queue = new Course[capacity];
		size = 0;
	}

	/**
	 * Returns a deep copy of this CourseQueue containing all of its elements in the
	 * same order. This method does not return the deepest copy, meaning that you do
	 * not need to duplicate courses. Only the instance of the heap (including the
	 * array and its size) will be duplicated.
	 * 
	 * @return a deep copy of this CourseQueue, which has the same capacity and size
	 *         as this queue.
	 */
	public CourseQueue deepCopy() {
		// TODO complete this method according to its description
		return null;
	}

	/**
	 * Returns an Iterator for this CourseQueue which proceeds from the
	 * highest-priority to the lowest-priority Course in the queue. Note that this
	 * should be an iterator over a DEEP COPY of this queue.
	 * 
	 * @see CourseIterator
	 * @return an Iterator for this CourseQueue
	 */
	@Override
	public Iterator<Course> iterator() {
		// TODO complete this method according to its description
		return null;
	}

	///////////////////////////// TODO: PRIORITY QUEUE METHODS
	///////////////////////////// //////////////////////////////////
	// Add the @Override annotation to these methods once this class implements
	///////////////////////////// PriorityQueueADT!

	/**
	 * Checks whether this CourseQueue is empty
	 * 
	 * @return {@code true} if this CourseQueue is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns the size of this CourseQueue
	 * 
	 * @return the size of this CourseQueue
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds the given Course to this CourseQueue and use the percolateUp() method to
	 * maintain max-heap invariant of CourseQueue. Courses should be compared using
	 * the Course.compareTo() method.
	 * 
	 * 
	 * @param toAdd Course to add to this CourseQueue
	 * @throws NullPointerException  if the given Course is null
	 * @throws IllegalStateException with a descriptive error message if this
	 *                               CourseQueue is full
	 */
	public void enqueue(Course toAdd) throws NullPointerException, IllegalStateException {
		// TODO complete this method
	}

	/**
	 * Removes and returns the Course at the root of this CourseQueue, i.e. the
	 * Course with the highest priority. Use the percolateDown() method to maintain
	 * max-heap invariant of CourseQueue. Courses should be compared using the
	 * Course.compareTo() method.
	 * 
	 * @return the Course in this CourseQueue with the highest priority
	 * @throws NoSuchElementException with a descriptive error message if this
	 *                                CourseQueue is empty
	 */
	public Course dequeue() throws NoSuchElementException {
		return null; // TODO complete this method
	}

	/**
	 * Returns the Course at the root of this CourseQueue, i.e. the Course with the
	 * highest priority.
	 * 
	 * @return the Course in this CourseQueue with the highest priority
	 * @throws NoSuchElementException if this CourseQueue is empty
	 */
	public Course peek() throws NoSuchElementException {
		return null; // TODO complete this method
	}

	///////////////////////////// TODO: QUEUE HELPER METHODS
	///////////////////////////// //////////////////////////////////

	/**
	 * Restores the max-heap invariant of a given subtree by percolating its root
	 * down the tree. If the element at the given index does not violate the
	 * max-heap invariant (it is higher priority than its children), then this
	 * method does not modify the heap.
	 * 
	 * Otherwise, if there is a heap violation, then swap the element with the
	 * correct child and continue percolating the element down the heap.
	 * 
	 * This method may be implemented iteratively or recursively.
	 * 
	 * @param index index of the element in the heap to percolate downwards
	 * @throws IndexOutOfBoundsException if index is out of bounds - do not catch
	 *                                   the exception
	 */
	protected void percolateDown(int index) throws IndexOutOfBoundsException {
		// TODO complete this method
	}

	/**
	 * Restores the max-heap invariant of the tree by percolating a leaf up the
	 * tree. If the element at the given index does not violate the max-heap
	 * invariant (it is lower priority than its parent), then this method does not
	 * modify the heap.
	 * 
	 * Otherwise, if there is a heap violation, swap the element with its parent and
	 * continue percolating the element up the heap.
	 * 
	 * This method may be implemented iteratively or recursively.
	 * 
	 * @param index index of the element in the heap to percolate upwards
	 * @throws IndexOutOfBoundsException if index is out of bounds - do not catch
	 *                                   the exception
	 */
	protected void percolateUp(int index) throws IndexOutOfBoundsException {
		// TODO complete this method
	}

	////////////////////////////// PROVIDED: TO STRING
	////////////////////////////// ////////////////////////////////////

	/**
	 * Returns a String representing this CourseQueue, where each element (course)
	 * of the queue is listed on a separate line, in order from the highest priority
	 * to the lowest priority.
	 * 
	 * @author yiwei
	 * @see Course#toString()
	 * @see CourseIterator
	 * @return a String representing this CourseQueue
	 */
	@Override
	public String toString() {
		StringBuilder val = new StringBuilder();

		for (Course c : this) {
			val.append(c).append("\n");
		}

		return val.toString().trim();
	}

}
