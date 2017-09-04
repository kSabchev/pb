package com.homework.lfm;


public class Contact {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws InvalidNumberException {
		this.phone = checkPhone(phone);
	}

	public int getNumCalls() {
		return numCalls;
	}

	private String name;
	private String phone;
	private int numCalls;
	
	private Contact() {
	}
	
	private String checkPhone (String phone) throws InvalidNumberException {
		
		if(ch(phone)){ return phone;
		}
		else throw new InvalidNumberException(phone);
		
	}
	
	@Override
	public String toString() {
		return "name: " + getName() + ", phone number: " + getPhone() + ", Called: " + getNumCalls();
	}

	public void call() {
		numCalls++;
	}
	
	
	public static Boolean ch(String p) {
		int i = 0;
		if((p.length() == 13)&&(p.substring(0, 4).equals("+359"))){
		 i = 4;}
		
		if((p.length() == 10) && (p.substring(0,1).equals("0"))) {
		i = 1 ;}
		if((p.length() == 14) && (p.substring(0,5).equals("00359"))) {
			i = 5;}
		if(i!= 0) {	
				int a = Integer.parseInt(p.substring(i,i+2));
				if(a <90 && a>86) {
					int b = Integer.parseInt(p.substring(i+2,i+3));
					if(b >1 && b <10) {
						int c = Integer.parseInt(p.substring(i+3));
						if(c >0 && c <1000000) {
							return true;
						}
					}
				}
			}
	return false;
	}

	public static class Builder {

		Contact contact;

		public Builder() {
			contact = new Contact();
		}

		public Builder createFromLine(String line) throws InvalidNumberException {
			String[] parts = line.split(", ");
			contact.setName(parts[0]);
			contact.setPhone(parts[1]);
			return this;
		}

		public Builder withName(String name) {
			contact.setName(name);
			return this;
		}

		public Builder withPhoneNumber(String phone) throws InvalidNumberException {
			contact.setPhone(phone);
			return this;
		}

		public Contact build() {
			return contact;
		}
	}

}