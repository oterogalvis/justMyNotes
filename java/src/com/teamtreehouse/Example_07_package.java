package com.teamtreehouse;

import java.util.Date;
import java.io.Serializable;

public class Example_07_package implements Comparable, Serializable {
	private static final long serialVersionUID = -1300039139550754854L;
	// private boolean breakTheCode = true;
	private String mAuthor;
	private String mTitle;
	private String mBody;
	private String description;
	private String mCategory;
	private Date mCreationDate;
	
	public Example_07_package(String author, String description, Date creationDate){
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
	public int compareTo(Object obj) {
		Example_07_package other = (Example_07_package) obj;
		if (equals(other)) {
			return 0;
		}
		int dateCmp = mCreationDate.compareTo(other.mCreationDate);
		if (dateCmp == 0) {
			return mCreationDate.compareTo(other.mCreationDate);
		}
		return dateCmp;
	}
}