//********************************************************************
//  LinkedStack.java       
//
//  Represents a linked implementation of a stack.
//********************************************************************

package util;



public class LinkedStack<T> implements StackADT<T>
{
   private int count;  // indicates the next open slot
   private LinearNode<T> top; 

   //-----------------------------------------------------------------
   //  Creates an empty stack.
   //-----------------------------------------------------------------
   public LinkedStack()
   {
      this.count = 0;
      this.top = null;
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the this.top of the stack.
   //-----------------------------------------------------------------
   public void push (T element)
   {
      LinearNode<T> temp = new LinearNode<T> (element);

      temp.setNext(this.top);
      this.top = temp;
      this.count++;
   }

   //-----------------------------------------------------------------
   //  Removes the element at the this.top of the stack and returns a
   //  reference to it. Throws an EmptyStackException if the stack
   //  is empty.
   //-----------------------------------------------------------------
   public T pop() 
   {
	  T result = null; 
      if (isEmpty())
    	  System.out.println("The stack is empty");
      else {
        result = (T)this.top.getElement();
        this.top = this.top.getNext();
        this.count--;
      }
      return result;
   }
   
   //-----------------------------------------------------------------
   //  Returns a reference to the element at the this.top of the stack.
   //  The element is not removed from the stack.  Throws an
   //  EmptyStackException if the stack is empty.  
   //-----------------------------------------------------------------
   public T peek() 
   {
      if (isEmpty()) {
    	  System.out.println("The stack is empty");
    	  return null;
      }
      else
      return this.top.getElement();
   }

   //-----------------------------------------------------------------
   //  Returns true if the stack is empty and false otherwise. 
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
      return (this.count == 0);
   }
 
   //-----------------------------------------------------------------
   //  Returns the number of elements in the stack.
   //-----------------------------------------------------------------
   public int size()
   {
      return this.count;
   }

   //-----------------------------------------------------------------
   //  Returns a string representation of the stack. 
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "";
      LinearNode<T> current = this.top;

      while (current != null)
      {
         result = result + (current.getElement()).toString() + "\n";
         current = current.getNext();
      }

      return result;
   }
}
