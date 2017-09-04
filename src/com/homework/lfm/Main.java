package com.homework.lfm;


public class Main {

	public static void main(String[] args) {
		 Phonebook ClassPhonebook = new Phonebook();
		 ClassPhonebook.createNewPhonebook("phonebook.txt");
//		 System.out.println();
//		 System.out.println();
//		 ClassPhonebook.printAll();
//		 System.out.println();
//		 System.out.println();
//		 ClassPhonebook.addPair("A", "0880");
//		 ClassPhonebook.addPair("B", "0887123456");
//		 ClassPhonebook.addPair("C", "0888888888");
//		 ClassPhonebook.addPair("Z", "+359887123123");
//		 ClassPhonebook.printAll();
//		 System.out.println();
//		 ClassPhonebook.addPair("A", "0887006019");
//		 System.out.println();
		 ClassPhonebook.printAll();
		 
		 
		 call(ClassPhonebook, "Raya", 100);
		 call(ClassPhonebook, "mama", 50);
		 call(ClassPhonebook, "Miro", 4);
		 call(ClassPhonebook, "chicho", 17);
		 call(ClassPhonebook, "Ivan", 10);
		 
		 System.out.println("");
		 ClassPhonebook.printFiveMostCalled();
		 
		 

	}
	
	private static void call(Phonebook ClassPhonebook, String name, int numberOfCalls) {
		Contact contact = ClassPhonebook.accessContactByName(name);
		if(contact != null) {
			for(int i = 0; i < numberOfCalls; i++) {
				contact.call();
			}
		}
	}

}

