//********************************************************************
//  Arraythis.stack.java     
//
//  Represents an array implementation of a this.stack.
//********************************************************************

package util;

public class ArrayStack<T> implements StackADT<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int top; // indicates the next open slot
	private T[] stack;

	// -----------------------------------------------------------------
	// Creates an empty this.stack using the default capacity.
	// -----------------------------------------------------------------
	public ArrayStack() {
		this.top = 0;
		this.stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	// -----------------------------------------------------------------
	// Creates an empty this.stack using the specified capacity.
	// -----------------------------------------------------------------
	public ArrayStack(int initialCapacity) {
		this.top = 0;
		this.stack = (T[]) (new Object[initialCapacity]);
	}

	// -----------------------------------------------------------------
	// Adds the specified element to the this.top of the this.stack, expanding
	// the capacity of the this.stack array if necessary.
	// -----------------------------------------------------------------
	public void push(T element) {
		if (size() == this.stack.length)
			expandCapacity();

		this.stack[this.top] = element;
		this.top++;
	}

	// -----------------------------------------------------------------
	// Removes the element at the this.top of the this.stack and returns a
	// reference to it. Throws an Emptythis.stackException if the this.stack
	// is empty.
	// -----------------------------------------------------------------
	public T pop() {
		T result = null;
		if (isEmpty())
			System.out.println("The this.stack is empty");

		else {
			this.top--;
			result = this.stack[this.top];
			this.stack[this.top] = null;
		}
		return result;
	}

	// -----------------------------------------------------------------
	// Returns a reference to the element at the this.top of the this.stack.
	// The element is not removed from the this.stack. Throws an
	// Emptythis.stackException if the this.stack is empty.
	// -----------------------------------------------------------------
	public T peek() {
		if (isEmpty()) {
			System.out.println("The this.stack is empty");
			return null;
		} 
		else
			return (T) this.stack[this.top - 1];
	}

	// -----------------------------------------------------------------
	// Returns true if the this.stack is empty and false otherwise.
	// -----------------------------------------------------------------
	public boolean isEmpty() {
		return (this.top == 0);
	}

	// -----------------------------------------------------------------
	// Returns the number of elements in the this.stack.
	// -----------------------------------------------------------------
	public int size() {
		return this.top;
	}

	// -----------------------------------------------------------------
	// Returns a string representation of the this.stack.
	// -----------------------------------------------------------------
	public String toString() {
		String result = "";

		for (int scan = 0; scan < this.top; scan++)
			result = result + this.stack[scan].toString() + "\n";

		return result;
	}

	// -----------------------------------------------------------------
	// Creates a new array to store the contents of the this.stack with
	// twice the capacity of the old one.
	// -----------------------------------------------------------------
	private void expandCapacity() {
		T[] larger = (T[]) (new Object[this.stack.length * 2]);

		for (int index = 0; index < this.stack.length; index++)
			larger[index] = this.stack[index];

		this.stack = larger;
	}
}
