package com.check;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class RegexTest {
	
	public static void main(String[] args) {
		impl2();
		int A = 65;
		int a = 97;
		StringBuilder caps = new StringBuilder();
		StringBuilder smalls = new StringBuilder();
		StringBuilder nums = new StringBuilder();
		StringBuilder splChars = new StringBuilder();
		 
		for(int i=1; i<=26; i++) {
			char Chk  =(char)A;
			caps.append(Chk);
			A++;
			char chk = (char)a;
			smalls.append(chk);
			a++;
//			System.out.print(c);
//			a= a++; // Character.toChars(i) ;
			
		}
		for(int i=0; i<10; i++)
			nums.append(i);
		
		System.out.println("caps: "+caps);
		System.out.println("smalls: "+smalls);
		System.out.println("nums: "+nums);
		System.out.println();
		
		
		String regex = "^[A-Za-z0-9 	!#$%&\'\\[\\]()*+,-./:;<=>?@^_`{|}~ \\\\]*"; 
		
//		String regex1 =  "^[A-Za-z0-9 	!#$%&\'\\[\\]()*+,-./:;<=>?@^_`{|}~ ]*"; 
//						"^[A-Za-z0-9 	!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ]*$"
		// "[^a-zA-Z0-9 ]*"; // "[^\\w\\s]*";
		String splCharss = "[]!@#$%^&*()_+ joseph's dish / test and \\ c check \\ this";
		Pattern pattern = Pattern.compile(regex) ;
		splChars.append("joseph's albulm");
		splChars.append(splCharss);
		
		
		String input = " £ abjjhhh 2342 *&*7 1 asd";
		for(int i=0; i<=4; i++) {
			
			boolean ans = pattern.matcher(input).matches();
			System.out.println(input+"; ans -  "+ans);
			if(!ans) {
//				System.out.println("failure due to "+pattern.matcher(input).group());
			}
			if (i==0) input = caps.toString();
			else if (i==1) input = smalls.toString();
			else if (i==2) input = nums.toString();
			else if(i==3) {
				input = caps.toString()+smalls.toString()+nums.toString()+" "+"	"+""+splCharss;
			}
		}
		int n = 0;
		for(int i=0; i<n; i++) {
			
		}
		
	}

	private static void impl2() {
		// TODO Auto-generated method stub
		
		String input = "check this/ 87 78*&^%^$#@ str // \\  t	t £	t	t	t	t	t	t	t";
		
		String specialCharStr = "!#$%&'[]()*+,-./:;<=>?@^_`{|}~ ]*	 \\";
		Set<Character>  allowedSpecialCharSet = new HashSet<>();
		for(char ch : specialCharStr.toCharArray())
			allowedSpecialCharSet.add(ch);
		
		StringBuilder invalid = new StringBuilder();
		for(char ch : input.toCharArray()) {
			if(!Character.isLetterOrDigit(ch) && !allowedSpecialCharSet.contains(ch)) {
				invalid.append(ch+",");
			}
		}
		if(invalid.length()>0) {
			System.out.println("invalid : "+invalid);
		}
		System.out.println("out IMpl 2");
		
	}

	private static void validateString() {
		// TODO Auto-generated method stub
		System.out.println("-----start-------");
		String regex = "^[A-Za-z0-9 	!#$%&'\\[\\]()*+,-./:;<=>?@^_`{|}~ \\\\]*$";
		List<String> tests = new ArrayList<>();
		tests.add("normal string");
		tests.add("989 num and string");
		tests.add("normal string");
		tests.add("test with numbers 7462 874293");
		tests.add("8834 98 0test with numbers 7462 874293");
		tests.add("&^&*^897 % !2~ ` $ # ,.<>/ ' [] {} check special chars @!%^&*()_+-= 7462 874293");

		Pattern pattern = Pattern.compile(regex) ;
		for(String test : tests) {
//			test += "£";
			boolean ans = pattern.matcher(test).matches();
			System.out.println("checking: "+test+"; ans -  "+ans);
		}
		System.out.println("-----end-------");
//		return pattern.matcher(input).matches();
		
	}
	// regex break down for String regex = "^[A-Za-z0-9 	!#$%&\'\\[\\]()*+,-./:;<=>?@^_`{|}~ \\\\]*$"; 
	//**
		
		^: Asserts the start of the line.
		
		[A-Za-z0-9 !#$%&'\\[\\]()*+,-./:;<=>?@^_{|}~ \\]*`:
		
		[A-Za-z0-9 ]: Character class that allows uppercase and lowercase letters, numerals (0-9), and space.
		!#$%&'\\[\\]()*+,-./:;<=>?@^_{|}~`: Additional allowed special characters (escaped for literal representation in the pattern).
		\\\\: Allows a literal backslash (\\).
		*: Zero or more occurrences of the characters within the character class.
		$: Asserts the end of the line.
		
		So, the regex pattern is designed to match strings that:
		
		Start with the beginning of the line.
		Include uppercase and lowercase letters, numerals, space, and a specific set of special characters.
		Allow for zero or more occurrences of these characters.
		End with the end of the line.
		This pattern seems to be intended for validating strings that consist of alphanumeric characters, spaces, and a specified set of special characters. The use of backslashes (\\) in the character class allows the inclusion of a literal backslash in the valid string.
	

	**//
	
	

}
