package org.practice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class InterviewPreparation {

	public static void main(String[] args) {

//		String word="Practicing Java for Automation Testing";
//		
//		HashSet<Character> map= new HashSet<>();
//		
////		String[] split = word.split("");
//		
//		for (int i = 0; i < args.length; i++) {
//			
//		}
//	}
//	}

		/*
		 * String input = "Automation".toLowerCase(); // Case-insensitive char[] chars =
		 * input.toCharArray();
		 * 
		 * // Use LinkedHashMap to preserve insertion order Map<Character, Integer>
		 * charCount = new LinkedHashMap<>();
		 * 
		 * // Count occurrences of each character for (char ch : chars) {
		 * charCount.put(ch, charCount.getOrDefault(ch, 0) + 1); }
		 * 
		 * // Find first character with count 1 for (Map.Entry<Character, Integer> entry
		 * : charCount.entrySet()) { if (entry.getValue() == 1) {
		 * System.out.println("First Non-Repetitive Character: " + entry.getKey());
		 * return; } }
		 * 
		 * System.out.println("No Non-Repetitive Character Found."); }
		 * 
		 * }
		 * 
		 * 
		 * /*String input = "Automation".toLowerCase(); // Case-insensitive comparison
		 * HashSet<Character> seenChars = new HashSet<>();
		 * 
		 * for (char ch : input.toCharArray()) { if (seenChars.contains(ch)) {
		 * System.out.println("First Repetitive Character: " + ch); return; } else {
		 * seenChars.add(ch); } }
		 * 
		 * System.out.println("No Repetitive Character Found."); } }
		 * 
		 * /* String word = "Automation";
		 * 
		 * for (int i = 0; i < word.length(); i++) {
		 * 
		 * char ch = word.charAt(i); boolean flag = false;
		 * 
		 * for (int j = i + 1; j < word.length(); j++) { if (ch == word.charAt(j)) {
		 * System.out.println("Duplicate found: " + ch); flag = true; break; } } if
		 * (flag == false) { System.out.println("Duplicate Not Found"); // break; }
		 * 
		 * } } }
		 */

		/*
		 * Integer number[] = { 10, 20, 10, 22, 11, 20, 33 };
		 *
		 * Set<Integer> set = new LinkedHashSet<Integer>();
		 *
		 * for (int i = 0; i < number.length; i++) { set.add(number[i]); }
		 *
		 * for (Integer integer : set) { System.out.println(integer); } } }
		 */

//		String name="sbalan018@";
//		char[] charArray = name.toCharArray();
//
//		int number = charArray.length;
//
//		System.out.println(number);
//
//	}
//	}

// occurrence in string
//		String sentence= "today is tuesday";
//		HashMap<Character, Integer> map= new HashMap<>();
//
//		for (int i = 0; i < sentence.length(); i++) {
//			char ch= sentence.charAt(i);
//
//			if(ch!=' ') {
//				if(map.containsKey(ch)) {
//					map.put(ch, map.get(ch)+1);
//				}
//				else {
//					map.put(ch, 1);
//				}
//			}
//		}
//		for (char key : map.keySet()) {
//
//			System.out.println(key+ "=" + map.get(key));
//		}
//
//	}
//	}

//		        int[] arr = {0, 2, 4, 6, 8, 10};
//		        int target = 10;
//		        List<Integer> current = new ArrayList<>();
//
//		        System.out.println("Subsets with sum = " + target + ":");
//		        findSubsets(arr, 0, target, current);
//		    }
//
//		    // Recursive method to find subsets
//		    public static void findSubsets(int[] arr, int index, int target, List<Integer> current) {
//		        if (target == 0) {
//		            System.out.println(current);
//		            return;
//		        }
//
//		        if (index >= arr.length || target < 0) {
//		            return;
//		        }
//
//		        // Include current element
//		        current.add(arr[index]);
//		        findSubsets(arr, index + 1, target - arr[index], current);
//
//		        // Backtrack: exclude current element
//		        current.remove(current.size() - 1);
//		        findSubsets(arr, index + 1, target, current);
//		    }
//
//
//	}
//
//		String sentence= "Welcome to java class";
//		String rev= " ";
//
//		String[] words = sentence.split(" ");
//
//		for (String word : words) {
//			String s=" ";
//
//			for (int i=word.length()-1; i>=0; i--) {
//				char ch= word.charAt(i);
//				s= s+ch;
//			}
//			rev= rev+s+" ";
//		}
//			System.out.println(rev);
//	}
//}
//		String word[]= {"A","B","A","C","D"};
//		HashMap<String, Integer> map= new HashMap<>();
//
//		for (int i = 0; i < word.length; i++) {
//			if(map.containsKey(word[i])) {
//				map.put(word[i], map.get(word[i])+1);
//			}
//			else {
//				map.put(word[i], 1);
//			}
//		}
//		System.out.println(map);
//		for (Map.Entry m:map.entrySet()) {
//			if(m.getValue().equals(1)) {
//				System.out.println(m.getKey()+" is repeated");
//			}
//
//		}
//
//	}
//}
// First repetitive character

		String word = "Automation";

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			boolean repeat = false;

			for (int j = i + 1; j < word.length(); j++) {
				if (ch == word.charAt(j)) {
					System.out.println(word);
					System.out.println(ch + " is repeated");
					repeat = true;
					break;
				}
			}
			if (repeat == false) {
				System.out.println(ch + " not repeated");
				System.out.println("Unique element found");
				break;
			}
		}
	}
}

// unique element in the array
//
//		Integer array[] = { 2, 5, 6, 2, 5, 7, 2 };				//array initialisation
//		HashMap<Integer,Integer> map = new HashMap<>();
//
//		for (int i = 0; i < array.length; i++) {
//			if (map.containsKey(array[i])) {					//check number already exists in map
//				map.put(array[i], map.get(array[i]) + 1);		// count increase for the map value
//			} else {
//				map.put(array[i], 1);							//added to map key as count 1
//			}
//		}
//
//		System.out.println(map);
//		for (Map.Entry m : map.entrySet()) {					//check each key and value in the map
//			if (m.getValue().equals(1)) {						//if map value count is 1, it print it's key
//				System.out.println("unique number is " + m.getKey());
//			}
//		}
//	}
//}

// ---------------------------------*****-----------------------------------

//reverse string
//		String name= "sivabalan";
//		String rev= "";
//
//		for(int i=name.length()-1; i>=0; i--) {
//
//			rev= rev+name.charAt(i);
//		}
//		System.out.println(rev);
//
