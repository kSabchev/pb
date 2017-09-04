package com.homework.lfm;

public class NumberTest {


	public static void main(String[] args) {
	String number = "+359887006019";
	System.out.println(number + " " + ch(number));
	String number2 = "00359887006019";
	System.out.println(number2 + " " + ch(number2));
	String a = "0898123123";
	System.out.println(a + " " + ch(a));
	String b = "+3598888888888";
	System.out.println(b + " " + ch(b));
//	Scanner in = new Scanner(System.in);
//	String number2 = in.next();
//	System.out.println(ch(number2));
	
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
}

