package com.homework.lfm;


import java.util.Comparator;
import java.util.Map.Entry;

public class PhonebookComparator implements Comparator<Entry<String, Contact>> {

	@Override
	public int compare(Entry<String, Contact> entry1, Entry<String, Contact> entry2) {

		Contact contact1 = entry1.getValue();
		Contact contact2 = entry2.getValue();
		
		if (contact1.getNumCalls() > contact2.getNumCalls()) {
			return -1;
		}

		if (contact1.getNumCalls() < contact2.getNumCalls()) {
			return 1;
		}

		return 0;
	}
}