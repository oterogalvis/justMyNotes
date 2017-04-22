package example09;

import java.util.SortedSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class LearningSets {
	private Set<String> meals = new HashSet<String>();
	public void addingMeals() {
		meals.add("chicken");
		meals.add("chicken pasta");
		meals.add("empanada");
		meals.add("soup");
		meals.add("arepa");
		meals.add("arepa");
		meals.add("arepa");
	}
	public void printingList(Set<String> Items, String name) {
		System.out.println("\n" + name);
		for (String Item : Items ) {
			System.out.printf("I ate %s. \n", Item);
		}
	}

	public Set<String> mealsPlusFruits() {
		// List<String> fruits = new ArrayList<String>();
		List<String> fruits = Arrays.asList("apple", "cherry");
		meals.addAll(fruits);
		return meals;
	}

	public Set<String> castToTree() {
		Set<String> organizeMeals = new TreeSet<String>(meals);
		return organizeMeals;
	}

	public SortedSet<String> castToSortedSet() {
		SortedSet<String> organizeMeals = new TreeSet<String>(meals);
		return organizeMeals;
	}

	public Set<String> getMeals() {
		return meals;
	}
}