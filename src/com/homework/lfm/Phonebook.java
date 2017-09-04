package com.homework.lfm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Phonebook {

	private Map<String, Contact> contacts;

	public Phonebook() {
		contacts = new TreeMap<>();
	}

	public void createNewPhonebook(String fileLocation) {
		File phonebookFile = new File(fileLocation);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(phonebookFile)))) {
			String line;

			while ((line = reader.readLine()) != null) {

				try {
					Contact contact = new Contact.Builder().createFromLine(line).build();
					contacts.put(contact.getName(), contact);
				} catch (InvalidNumberException e) {
					System.out.println(e.getMessage());
				}

			}
		} catch (FileNotFoundException e1) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Reader cannot read the line");
		}

	}

	public void addPair(String name, String phoneNum) {

		try {
			Contact newContact = new Contact.Builder().withName(name).withPhoneNumber(phoneNum)
					.build();
			contacts.put(newContact.getName(), newContact);
		} catch (InvalidNumberException e) {
			System.out.println(e.getMessage());
		}

	}

	public void removeContact(String key) {
		if (key == null) {
			System.out.println("There is no phonebook entry for that name.");
			return;
		}
		contacts.remove(key);
	}

	public Contact accessContactByName(String name) {
		return contacts.get(name);
	}

	public void printAll() {
		for (String key : contacts.keySet()) {
			Contact singleContact = contacts.get(key);
			System.out.println(singleContact);
		}
	}
	
	public void printFiveMostCalledb() {

		PhonebookComparator comparator = new PhonebookComparator();

		Set<Entry<String, Contact>> mapContacts = contacts.entrySet();

		TreeSet<Entry<String, Contact>> sortedMapContacts = new TreeSet<>(comparator);
		sortedMapContacts.addAll(mapContacts);

		int index = 0;
		for (Entry<String, Contact> entry : sortedMapContacts) {
			System.out.println(entry.getValue());
			index++;
			if (index == 5) {
				break;
			}
		}
	}
	
	public void printFiveMostCalled() {

		PhonebookComparator comparator = new PhonebookComparator();

		Set<Entry<String, Contact>> mapContacts = contacts.entrySet();

		TreeSet<Entry<String, Contact>> sortedMapContacts = new TreeSet<>(comparator);
		sortedMapContacts.addAll(mapContacts);

		int index = 0;
		for (Entry<String, Contact> entry : sortedMapContacts) {
			System.out.println(entry.getValue());
			
			
			index++;
			if (index == 5) {
				break;
			}
		}
	}
}