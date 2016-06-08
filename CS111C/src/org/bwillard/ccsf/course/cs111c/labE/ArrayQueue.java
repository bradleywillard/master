package org.bwillard.ccsf.course.cs111c.labE;

/**
 * A class that implements the ADT queue by using an expandable circular array
 * with one unused location.
 * 
 */
public class ArrayQueue<T> implements QueueInterface<T> {

	protected T[] queue; // circular array of queue entries and one unused location
	protected int frontIndex;
	protected int backIndex;
	protected static final int DEFAULT_INITIAL_CAPACITY = 50;

	public ArrayQueue() {
		this(DEFAULT_INITIAL_CAPACITY);
	} 

	public ArrayQueue(int initialCapacity) {
		queue = (T[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	} 


	public void enqueue(T newEntry) {
		if (isArrayFull()) 
			doubleArray(); 

		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	} 
	
	public T getFront() {
		T front = null;

		if (!isEmpty())
			front = queue[frontIndex];

		return front;
	} 

	public T dequeue() {
		T front = null;

		if (!isEmpty()) {
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		} 

		return front;
	} 


	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	} 


	public void clear() {
		if (!isEmpty()) { // deallocates only the used portion
			for (int index = frontIndex; index != backIndex; index = (index + 1)
					% queue.length) {
				queue[index] = null;
			} 

			queue[backIndex] = null;
		} 

		frontIndex = 0;
		backIndex = queue.length - 1;
	} 



	protected boolean isArrayFull() {
		return frontIndex == ((backIndex + 2) % queue.length);
	} 


	protected void doubleArray() {
		T[] oldQueue = queue;
		int oldSize = oldQueue.length;

		queue = (T[]) new Object[2 * oldSize];

		for (int index = 0; index < oldSize - 1; index++) {
			queue[index] = oldQueue[frontIndex];
			frontIndex = (frontIndex + 1) % oldSize;
		} 

		frontIndex = 0;
		backIndex = oldSize - 2;
	} 
	
	public QueueInterface<T> stackToQueue(StackInterface<T> stack) {
		QueueInterface<T> queue = new ArrayQueue<T>();
		if(stack != null) {
			T topOfStack = stack.pop();
			queue.enqueue(topOfStack);
			queue.enqueue(stack.peek());
			stack.push(topOfStack);
		}
		return queue;
	}
	
	public QueueInterface<T> reverseQueue(QueueInterface<T> queue) {
		StackInterface<T> temp = new ArrayStack<T>();
		QueueInterface<T> preserved = new ArrayQueue<T>();
		QueueInterface<T> reversed = new ArrayQueue<T>();
		while(!queue.isEmpty()) {
			T item = queue.dequeue();
			temp.push(item);
			preserved.enqueue(item);
		}
		
		while(!temp.isEmpty()) {
			reversed.enqueue(temp.pop());
		}
		
		while(!preserved.isEmpty()) {
			queue.enqueue(preserved.dequeue());
		}
		
		return reversed;
			
	}
	
	public T searchQueue(QueueInterface<T> queue, T item) {
		if(queue == null || queue.isEmpty() || item == null) {
			return null;
		} else {
			while(!queue.isEmpty()) {
				if(item.equals(queue.dequeue())){
					return item;
				}
			}
		}
		return null;
	}
	
	public T searchQueuePreserveObj(QueueInterface<T> queue, T item) {
		QueueInterface<T> temp = new ArrayQueue<T>();
		T returnItem = null;
		if(queue == null || queue.isEmpty() || item == null) {
			return null;
		} else {
			while(!queue.isEmpty()) {
				T dequeuedItem = queue.dequeue();
				temp.enqueue(dequeuedItem);
				if(item.equals(dequeuedItem)){
					returnItem = item;
				}
			}
			//Rebuild orig queue from broken point
			while(!temp.isEmpty())
				queue.enqueue(temp.dequeue());
		}
		return returnItem;
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
	
	public static Integer maxInQ(QueueInterface<Integer> queue) {
		Integer max = 0;
		QueueInterface<Integer> temp = new ArrayQueue<Integer>();
		while(queue.getFront() != null) {
			Integer tempInt = max;
			Integer first = queue.dequeue();
			temp.enqueue(first);
			Integer second = queue.getFront();
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
			queue.enqueue(temp.dequeue());
		}
		return max;
	}
	
	public static void main(String args[]) {
		
		ArrayQueue<String> q = new ArrayQueue<String>();
		q.enqueue("Eggs");
		q.enqueue("Milk");
		q.enqueue("Salad");
		q.enqueue("Beef");
		q.enqueue("Pizza");
		q.enqueue("Soap");
		
		QueueInterface<String> reversed = q.reverseQueue(q);
		System.out.println("Expected: Soap Pizza Beef Salad Milk Eggs");
		System.out.print("Actual: ");
		while(!reversed.isEmpty())
			System.out.print(reversed.dequeue() + " ");
		
		StackInterface<String> stack = new ArrayStack<String>();
		stack.push("Lina");
		stack.push("Brad");
		stack.push("Rick");
		stack.push("Alisha");
		stack.push("Lauri");
		stack.push("Bruce");
		stack.push("Ann");
		stack.push("Julie");
		stack.push("Tim");
		
		QueueInterface<String> queue2 = q.stackToQueue(stack);
		System.out.println("\nExpected: Tim Julie");
		System.out.print("Actual: ");
		while(!queue2.isEmpty())
			System.out.print(queue2.dequeue() + " ");
		
		ArrayQueue<Integer> aq = new ArrayQueue<Integer>();
		for(int i = 1; i <= 10; i++) {
			aq.enqueue(i);
		}
		
		Integer fnd = aq.searchQueuePreserveObj(aq, 5);
		System.out.println("\nExpected 5 : " + fnd);
		
		System.out.println("Expected : 1 2 3 4 5 6 7 8 9 10");
		while(!aq.isEmpty()) {
			System.out.print(aq.dequeue() + " ");
		}
		
		QueueInterface<Integer> queue = new ArrayQueue<Integer>();
		Integer[] ints = {5, 22, 2, 19, 43, 61, 14, 98, 109, 28};
		for(int i = 0; i < ints.length; i++) {
			queue.enqueue(ints[i]);
		}
		System.out.println("MaxInQ should be 109 : " + maxInQ(queue));
		
	}
	
}