package example09;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import example09.com.teamtreehouse.Treet;

class Main {
	public static void main(String[] args) {
		LearningSets set = new LearningSets();
		set.addingMeals();
		set.printingList(set.getMeals(), "Meals:");
		set.printingList(set.castToTree(), "Organize Meals:");
		set.printingList(set.castToSortedSet().headSet("d"), "Meals before letter d:");
		set.printingList(set.castToSortedSet().tailSet("d"), "Meals after letter d:");
		set.printingList(set.castToSortedSet().subSet("chicken", "soup"), "Meals from chicken to soup:");
		set.printingList(set.castToSortedSet().subSet("chicken", "chicken" + Character.MAX_VALUE), "Meals with chicken:");
		set.printingList(set.mealsPlusFruits(), "Meals with fruits:");

		System.out.println("-------------------------------------------------------");

		Treet treet = new Treet(
			"Gandalf",
			"You shall no pass. #ysmp #almostDie @demon @monster",
			new Date(1421849732000L));
		System.out.printf("This is a new treet: %s %n", treet);

		System.out.println("HashTags:");
		for (String tag : treet.getHashTags()) {
			System.out.println(tag);
		}

		System.out.println("-------------------------------------------------------");

		List<Treet> listTreet = new ArrayList<>();
		listTreet.add(treet);
		LearningMaps map = new LearningMaps();
		map.addingToMap();
		map.iterateByEach();
		map.countingHashtagWithMap(listTreet);
		map.countingAuthorsWithMaps(listTreet);
		
	}
}