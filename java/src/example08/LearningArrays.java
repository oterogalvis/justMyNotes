package example08;

import java.util.Arrays;
import java.io.Console;

class LearningArrays {
	private String[] fruits = {"cherry", "apple"};
	private String[] bigFruits = new String[3];
	private String[] vegetables = new String[10];
	private String other = "jeog";

	public void printThis(){
		System.out.println(fruits.length);
		System.out.println(fruits[1]);
		System.out.println(vegetables[1]);
		
		// Copy the items from an array to other without using the Arrays package.
		System.arraycopy(fruits, 0, bigFruits, 0, 2);

		System.out.println(Arrays.toString(bigFruits));
		bigFruits[2] = "watermelon";
		System.out.println(Arrays.toString(bigFruits));

		// Modify the size of the array in ordet to get more elements.
		fruits = Arrays.copyOf(fruits, 3);
		fruits[2] = "watermelon";
		System.out.println(Arrays.toString(fruits));
		fruits = Arrays.copyOf(fruits, 4);
		fruits[3] = "banana";
		System.out.println(Arrays.toString(fruits));

		// Sort item alphabetically.
		Arrays.sort(fruits);
		System.out.println(Arrays.toString(fruits));
		
		// compareTo() method: if t > o => 1. if t < o => -1. if t = o => 0.
		System.out.println("banana".compareTo("apple"));
	}
}