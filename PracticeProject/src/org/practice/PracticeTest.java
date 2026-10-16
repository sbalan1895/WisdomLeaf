package org.practice;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Comparator;

public class PracticeTest {

	public static void main(String[] args) {

		String input = "Siva";

		printNonRepetitiveCharacters(input);
		
		System.out.println("practice GIT");
	}

	public static void printNonRepetitiveCharacters(String input) {

		String lowerCase = input.toLowerCase();

		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : lowerCase.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		LinkedHashSet<Character> charOrder = new LinkedHashSet<>();

		for (char ch : lowerCase.toCharArray()) {
			charOrder.add(ch);

		}

		System.out.println("Non-Repetitive Characters in " + input + ":");

		boolean flag = false;

		for (char ch : charOrder) {
			if (map.get(ch) == 1) {
				System.out.print(ch + " ");
				flag = true;
			}
		}
		if (flag != false) {
			System.out.println("None");
		}
	}

}

/*
 * int count= 0;
 * 
 * for (int i = 0; i <50 ; i++) { if(i%2!=0) { count++; } }
 * System.out.println(count); } }
 * 
 * /*for (int i = 0; i < 10; i++) { if(i%2==1) {
 * 
 * System.out.println(i); }
 * 
 * }
 * 
 * } }
 * 
 * /* int num= 123; if(num%2==0) { System.out.println(num+ " is even number"); }
 * else { System.out.println(num+ " Not even number"); }
 * 
 * } }
 * 
 * //Number is palindrome or not /*int num = 12321; int temp= num; int rev = 0;
 * 
 * while (num > 0) {
 * 
 * int n = num % 10; rev = (rev * 10) + n; num /= 10; } System.out.println(rev);
 * 
 * if(rev==temp) { System.out.println(rev + " is a palindrom number"); } else {
 * System.out.println(rev + " is not a palindrome number"); } } }
 * 
 * // string is palindrom or not /* String word= "malayalam";
 * 
 * String rev= "";
 * 
 * for (int i= word.length()-1; i>=0; i--) {
 * 
 * rev= rev+word.charAt(i); }
 * 
 * System.out.println(rev);
 * 
 * if(rev.equals(word)) { System.out.println(word+ " is palindrom"); } else {
 * System.out.println(word+ " is not palindrom"); }
 * 
 * } }
 * 
 * /*String input = "Automaation"; printNonRepetitiveCharacters(input);
 * 
 * }
 * 
 * public static void printNonRepetitiveCharacters(String input) {
 * 
 * String lowerCase = input.toLowerCase();
 * 
 * HashMap<Character, Integer> map = new HashMap<>();
 * 
 * for (char ch : lowerCase.toCharArray()) { map.put(ch, map.getOrDefault(ch, 0)
 * + 1);
 * 
 * }
 * 
 * LinkedHashSet<Character> charOrder = new LinkedHashSet<>();
 * 
 * for (char ch : lowerCase.toCharArray()) {
 * 
 * charOrder.add(ch); }
 * 
 * System.out.println("Non-Repetitive character found for " + input + ":");
 * 
 * boolean found = false;
 * 
 * for (char ch : charOrder) {
 * 
 * if (map.get(ch)==1) {
 * 
 * System.out.print(ch + " "); found= true; } } if (!found) {
 * System.out.println("None"); }
 * 
 * }
 * 
 * }
 * 
 * /* String input = "Automation"; printNonRepetitiveCharacters(input); }
 * 
 * public static void printNonRepetitiveCharacters(String input) {
 * 
 * String lowerCase = input.toLowerCase();
 * 
 * HashMap<Character, Integer> map = new HashMap<>();
 * 
 * for (char ch : lowerCase.toCharArray()) {
 * 
 * map.put(ch, map.getOrDefault(ch, 0) + 1); }
 * 
 * LinkedHashSet<Character> charOrder = new LinkedHashSet<>();
 * 
 * for (char ch : lowerCase.toCharArray()) { charOrder.add(ch); }
 * 
 * System.out.println("Non-repetitive character in \" " + input + "\": ");
 * 
 * boolean found = false;
 * 
 * for (char ch : charOrder) { if (map.get(ch) == 1) { System.out.print(ch +
 * " "); found = true; } } if (!found) { System.out.println("None"); } }
 * 
 * }
 * 
 * // public static void main(String[] args) {
 * 
 * // import java.util.HashMap; // import java.util.LinkedHashSet; // // public
 * class NonRepetitiveCharacterFinder {
 * 
 * /* public static void main(String[] args) { String input = "Automation";
 * printNonRepetitiveCharacters(input); }
 * 
 * public static void printNonRepetitiveCharacters(String input) { // Step 1:
 * Convert string to lowercase for case-insensitive comparison String lowerInput
 * = input.toLowerCase();
 * 
 * // Step 2: Create a HashMap to store character frequencies HashMap<Character,
 * Integer> charCountMap = new HashMap<>();
 * 
 * // Step 3: Count frequency of each character for (char ch :
 * lowerInput.toCharArray()) { charCountMap.put(ch,
 * charCountMap.getOrDefault(ch, 0) + 1); }
 * 
 * // Step 4: Use LinkedHashSet to preserve character insertion order
 * LinkedHashSet<Character> charOrder = new LinkedHashSet<>(); for (char ch :
 * lowerInput.toCharArray()) { charOrder.add(ch); }
 * 
 * // Step 5: Print non-repetitive characters
 * System.out.print("Non-repetitive characters in \"" + input + "\": "); boolean
 * found = false;
 * 
 * for (char ch : charOrder) { if (charCountMap.get(ch) == 1) {
 * System.out.print(ch + " "); found = true; } }
 * 
 * // Step 6: If no unique characters found if (!found) {
 * System.out.print("None"); } } // }
 * 
 * 
 * } // }
 * 
 * /*String array[]= {"selenium", "automation", "manual", "selenium","test",
 * "test"};
 * 
 * boolean repeat= false;
 * 
 * for (int i = 0; i < array.length; i++) {
 * 
 * for (int j = i+1; j < array.length; j++) {
 * 
 * if(array[i]==array[j]) { System.out.println("Duplicate found: "+array[i]);
 * repeat=true; break; }
 * 
 * } if(repeat==false) { System.out.println("Duplicate not found"); break; }
 * 
 * }
 * 
 * } }
 * 
 * //unique element in integer array
 * 
 * /*Integer array[] = { 1, 3, 1, 2, 5, 2, 6 }; HashMap<Integer, Integer> map =
 * new HashMap<>();
 * 
 * for (int i = 0; i < array.length; i++) { if (map.containsKey(array[i])) {
 * map.put(array[i], map.get(array[i]) + 1); } else { map.put(array[i], 1); } }
 * for (Map.Entry imap : map.entrySet()) { if (imap.getValue().equals(1)) {
 * System.out.println("Unique element found: " + imap.getKey()); } }
 * 
 * } }
 * 
 * // //Literal String // String s= "Java"; // String s1= "Java"; // //
 * System.out.println(System.identityHashCode(s)); //
 * System.out.println(System.identityHashCode(s1)); // // //Non-Literal String
 * // // String s2= new String("Java"); // String s3= new String("Java"); // //
 * System.out.println(System.identityHashCode(s2)); //
 * System.out.println(System.identityHashCode(s3)); // // // } // //}
 * 
 * // import java.util.*; // // public class BatchSplitter { /* public static
 * <T> List<List<T>> createBatches(List<T> input, int batchSize) { List<List<T>>
 * result = new ArrayList<>(); for (int i = 0; i < input.size(); i += batchSize)
 * { result.add(input.subList(i, Math.min(i + batchSize, input.size()))); }
 * return result; }
 * 
 * public static void main(String[] args) { List<Integer> data =
 * Arrays.asList(1, 2, 3, 4, 5, 6, 7); List<List<Integer>> batches =
 * createBatches(data, 3); System.out.println(batches); } }
 * 
 * 
 * // int val=10; // // public static void main(String[] args) {
 * 
 * // PracticeTest obj= new PracticeTest(); // // System.out.println(obj.val);
 * // // var xyFile:File= File.createTempFile();
 * 
 * 
 * // } // }
 * 
 * /* // Step 1: Define the input string String input = "Automation";
 * 
 * // Step 2: Convert the string to lowercase to make it case-insensitive input
 * = input.toLowerCase();
 * 
 * // Step 3: Create a LinkedHashMap to store character frequencies
 * Map<Character, Integer> charFrequency = new LinkedHashMap<>();
 * 
 * // Step 4: Loop through each character and count frequencies for (char ch :
 * input.toCharArray()) { charFrequency.put(ch, charFrequency.getOrDefault(ch,
 * 0) + 1); }
 * 
 * // Step 5: Print characters with frequency greater than 1 (repetitive)
 * System.out.println("Repetitive Characters:"); for (Map.Entry<Character,
 * Integer> entry : charFrequency.entrySet()) { if (entry.getValue() > 1) { //
 * System.out.println(entry.getKey() + " → " + entry.getValue() + " times");
 * System.out.println("Repetitive element found: "+entry.getKey()); } } }
 * 
 * 
 * } // Step 1: Declare the input string /*String input = "Automation";
 * 
 * // Step 2: Convert to lowercase to make the search case-insensitive input =
 * input.toLowerCase();
 * 
 * // Step 3: Use LinkedHashMap to store character frequency (preserves order)
 * Map<Character, Integer> charFrequency = new LinkedHashMap<>();
 * 
 * // Step 4: Loop through characters and populate frequency map for (char ch :
 * input.toCharArray()) { // If character already exists, increment its count;
 * else add with count 1 charFrequency.put(ch, charFrequency.getOrDefault(ch, 0)
 * + 1); }
 * 
 * // Step 5: Display non-repetitive characters
 * System.out.println("Non-Repetitive Characters:"); for (Map.Entry<Character,
 * Integer> entry : charFrequency.entrySet()) { if (entry.getValue() == 1) {
 * System.out.print(entry.getKey() + " "); } }
 * 
 * // Step 6: Display repetitive characters
 * System.out.println("\nRepetitive Characters:"); for (Map.Entry<Character,
 * Integer> entry : charFrequency.entrySet()) { if (entry.getValue() > 1) {
 * System.out.print(entry.getKey() + " "); } } }
 * 
 * 
 * 
 * }
 * 
 * 
 * /*String word = "window";
 * 
 * for (int i = 0; i < word.length(); i++) {
 * 
 * char charAt = word.charAt(i); boolean flag = false;
 * 
 * for (int j = i + 1; j < word.length(); j++) { if (charAt == word.charAt(j)) {
 * System.out.println(charAt + " is repeated"); // flag = true; // break; }
 * 
 * } if (flag == false) { System.out.println(charAt + " is not repeated"); //
 * break; } }
 * 
 * } }
 * 
 * /* String word="Automation";
 * 
 * char ch = word.charAt(1);
 * 
 * boolean flag= false;
 * 
 * for (int i = 2; i < word.length()-1; i++) { if(ch==word.charAt(i)) {
 * System.out.println(ch+ " is repeated"); flag=true; break; } } if(flag==false)
 * { System.out.println(ch+ " is not repeated"); } } }
 * 
 * /* String word = "Automtion";
 * 
 * for (int i = 0; i < word.length(); i++) {
 * 
 * char ch = word.charAt(i); boolean flag = false;
 * 
 * for (int j = i + 1; j < word.length(); j++) {
 * 
 * if (ch == word.charAt(j)) {
 * System.out.println("First non-repetitive element found: " + ch); flag= true;
 * break; }
 * 
 * } if (flag == false) { System.out.println("No repetitive element found: "+
 * ch); break; } }
 * 
 * } }
 * 
 * // // Step 1: Input string // String input = "Automation"; // // // Step 2:
 * Convert to lowercase for case-insensitive comparison // input =
 * input.toLowerCase(); // // // Step 3: HashSet to store seen characters //
 * HashSet<Character> seenCharacters = new HashSet<>(); // // // Step 4: Counter
 * for number of repetitions found // int repetitionCount = 0; // // // Step 5:
 * Loop through each character // for (char ch : input.toCharArray()) { // if
 * (seenCharacters.contains(ch)) { // repetitionCount++; // // // Step 6: If
 * it's the second repetitive character, print and exit // if (repetitionCount
 * == 2) { // System.out.println("Second Repetitive Character: " + ch); //
 * return; // } // // } else { // seenCharacters.add(ch); // Step 7: Add new
 * character to set // } // } // // // Step 8: If loop ends without finding
 * second repetition //
 * System.out.println("Less than two repetitive characters found."); // } // //}
 * 
 * // // Step 1: Input string // String input = "Automation"; // // // Step 2:
 * Convert the string to lowercase to make it case-insensitive // input =
 * input.toLowerCase(); // // // Step 3: Create a HashSet to store already seen
 * characters // HashSet<Character> seenCharacters = new HashSet<>(); // // //
 * Step 4: Initialize a variable to hold the first repeated character // char
 * firstRepetitiveChar = '\1'; // Null character // // // Step 5: Iterate
 * through the characters of the string // for (char ch : input.toCharArray()) {
 * // // Step 6: Check if character already exists in HashSet // if
 * (seenCharacters.contains(ch)) { // // Step 7: If yes, this is the first
 * repeated character // firstRepetitiveChar = ch; // break; // Exit the loop
 * once the first repetition is found // } else { // // Step 8: If not, add the
 * character to the HashSet // seenCharacters.add(ch); // } // } // // // Step
 * 9: Display result // if (firstRepetitiveChar != '\0') { //
 * System.out.println("First Repetitive Character: " + firstRepetitiveChar); //
 * } else { // System.out.println("No repetitive characters found."); // } // }
 * // //}
 * 
 * /* String word= "Automation";
 * 
 * for (int i = 0; i < word.length(); i++) { char ch = word.charAt(i); boolean
 * flag= false;
 * 
 * for (int j = i+1; j < word.length(); j++) { if(ch == word.charAt(j)) {
 * System.out.println("First repetitive element found: "+ch); flag= true; break;
 * } } if(flag==false) { System.out.println("No repetitive element found");
 * break; } } } }
 * 
 * // String word= "Automtion"; // // HashSet<String> map= new HashSet<>(); //
 * // for (int i = 0; i < word.length(); i++) { // // char ch = word.charAt(i);
 * // // if(ch==word.charAt(i)) { //
 * System.out.println("First repetitive element found: "+ch); // return; // } //
 * else { // map.add(word); // System.out.println("else loop excuted"); // } //
 * } // System.out.println("No repetitive element found"); // // } // }
 * 
 * /*String word= "Automation";
 * 
 * String rev= "";
 * 
 * for(int i= word.length()-1; i>=0; i--) { rev= rev+ word.charAt(i); }
 * System.out.println(rev); } }
 * 
 * 
 * // String word= "Automation"; // // HashSet<String> map= new HashSet<>(); //
 * // for (int i = 0; i < word.length(); i++) { // // char ch= word.charAt(i);
 * // if(ch==word.charAt(i)) { //
 * System.out.println("First repetitve element found: "+ch); // return; // } //
 * else { // map.add(word); // } // // } //
 * System.out.println("No repetitive element found"); // } // // }
 * 
 * /*String original= "welcome to java practice"; String rev= "";
 * 
 * for (int i=original.length()-1; i >= 0; i--) { rev+= original.charAt(i);
 * 
 * } System.out.println(rev); } }
 * 
 * // repetitive element in array string
 * 
 * /* String words[] = { "testing", "automation", "manual", "testing", "by",
 * "java" };
 * 
 * boolean flag = false;
 * 
 * for (int i = 0; i < words.length; i++) {
 * 
 * for (int j = i + 1; j < words.length; j++) { if (words[i] == words[j]) {
 * System.out.println("Repetitive element found: " + words[i]); flag = true;
 * break; } } if (!flag) { System.out.println("No Repetitive element found"); }
 * } } }
 * 
 * 
 * 
 * // first repetitive element /* String word= "Automation".toLowerCase();
 * 
 * HashSet<Character> map= new HashSet<>();
 * 
 * for (Character ch : word.toCharArray()) {
 * 
 * if(map.contains(ch)) {
 * System.out.println("First repetitive element is: "+ch); return; } else {
 * map.add(ch); }
 * 
 * } System.out.println("No repetitive element found"); } }
 * 
 * /*String word = "Automation";
 * 
 * for (int i = 0; i < word.length(); i++) {
 * 
 * char ch = word.charAt(i); boolean flag = false;
 * 
 * for (int j = i + 1; j < word.length(); j++) {
 * 
 * if (ch == word.charAt(j)) {
 * 
 * System.out.println("Duplicate element found: " + ch); flag = true; break; } }
 * if (flag == false) { System.out.println("Duplicate not Found: "+ch); break; }
 * 
 * }
 * 
 * } }
 * 
 * /* List<String> obj= new ArrayList<>();
 * 
 * obj.add("Apple"); obj.add("grapes"); obj.add("orange"); obj.add("papaya");
 * 
 * System.out.println("Before reverse "+obj);
 * 
 * Collections.reverse(obj);
 * 
 * System.out.println("After reverse "+obj);
 * 
 * 
 * // obj.add(0, "pineapple"); // obj.add(5, "pomogrante");
 * 
 * // System.out.println("After insertion "+obj);
 * 
 * // System.out.println("Index-3 element: "+ obj.get(3));
 * 
 * // if(obj.contains("axe")) { // System.out.println("Element found"); // } //
 * else { // System.out.println("Element not found"); // }
 * 
 * 
 * } }
 * 
 * 
 * /*List<String> obj= new ArrayList<String>();
 * 
 * obj.add("sivabalan"); obj.add("is a good"); obj.add("manual cum");
 * obj.add("automation Tester");
 * 
 * for (String string : obj) { System.out.print(string); }
 * 
 * 
 * } }
 */

/*
 * String word = "Automation";
 * 
 * for (int i = 0; i < word.length(); i++) {
 * 
 * char ch = word.charAt(i); boolean repeat = false;
 * 
 * for (int j = i+1; j < word.length(); j++) { if (ch == word.charAt(j)) {
 * System.out.println("Duplicate found: " + ch); // repeat = true; // break; } }
 * if (!repeat) { System.out.println("Duplicate not found "+ ch); break; } }
 * 
 * } }
 */
//		int array[]= {1,2,5,2,7,6,9};
//		Set<Integer> list= new LinkedHashSet<>();
//
//		for (int i = 0; i < array.length; i++) {
//			list.add(array[i]);
//		}
//		for (Integer integer : list) {
//			System.out.println(integer);
//
//		}
//	}
//	}

/*
 * Integer array[] = { 1, 2, 3, 1, 4, 5, 7, 3, 2 }; HashSet<Integer> map = new
 * HashSet<>();
 * 
 * boolean flag = false;
 * 
 * for (int i = 0; i < array.length; i++) { for (int j = i+1; j < array.length;
 * j++) { if (array[i] == array[j]) { System.out.println(array[i]); flag = true;
 * break; } } if (flag == false) { System.out.println("no duplicate"); } }
 * 
 * }
 * 
 * }
 * 
 * // String array[] = { "test", "automation", "manual", "automation" }; //
 * HashSet<String> map = new HashSet(); // // boolean flag = false; // // for
 * (String string : array) { // if (map.add(string)==false) { //
 * System.out.println("Duplicate found: " + string); // flag = true; // break;
 * // } // // } // if (flag = false) { //
 * System.out.println("Duplicate not found"); // } // } //}
 * 
 * // int array[]= {2,1,4,1,5,6,2}; // // HashSet<Integer>map=new HashSet<>();
 * // boolean flag=false; // // for(Integer l:array) { // if(map.add(l)==false)
 * { // System.out.println("Duplicate element found: "+l); //// flag=true; // }
 * // } //// if(flag==false) { //// System.out.println("No Duplicate Found");
 * //// } // // }
 * 
 * // dplicate from array
 * 
 * /* int array[]= {1,2,3,1,5,2};
 *
 * boolean flag= false;
 *
 * for (int i = 0; i < array.length; i++) { for (int j = i+1; j < array.length;
 * j++) { if(array[i]==array[j]) {
 * System.out.println("Dublicate element found: "+array[i]); flag=true;
 *
 * }
 *
 * } if(flag==false) { System.out.println("No duplicate found"); }
 *
 * } }
 */

/*
 * String array[]= {"java","c","c++","phython","Java"}; HashSet<String> lang=
 * new HashSet();
 *
 * boolean flag= false;
 *
 * for(String l:array) { if(lang.add(l)==false) {
 * System.out.println("Duplicate element found: "+l); flag=true; } }
 * if(flag==false) { System.out.println("Duplicate element not found "); } }
 */

/*
 * boolean flag= false; for (int i = 0; i < array.length; i++) { for (int j =
 * i+1; j < array.length; j++) { if(array[i]==array[j]) {
 * System.out.println("Found Duplicate element: "+array[i]); flag=true; } }
 * if(flag==false) { System.out.println("Duplicate element not found"); } }
 *
 * }
 */

// maximum value in array
/*
 * int number[]= {1,9,3,5,8}; int max= number[0];
 *
 * for (int i = 0; i < number.length; i++) { if(number[i]>max) {
 *
 * max= number[i]; } } System.out.println(max); }
 */
//		System.out.println("Before sorting: "+ Arrays.toString(number));
//
//		Arrays.sort(number);
//
//		System.out.println("After sorting: "+ Arrays.toString(number));
//	}

//		String name= "siva";
//		String rev= "";
//
//		for(int i=name.length()-1; i>=0; i--) {
//
//			rev= rev+name.charAt(i);
//		}
//		System.out.println(rev);
//	}

//		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <=6; j++) {
//				System.out.println(i);
//			}
//	}
//	}

// swap without 3rd variable
//		int a= 10;
//		int b= 20;
//
//		a= a+b;
//		b=a-b;
//		a=a-b;
//
//		System.out.println("a is '10', after Swap a is "+a);
//		System.out.println("b is '20', after Swap b is "+b);
//	}

// swap using 3rd variable
//		int a=10;
//		int b=20;
//		int temp=0;
//
//		temp=a;
//		a=b;
//		b=temp;
//
//		System.out.println("Early 'a' is 10, after swap a= "+a);
//		System.out.println("Early 'b' is 20, after swap b= "+b);
//
//	}

// sum of numb
// int num=1234, sum=0;
// while(num>0) {
// int n= num%10;
// sum= sum+n;
// num= num/10;
// }
// System.out.println(sum);
//
// }
// count digits
// int numb=1111;
// int count=0;
//
// while(numb>0) {
// count++;
// numb= numb/10;
// }
// System.out.println("no.of digits in 1111 is "+count);
// }
//
// int numb= 12321, revs=0, temp= numb;
//
// while(numb!=0) {
//
// int remd= numb%10;
// revs= (revs*10)+ remd;
// numb= numb/10;
//
// }
// if(temp==revs) {
// System.out.println(revs+ " is a palindrom");
// }
// else {
// System.out.println(" 12321 is not a palindrom");
// }
// }
// int num= 1234, rev= 0;
//
// while(num!=0) {
// int rem= num%10;
// rev= (rev*10)+rem;
// num= num/10;
//
// }
// System.out.println(rev);
// }

//}

//check palindrome number

//	int num=12320;
//	int temp= num;
//	int rev=0;
//
//	while(num!=0) {
//		int rem= num%10;
//		rev= (rev*10)+rem;
//		num= num/10;
//	}
//	if(temp==rev) {
//	System.out.println("Number 12321 is Palindrome "+ temp);
//	}
//	else {
//		System.out.println("Number 12321 is not Palindrome "+ temp);
//	}
//	}

//	public PracticeTest() {
//		System.out.println("No Argument Constructor");
//	}

//	public static void main(String[] args) {
// Scanner
//			 Scanner scan = new Scanner(System.in);
//
//			 String name = scan.next();
//			 int xprns = scan.nextInt();
//			 System.out.println("Employee Name is "+ name);
//			 System.out.println("Working exprience "+ xprns);

//		PracticeTest pt = new PracticeTest();

//		String name="Sivabalan";
//
//		System.out.print("Hello \n"+name);
//
//		int a=74;
//		int b= 36;
//		int c=110;
//
//		int sum=a+b;
//
//		if(sum==c) {
//			System.out.println("Expected and Actual sum is equal as "+sum);
//		}
//		else {
//			System.out.println("Excepted output not acheived");
//		}

//		float a=50/3f;
//
//		System.out.println("Divided result is "+a);

//		int a=125;
//		int b=24;
//
//		int sum=a+b;
//		int diff=a-b;
//		int multi=a*b;
//		int divid=a/b;
//		int remain=a%b;
//
//		System.out.println("add is "+sum );
//		System.out.println("mult is "+ multi);
//		System.out.println("subract is "+ diff);
//		System.out.println("divide is "+ divid);
//		System.out.println("divdnt is "+ remain);

//		public static int addTwoNumber(int a, int b) {
//			return a+b;
//		}
//		public static void main(String[] args) {
//			PracticeTest pt=new PracticeTest();
//			int twoNumber = pt.addTwoNumber(4, 5);
//			System.out.println(twoNumber);

//	public static void main(String[] args) {

//		for (int i = 1; i <= 10; i++) {
//			if (i%2==0) {
//				System.out.println(i);

//		int count=0;
//		for (int i = 0; i <=20; i++) {
//			if(i%2==0) {
//				count++;
//			}
//
//		}
//				System.out.println(count);
//			}

//		int a=11;
//
//		if(a%2!=0) {
//		System.out.println("a is an odd number");
//		}
//
//		else {
//		System.out.println("a is an even number");
//
//		}

//		int sum= 0;
//
//		for (int i = 1; i <=10; i++) {
//			if(i%2!=0) {
//				 sum = i;
//			}
//
//		}
//		System.out.println(sum);
//		}

//	public static void main(String[] args) {
//
//		int num=1234, rev=0;
//
//		for(; num!=0; num= num/10) {
//
//			int rem= num%10;
//
//			rev= (rev*10)+rem;
//			}
//
//		System.out.println("Reversed number is "+rev);
//		}
//

//		reverse number
//		int num= 1234, rev=0;
//
//		while(num!=0) {
//			int rem= num%10;
//
//			rev= (rev*10)+rem;
//
//			num= num/10;
//		}
//		System.out.println("Reverse number is "+rev);
//

//count even number from 1-100

//		int count=0;
//		for (int i = 0; i <=100; i++) {
//			if (i%2==0) {
//				count++;
//
//			}
//
//		}
//		System.out.println(count);

//count odd number from 1-10

//		int count=0;
//
//		for (int i = 0; i <=11; i++) {
//			if (i%2!=0) {
//
//				count++;
//
//			}
//		}
//		System.out.println(count);
//
//find even number 1-10

//		for(int i=0; i<=10; i++){
//
//			if(i%2==0) {
//				System.out.println(i);
//
//			}
//
//		}

//find odd numbers from 1-10
//		for (int i = 0; i <=10; i++) {
//
//			if (i%2!=0) {
//				System.out.println(i);
//
//			}
//
//		}

//find even number or not
//		int s=10;
//		if(s%2==1) {
//			System.out.println(s+ " is even number");
//		}
//		else {
//			System.out.println("s is not a even number");
//		}
//
//		int a[] = new int[5];
//
//		a[0]=11;
//		a[1]=22;
//		a[2]=33;
//		a[3]=44;
//		a[4]=55;
//
//
////		System.out.println(a[3]);
//
//		int len= a.length;
//
//		System.out.println(len);
