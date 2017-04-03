package com.teamtreehouse;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example_09_package implements Comparable<Example_09_package>, Serializable {
	private static final long serialVersionUID = -1300039139550754854L;
	// private boolean breakTheCode = true;
	private String mAuthor;
	private String mTitle;
	private String mBody;
	private String description;
	private String mCategory;
	private Date mCreationDate;
	
	public Example_09_package(String author, String description, Date creationDate){
		mAuthor = author;
		this.description = description;
		mCreationDate = creationDate;
	}
	@Override
	
	public String toString(){
		return "Treet: \"" + this.description + "\"- @" + mAuthor;
	}
	
	public String getAuthor(){
		return mAuthor;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public Date getCreationDate(){
		return mCreationDate;
	}
	// This method compare:
	// 		return 0 if the istance is the same or if have the same mCreationDate
	// 		otherwise return dateCmp
	@Override
	
	public int compareTo(Example_09_package other) {
		// Example_09_package other = (Example_09_package) obj;
		if (equals(other)) {
			return 0;
		}
		int dateCmp = mCreationDate.compareTo(other.mCreationDate);
		if (dateCmp == 0) {
			return mCreationDate.compareTo(other.mCreationDate);
		}
		return dateCmp;
	}
	
	public List<String> getWords() {
    	String[] words = this.description.toLowerCase().split("[^\\w#@]+");
    	return Arrays.asList(words); 
	}
	
	public List<String> getHashTags() {
		return getListThatStartWith("#");
	}

	public List<String> getMentions() {
		return getListThatStartWith("@");
	}

	private List<String> getListThatStartWith(String prefix) {
		List<String> listOfResults = new ArrayList<String>();
		for (String word : getWords()) {
			if (word.startsWith(prefix)) {
				listOfResults.add(word);
			}
		}
		return listOfResults;
	}
}