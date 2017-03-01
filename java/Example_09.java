import java.util.Date;

import com.teamtreehouse.Example_09_package;
import com.teamtreehouse.Example_09_helper;

class Example_09 {
	public static void main(String[] args) {
		Example_09_sets set = new Example_09_sets();
		set.addingMeals();
		set.printingList(set.getMeals(), "Meals:");
		set.printingList(set.castToTree(), "Organize Meals:");
		set.printingList(set.castToSortedSet().headSet("d"), "Meals before letter d:");
		set.printingList(set.castToSortedSet().tailSet("d"), "Meals after letter d:");
		set.printingList(set.castToSortedSet().subSet("chicken", "soup"), "Meals from chicken to soup:");
		set.printingList(set.castToSortedSet().subSet("chicken", "chicken" + Character.MAX_VALUE), "Meals with chicken:");
		set.printingList(set.mealsPlusFruits(), "Meals with fruits:");

		System.out.println("-------------------------------------------------------");

		Example_09_package treet = new Example_09_package(
			"Gandalf",
			"You shall no pass. #ysmp #almostDie @demon @monster",
			new Date(1421849732000L));
		System.out.printf("This is a new treet: %s %n", treet);

		System.out.println("HashTags:");
		for (String tag : treet.getHashTags()) {
			System.out.println(tag);
		}
	}
}