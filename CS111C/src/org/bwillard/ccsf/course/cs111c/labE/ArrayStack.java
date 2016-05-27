package org.bwillard.ccsf.course.cs111c.labE;

/**
 * A class that implements the ADT stack by using an expandable array.
 * 
 */
public class ArrayStack<T> implements StackInterface<T> {
	
	protected T[] stack; // array of stack entries
	protected int topIndex; // index of top entry
	protected static final int DEFAULT_INITIAL_CAPACITY = 50;

	public ArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	} 

	public ArrayStack(int initialCapacity) {
		stack = (T[]) new Object[initialCapacity];
		topIndex = -1;
	} 

	public void push(T newEntry) {
		topIndex++;

		if (topIndex >= stack.length) // if array is full,
			doubleArray(); // expand array

		stack[topIndex] = newEntry;
	}


	public T peek() {
		T top = null;

		if (!isEmpty())
			top = stack[topIndex];

		return top;
	} 


	public T pop() {
		T top = null;

		if (!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		} 

		return top;
	} 
	
	public boolean isEmpty() {
		return topIndex < 0;
	} 


	public void clear() {
		for (; topIndex > -1; topIndex--)
			stack[topIndex] = null;
	} 
	


	protected void doubleArray() {
		T[] oldStack = stack; // get reference to array of stack entries
		int oldSize = oldStack.length; // get max size of original array

		stack = (T[]) new Object[2 * oldSize]; // double size of array

		// copy entries from old array to new, bigger array
		System.arraycopy(oldStack, 0, stack, 0, oldSize);


	} 
	
	public StackInterface<T> reverseStack(StackInterface<T> stack) {
		StackInterface<T> reversed = new ArrayStack<T>();
		StackInterface<T> temp = new ArrayStack<T>();
		while(!stack.isEmpty()) {
			T item = stack.pop();
			temp.push(item);
			reversed.push(item);
		}
			
		while(!temp.isEmpty())
			stack.push(temp.pop());
		
		return reversed;
	}
	
	public T searchStack(StackInterface<T> stack, T item) {
		if(stack == null || stack.isEmpty() || item == null) {
			return null;
		} else {
			while(!stack.isEmpty()) {
				if(item.equals(stack.pop())){
					return item;
				}
			}
		}
		return null;
	}
	
	public T searchStackPreserveObj(StackInterface<T> stack, T item) {
		StackInterface<T> temp = new ArrayStack<T>();
		T returnItem = null;
		if(stack == null || stack.isEmpty() || item == null) {
			return null;
		} else {
			while(!stack.isEmpty()) {
				T poppedItem = stack.pop();
				temp.push(poppedItem);
				if(item.equals(poppedItem)){
					returnItem = item;
				}
			}
			//Rebuild orig queue from broken point
			while(!temp.isEmpty())
				stack.push(temp.pop());
		}
		return returnItem;
	}
	
	public static Integer maxInStack(StackInterface<Integer> stack) {
		Integer max = 0;
		StackInterface<Integer> temp = new ArrayStack<Integer>();
		while(stack.peek() != null) {
			Integer tempInt = max;
			Integer first = stack.pop();
			temp.push(first);
			Integer second = stack.peek();
			if(second == null || first > second) {
				tempInt = first;
			} else {
				tempInt = second;
			}
			if(max < tempInt) {
				max = tempInt;
			}
		}
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		return max;
	}
	
	public static void main(String args[]) {
		/*ArrayStack<String> s = new ArrayStack<String>();
		s.push("Bradibo");
		s.push("Lina");
		s.push("Alec");
		s.push("Dylan");
		s.push("Fabio");
		StackInterface<String> reversed = s.reverseStack(s);
		System.out.print("\nExpected: Bradibo Lina Alec Dylan Fabio\n");
		while(!reversed.isEmpty())
			System.out.print(reversed.pop() + " ");
		
		System.out.print("\nExpected: Fabio Dylan Alec Lina Bradibo\n");
		while(!s.isEmpty())
			System.out.print(s.pop() + " ");
	
		ArrayStack<Integer> as = new ArrayStack<Integer>();
		for(int i = 1; i <= 10; i++) {
			as.push(i);
		}
		Integer fnd2 = as.searchStackPreserveObj(as, 8);
		System.out.println("\nExpected 5 : " + fnd2);
		
		System.out.println("Expected : 10 9 8 7 6 5 4 3 2 1");
		while(!as.isEmpty()) {
			System.out.print(as.pop() + " ");
		}*/
		
		//StackInterface<Integer> stack = new ArrayStack<Integer>();
		Integer[] ints = {5, 22, 2, 19, 43, 61, 14, 98, 109, 28};
		/*for(int i = 0; i < ints.length; i++) {
			stack.push(ints[i]);
		}*/
		//System.out.println("MaxInStack should be 109 : " + maxInStack(stack));*/
		
		QueueInterface queue = new ArrayQueue();
		for(int i = 0; i < ints.length; i++) {
			queue.enqueue(ints[i]);
		}
		StackInterface st = stackFromQueue(queue);
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
	
	public static StackInterface stackFromQueue(QueueInterface queue) {
		StackInterface stack = new ArrayStack();
		StackInterface temp = new ArrayStack();
		QueueInterface tempQueue = new ArrayQueue();
		if(queue == null) {
			return null;
		} else {
			while(!queue.isEmpty()) {
				Object item = queue.dequeue();
				temp.push(item);
				tempQueue.enqueue(item);
			}
		}
		while(!temp.isEmpty()) {
			Object item = temp.pop();
			stack.push(item);
		}
		
		while(!tempQueue.isEmpty()) {
			queue.enqueue(tempQueue.dequeue());
		}
		
		return stack;
	}
	
} 