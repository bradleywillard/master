package net.bwillard.practice.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class LIFOOnlyDeque {
	
	public static void main(String[] args) {
		Queue<String> lifoDeque = Collections.asLifoQueue(new ArrayDeque<String>());
		lifoDeque.add("Brad");
		lifoDeque.add("Lina");
		lifoDeque.add("Jeff");
		lifoDeque.add("Bushes");
		lifoDeque.add("Trees");
		lifoDeque.offer("Traps");//Acts like push()
		System.out.println(lifoDeque);//Should print [Traps, Trees, Bushes, Jeff, Lina, Brad]
		
		lifoDeque.remove();//Acts like pop()
		System.out.println(lifoDeque);//Should print [Trees, Bushes, Jeff, Lina, Brad]
		
		
		lifoDeque.remove("Lina");//Should not work
		System.out.println(lifoDeque);//This shouldn't work!! But it does and prints [Trees, Bushes, Jeff, Brad]
		
		
		
	}

}
