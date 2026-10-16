package com.practiceauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;

public class PracticeLogics {

	public static void main(String[] args) {
		
		ArrayList<String> arL= new ArrayList<String>();
		
		arL.add("Chennai");
		arL.add("Nellai");
		arL.add("Trichy");
		arL.add("Madurai");
		arL.add("Salem");
		
		System.out.println("before sorting " + arL.get(2));
		
		Collections.sort(arL);
		
		System.out.println(arL);
		System.out.println("after sorting " + arL.get(2));
		
		System.out.println(arL.remove(1));
		System.out.println(arL);
		
		}
	}
		
	/*	String str= "Sbalan1895@Gmail.Com";
		
		String small="", cap= "", num="", spl="";
		int s=0, c= 0, d= 0, sp= 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if(ch>='a' && ch<='z') {
				small= ch+small;
				s++;
			}
			
			else if(ch>= 'A' && ch <= 'Z'){
				cap= cap+ch;
				c++;
				
			}
			
			else if(ch>= '0' && ch<= '9') {
				num= num+ch;
				d++;
			}
			
			else {
				spl= spl+ch;
				sp++;
			}
			
		}
		
		System.out.println("small letter element are " +small);
		System.out.println("caps letter element are " +cap);
		System.out.println("digits element are " + num);
		System.out.println("special char element are " +spl);
		
		
		}
	}

	/*	String str= "automation";

		System.out.println("Repetative element are:");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int count= 0;

			for (int j = 0; j < str.length(); j++) {
				if(ch== str.charAt(j)) {
					count++;
				}
			}

			if(count> 1) {
				System.out.print(ch+" ");
			}
		}


	}
}

/*	String str= "sivabalan";
		String rev= "";
		for(int i= str.length()-1; i>=0; i--) {
			rev= rev+ str.charAt(i);
		}

		System.out.println(rev);
	}
}

/*	Hashtable<Integer, String> ht= new Hashtable<>();

		ht.put(101, "siva");
		ht.put(102, "balan");

		System.out.println("HastTable o/p:");
		System.out.println(ht);


		HashMap<Integer, String> hm= new HashMap<>();

		hm.put(null, "siva");
		hm.put(102, null);

		System.out.println("HastMap o/p:");
		System.out.println(hm);

	}
}

	/*	int arr[]= {11, 12, 14, 12, 15, 11, 13};

		Set <Integer> set= new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if(!set.add(arr[i])) {
				System.out.println("first repetative element in array is " +arr[0]);
				break;
			}
		}
//
//		for(Integer ar: set) {
//
//			System.out.println(ar);
//		}

	}
}



/*	String str= "automation";
		int repetative= 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch== str.charAt(j)) {
					count++;
				}

			}

			if(count== 1) {

				System.out.println("repetative elements are " +ch);
//				repetative++;
//
//				if(repetative== 3) {
//					System.out.println("third repetative element " +ch);
//				}

			}

		}

	}
}
/*	String str= "automation";

		int repetative= 0;
		boolean found= false;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch== str.charAt(j)) {

					count++;
				}

			}

			if(count> 1) {

				System.out.println("Non-Repetative element are " +ch);
//				repetative ++;

//				if(repetative== 1) {
//					System.out.println("Second repetative element is " +ch);
//				}
//				
				found= true;
//				break;

			}

		}

		if(!found) {
			System.out.println("No repetative elements found");
		}
	}
}

	/*	int arr[]= {11, 13, 12, 14, 15, 11, 15, 13};

		Set <Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			set.add(arr[i]);
		}

		for(Integer dupl: set) {
			System.out.println(dupl);
		}
	}
}

/*	int arr[]= {11, 13, 12, 14, 15, 11, 12};
		int temp=0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if(arr[i] > arr[j]) {
					temp= arr[i];
					arr[i]= arr[j];
					arr[j]= temp;

				}

			}
			System.out.println("minimum value of array is " +arr[i]);
			break;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}



/*	String str= "automation";
		int repetative= 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch== str.charAt(j)) {
					count ++;
				}	

			}

			if(count== 1) {
				System.out.print(ch + " ");
//				repetative++;
//				
//				if(repetative==2) {
//					System.out.println("Second non-repetative element is " +ch);
//				}

			}
		}

	}
}

/*	String str= "Automation";
		String rev= "";

		for(int i= str.length()-1; i >=0; i--) {
			rev= rev+ str.charAt(i);
		}
		System.out.println("Reversed string for Automation is " +rev);
	}
}

/*	String str= "crossing averager in program";

		String[] Sword = str.split(" ");

		for(int i= Sword.length- 1; i>= 0; i-- ) {

			System.out.print(Sword[i] + " ");

		}

	}
}

/*	String str= "automation";

		char[] ch = str.toCharArray();

		Set<Character> uniq = new HashSet<Character>();
		Set<Character> dupl = new HashSet<Character>();

//		for(int i= 0; i< str.length(); i++) {

		for(char chh: ch) {

			if(!uniq.add(chh)) {
				dupl.add(chh);
			}
		}

		System.out.println("Uniq elemets are " + uniq);
		System.out.println("Duplicate elemets are " + dupl);
	}

}


/*	String str= "automation";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch== str.charAt(j)) {
					count ++;
				}

			}

			if(count > 1) {
				System.out.print(ch + " ");
			}

		}

	}
}

/*	for (int i = 5; i >= 1; i--) {

			for (int j = 1; j <= i; j++) {

				System.out.print("*");
			}

			System.out.println();
		}			

	}
}

/*	for (int i = 0; i <=5; i++) {

			for (int j = 0; j <= i; j++) {

				System.out.print("*");

			}

			System.out.println();
		}
	}
}

/*	String str= " welcome to automation testing";

		String[] split = str.split(" ");
		int length = split.length;

		System.out.println("no.of word in string are " + length);

		}
	}

	/*	String str= "Sbalan018@Gmail.Com";

		int s= 0, c= 0, spl= 0, num= 0;

		String small="", caps= "", dig= "", splC= "";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if(ch > 'a' && ch < 'z') {

				s++;
				small= small+ ch;

			}

			else if(ch> 'A' && ch< 'Z') {
				c++;
				caps= caps+ ch;

			}

			else if(ch> '0' && ch< '9') {
				num++;
				dig= dig+ ch;
			}

			else {
				spl++;
				splC= splC+ ch;
			}
		}

		System.out.println("small letter chars are " + small);
		System.out.println("small letter chars are " + caps);
		System.out.println("small letter chars are " + dig);
		System.out.println("small letter chars are " + splC);
	}
}

/*	String str= "automationm";
		String SecondRep= "";

		int count= 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			boolean alreadyRepeted= false;

			for (int j = 0; j < i; j++) {

				if(ch == str.charAt(j)) {
					alreadyRepeted= true;
					break;
				}

			}

			if(alreadyRepeted) {
				count++;

				if(count == 2) {
					System.out.println("Second repetative char is " +ch);
				}
			}

		}

	}
}

/*	for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch == str.charAt(j)) {
					count++;
				}

			}

			if(count > 1) {
				System.out.println("repetative chars are " +ch);
//				break;
			}

		}



		}
	}

	/*	int arr[]= {11, 14, 13, 14, 15, 11, 10, 18, 17, 18};

		for (int i = 0; i < arr.length; i++) {

			for (int j = i+1; j < arr.length; j++) {

				if(arr[i]== arr[j]) {

					System.out.println("Repetative numbers from array are " +arr[i]);
					break;
				}

			}

		}

	}
}

/*	int arr[]= {11, 14, 13, 14, 15, 11, 10, 18, 17, 18};

		Set<Integer> set= new LinkedHashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {

			set.add(arr[i]);

		}

		for (Integer arrr : set) {

			System.out.println("Non-repetative numbers in array are " +arrr);
		}

	}
}

/*	int arr[]= {11, 14, 13, 14, 15, 11, 10, 18, 17, 18};
		int temp= 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if(arr[i] > arr[j]) {

					temp= arr[i];
					arr[i]= arr[j];
					arr[j]= temp;

				}

			}

		}

		System.out.println("Second largest number in array is " +arr[2]);

//		for (int i = 0; i < arr.length; i++) {
//			
//			System.out.println(arr[i]);
//			
//		}

	}
}

/*	String str= "Automationm";
		String Repetative= "";

		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			boolean alreadyRepeted= false;

			for (int j = 0; j < i; j++) {

				if(ch == str.charAt(j)) {

					alreadyRepeted= true;
					break;
				}

			}

			if(alreadyRepeted== true) {

				count ++;

				if(count == 3) {

					System.out.println("Second repetative char is " +ch);
				}
			}

		}
	}
}

/*	String str= "sivabsbi";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch == str.charAt(j)) {
					count ++;
				}

			}

			if(count >2) {
				System.out.println("Repetative chars in string are " + ch);
			}

		}

	}
}

/*	String str= "siva";
		String rev= "";

		for(int i= str.length()-1; i >=0; i--) {

			rev= rev +str.charAt(i);
		}

		System.out.println(rev);

	}
}

/*	String word = "Automation";

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

/*	String word= "abcba";
		String rev= "";

		for(int i= word.length()-1; i>=0; i--) {
			rev= rev+ word.charAt(i);
		}
		System.out.println(rev);
		if(word.equals(rev)) {
			System.out.println("word is palindrome");
		}
		else {
			System.out.println("word not a palindrome");
		}
	}


/*	String str= "sivabsi";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			int count= 0;

			for (int j = 0; j < str.length(); j++) {

				if(ch== str.charAt(j)) {
					count++;
				}

			}

			if (count > 1) {
				System.out.println(ch);
			}

		}

	}


/*	String str= "sivasbi";

					for (int i = 0; i < str.length(); i++) {

						char ch = str.charAt(i);
						int count=0;

						for (int j = 0; j < str.length(); j++) {

							if(ch== str.charAt(j)) {
								count++;
							}
						}

						if(count > 1) {
							System.out.println("Repetative char are " +ch);
						}

					}

				}
			}

			/*	String str= "sivasbi";

					for (int i = 0; i < str.length(); i++) {

						char ch = str.charAt(i);
						int count= 0;

						if(str.indexOf(ch) != i) {
							continue;
						}

						for (int j = 0; j < str.length(); j++) {

							if(ch== str.charAt(j)) {
								count++;
							}

						}

						if(count == 1) {
							System.out.println("Non-repetative char are " +ch);
						}

					}
				}
			}

			/*	String str= "sivasbi";

					for (int i = 0; i < str.length(); i++) {

						char ch = str.charAt(i);
						int count= 0;

						for (int j = 0; j < str.length(); j++) {

							if(ch == str.charAt(j)) {
								count++;
							}

						}
						if(count == 1) {
							System.out.println(ch);
						}

					}

				}
			}

			/*	int arr[]= {11, 12, 10, 17, 18, 20, 19, 11, 17};

					Set<Integer> set= new LinkedHashSet<Integer>();

					for (int i = 0; i < arr.length; i++) {

						set.add(arr[i]);

					}
					for(int dub: set) {
						System.out.println(dub);
					}

				}
			}

			/*	int arr[]= {11, 12, 10, 17, 18, 20, 19};

					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr.length; j++) {

							if(arr[i]>arr[j]) {
								int temp= arr[i];
								arr[i]= arr[j];
								arr[j]= temp;

							}

						}

					}

					System.out.println(arr[1]);

					//		for (int i = 0; i < arr.length; i++) {
					//			System.out.println(arr[i]);
					//		}

				}
			}

//					String str= "abcba";
//					String rev="";
			//
//					for(int i= str.length()-1; i >=0; i--) {
//						rev= rev + str.charAt(i);
//					}
//					if(rev.equals(str)) {
//						System.out.println("it is palindrom");
//					}
//					else {
//						System.out.println("not a palindrom");
//					}
			//
//				}
			//}

			/*	String str= "sivab";
					String rev= "";

					for(int i= str.length()-1; i>=0; i--) {
						rev= rev+ str.charAt(i);
					}
					System.out.println("Reverse string " +rev);
					}
				}
				/*	int a=10;
					int b=20;
					int c=30;

					a= a+b+c;   //10+20+30 a=60
					b= a-(b+c);   //60-(20+30) b=10
					c= a-(b+c);   //60-(10+30) c=20
					a= a- (b+c);  //60- (10+20)

					System.out.println("After swap a is "+ a);
					System.out.println("After swap b is "+b);
					System.out.println("After swap b is "+c);

					}
				}

//					int num= 1234;
//					int sum= 0;
			//
//					while(num >0) {
//						int rem= num%10;
//						sum= sum+rem;
//						num= num/10;
//					}
//					
//					
//					System.out.println(sum);
//				}
			//}
			/*	int temp= num;

					while(num > 0) {
						int rem= num% 10;

						rev= (rev*10)+ rem;

						num= num/10;
					}
					System.out.println("reverse of number is " +rev);

					if(temp== rev) {
						System.out.println("it is palindrom");

					}
					else {
						System.out.println("not a palindrom");
					}
				}
			}

			/*	String str= "Sbalan1895@Gmail.Com";

					int s= 0; int c= 0; int d= 0; int ch=0;

					String small= "", cap="", digit="", splC= "";

					for (int i = 0; i < str.length(); i++) {

						char charAt = str.charAt(i);

						if(Character.isLowerCase(charAt)) {
							s++;
							small += charAt;
						}

						else if(Character.isUpperCase(charAt)) {
							c++;
							cap += charAt;
						}
						else if(Character.isDigit(charAt)) {
							d++;
							digit += charAt;
						}

						else {
							ch++;
							splC += charAt;
						}

					}

					System.out.println("lowercase characters are " +small);
					System.out.println("UpperCase characters are " +cap);
					System.out.println("Digits characters are " +digit);
					System.out.println("spl characters are " +splC);

				}
			}

			/*	String str= "automation";

					char[] ch = str.toCharArray();

					for (char c : ch) {

						if(c == 'a' || c == 'e' || c == 'i' || c == 'o' ||c == 'u') {

							System.out.println(c);


						}


					}


				}
			}

			/*	String str= "sbalan1895@gmail.com";

					int length = str.length();

					System.out.println(length);


				}
			}



			// count total words in sentence

			/*String str= "learning and revision for interview";

					String[] split = str.split(" ");

					int length = split.length;

					System.out.println(length);

					}
				}

					//print no.of char in string

				/*	String str= "sbalan1895@gmail.com";

					char[] charArray = str.toCharArray();

					int strL = charArray.length;


					System.out.println("Total no.of character in string " +strL);

				}
			}

			// print repetative char from string

			/*	String str= "sivasba";

					for (int i = 0; i < str.length(); i++) {

						char ch = str.charAt(i);

						if(str.indexOf(ch)!= i) {
							continue;
						}

						int count= 0;

						for (int j = 0; j < str.length(); j++) {

							if(str.charAt(j)==ch) {
								count++;
							}

						}
						//					
						if(count > 1) {
							//						
							System.out.println("print duplicates from sivasba " +ch);
						}
					}
					//
				}
			} */


//print non-repetative char

/*	String str= "sivasa";

					String result= "";

					for (int i = 0; i < str.length(); i++) {

						char ch = str.charAt(i);

						if(result.indexOf(ch)== -1) {
							result = result + ch; 
						}
					}

					System.out.println("print non-repeative char from sivasa is " + result );

				}
			} */



//					String str= "sivasba";
//
//					String rsl= "";
//
//					for (int i = 0; i < str.length(); i++) {
//
//						char charAt = str.charAt(i);
//
//						if(rsl.indexOf(charAt)== -1) {
//
//							rsl= rsl+ charAt;
//						}
//					}
//					System.out.println("Removed duplicated from string " +rsl);
//				}
//}

//					int arr[]= {10, 20, 33, 44, 10, 55, 33};
//
//					Set <Integer> set= new LinkedHashSet<Integer>();
//
//					for (int i = 0; i < arr.length; i++) {
//						set.add(arr[i]);
//
//					}
//					System.out.println("Duplicates removed from array "+set);
//				}
//}

//					//Print the duplicates from String
//					
//					String str= "sivasa";
//					String result= "";
//
//					for (int i = 0; i < str.length(); i++) {
//
//						char charA = str.charAt(i);
//
//						if(result.indexOf(charA) == -1) {
//							result= result+charA;
//						}
//
//					}
//					System.out.println("remove duplicates from string sivasa is " +result);
//				}
//
//}

//					int arr[]= {10, 20, 33, 44, 10, 55, 33};
//
//					Set <Integer> set= new LinkedHashSet<Integer>();
//
//					for (int i = 0; i < arr.length; i++) {
//						set.add(arr[i]);
//
//					}
//					
//					System.out.println("Before duplicate removed ");
//					
//					System.out.println("Duplicate removed array ");
//					
//					for (Integer integer : set) {
//						System.out.println(integer);
//					}
//
//				}
//}
//
//					for (int i = 0; i <= 3; i++) {
//						for (int j = i+1; j <= 3; j++) {
//
//							System.out.println("Print inner j " +j);
//
//						}
//
//						System.out.println("Print first loop i " +i);
//					}
//				}
//
//}

//				public static void main(String[] args) {
//
//					int arr[]= {55, 78, 43, 84, 64, 31, 92};
//
//					int min= arr[0];
//
//					for (int i = 0; i < arr.length; i++) {
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]> arr[j]) {
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//
//						}
//					}
//					
//					System.out.println(arr[2]);
//
//				}
//}

//					int arr[]= {55, 78, 43, 84, 64, 31, 92};
//
//					int min=0;
//
//					for (int i = 0; i < arr.length; i++) {
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]<arr[j]) {
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//
//						}
//
//					}
//					
//					for (int i = 0; i < arr.length; i++) {
//						System.out.println(arr[i]);
//					}
//				}
//}

//					int num= 1234;
//					int rev=0;
//
//					while(num>0) {
//						int rmnd= num%10;
//
//						rev= (rev*10)+ rmnd;
//
//						num= num/10;
//					}
//					System.out.println("Reverse of number 1234 is " +rev);
//
//				}
//}

//					int arr[]= {55, 78, 43, 84, 64, 31, 92};
//					
//					for (int i = 0; i < arr.length; i++) {
//						for (int j = i+1; j < arr.length; j++) {
//							
//							if(arr[i]< arr[j]) {
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//							
//						}
//								
//					}
//					System.out.println(" Second Smallest number in array " +arr[1]);
//					
//					}
//				}

//					int arr[]= {55, 78, 43, 84, 64, 31, 92};
//					int min= arr[1];
//
//					for (int i =2 ; i < arr.length; i++) {
//						
//						if(min> arr[i]) {
//							min= arr[i];
//						}
//					}
//					System.out.println(min);
//				}
//}

//					int arr[]= {55, 78, 43, 84, 64, 31, 92};
//
//					for (int i = 0; i < arr.length; i++) {
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]<arr[j]) {
//
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//						}	
//					}
//					for (int i = 0; i < arr.length; i++) {
//						System.out.println(arr[i]);	
//					}
//
//				}
//}

//					int num= 1234;
//					int sum= 0;
//					int count= 0;
//
//					while(num>0) {
//
//						int rmnd= num%10;
//						sum= rmnd+sum;
////						sum= (sum*10)+rmnd;
//						num= num/10;
//						count++;
//
//					}
//
//					System.out.println("sum of digits is "+sum);
//					System.out.println("total count of digits are "+count);
//					System.out.println("reverse the number is "+ sum);
//
//				}
//}

//					int count= 0;
//
//					for (int i = 0; i < 10; i++) {
//						
//						if(i%2 != 0 ) {
//							System.out.println(i);
//							count++;
//						}
//					}
//					System.out.println("Total count of Odd numbers "+count);
//				}
//}

//
//					int arr[]= {55, 11, 44, 22, 77, 33, 10};
//
//					for (int i = 0; i < arr.length; i++) {
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]>arr[j]) {
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;					
//							}
//						}
//					}
//					
//					for (int i = 0; i < arr.length; i++) {
//						System.out.println(arr[i]);
//					}
//				}
//}

//					int arr[]= {55, 11, 44, 22, 77, 33, 10};
//					int min= arr[0];
//					
//					for (int i = 1; i < arr.length; i++) {
//					
//						if(arr[i]> min) {
//							min= arr[i];
//						}
//					}
//					System.out.println(min);
//				}
//}

//					int num= 1234;
//					int sum=0;
//					
//					while(num>0) {
//						int rmnd= num%10;
//						sum= sum+rmnd;
//						num= num/10;
//					}
//					
//					System.out.println("sum of disgits " +sum);
//					}

//				}

//					//String into int		
//					String num= "123";
//					
//					int out= Integer.parseInt(num);
//					
//					System.out.println(out);
//					
//					}
//				}

//double into int
//					double dbl= 100.78;
//					
//					int num= (int) dbl;
//					
//					System.out.println(num);
//					
//					}
//				}

//					int arr[]= {44, 77, 11, 55, 33, 10, 88};
//
//					int min= arr[0];
//
//					for (int i = 1; i < arr.length; i++) {
//
//						if(arr[i]< min) {
//							min= arr[i];
//						}
//					}
//					System.out.println(min);
//				}
//}


//					int arr[]= {88, 99, 11, 77, 55, 22};
//
//					int max= arr[0];
//
//					for (int i = 1; i < arr.length; i++) {
//
//						if(arr[i]> max) {
//							max= arr[i];
//						}
//
//					}
//					
//					System.out.println(max);
//				}
//}



//					// descending array
//					int arr[] = new int[5];
//
//					arr[0]= 234;
//					arr[1]= 123;
//					arr[2]= 345;
//					arr[3]= 108;
//					arr[4]= 534;
//
//					for (int i = 0; i < arr.length; i++) {
//
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]<arr[j]) {
//								int temp= arr[i];
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//
//						}
//
//					}
//					
//					for (int i = 0; i < arr.length; i++) {
//						System.out.println(arr[i]);
//					}
//				}
//}

//					int arr[]= new int[5];
//
//					arr[0]= 500;
//					arr[1]= 800;
//					arr[2]= 200;
//					arr[3]= 600;
//					arr[4]= 300;
//
//					for (int i = 0; i < arr.length; i++) {
//
//						for (int j = i+1; j < arr.length; j++) {
//
//							if(arr[i]>arr[j]) {
//								int temp= arr[i];					
//								arr[i]= arr[j];
//								arr[j]= temp;
//							}
//						}
//					
//					}
//					for (int i = 0; i < arr.length; i++) {
//						System.out.println(arr[i]);
//					}
//
//				}
//}

//					//Palindrome String
//					
//					String word= "abcba";
//					String rev= "";
//
//					for(int i= word.length()-1; i>=0; i--) {
//						
//						rev= rev+ word.charAt(i);
//					}
//					
//					System.out.println(rev);
//					if(word.equals(rev)) {
//						System.out.println("word is palindrome");
//					}
//					
//					else {
//						System.out.println("word not a palindrome");
//					}
//				}
//}

////					Palindrome number


//
//					int num= 12345;
//					int count=0;
//
//					while(num> 0) {
//						count++;
//						num= num/10;
//					}
//					System.out.println("total number of digits "+count);
//				}
//}

//					int num= 1234321;
//					int temp=num;
//					int plnd= 0;
//
//					while(num>0) {
//						int rmnd= num%10;
//						plnd= (plnd*10)+ rmnd;
//						num= num/10;
//					}
//					if(plnd==temp) {
//						System.out.println("is Palindrome");
//					}
//					else {
//						System.out.println("is not a palindrome");
//					}
//				}
//
//}

//					int num= 1234;
//					int rev=0;
//					
//					while (num>0) {
//						int remainder= num%10;
//						rev= (rev*10)+remainder;
//						num= num/10;
//					}
//					System.out.println(rev);
//					}
//				}

//					int num= 17;
//					int count= 0;
//
//					for(int i=2; i<= num/2; i++) {
//
//						if(num%i==0) {
//							count++;
//						}
//					}
//					if(count==0) {
//						System.out.println("Number 17 is Prime Number");
//					}
//					else {
//						System.out.println("Not a Prime Number");
//					}		
//				}
//
//}

//					int a= 10;
//					int b= 20;
//					int c= 30;
//					
//					a= a+b+c; //a= 10+20+30= 50
//					b= a-b+c; //b= 50-20+30 =10
//					c= a-b-c; //c= 50-
//					a= a-b; //a= 30-10 =20
//					
//					System.out.println("swapped a is "+a);
//					System.out.println("swapped b is "+b);
//					}
//				}

//					int num= 1234;
//					int sum=0;
//					
//					while(num>0) {
//						
//						int rmnd= num% 10;
//						sum= sum+ rmnd;
//						num= num/10;
//					}
//					
//					System.out.println(sum);
//				}
//				}

//					int num= 12321;
//					int temp= num;
//					int rev=0;
//
//					while(num>0) {
//						int remain= num%10;
//						rev= (rev*10)+remain;
//						num= num/10;
//					}
//					if(temp== rev) {
//						System.out.println("num is palindrom");
//					}
//					else {
//						System.out.println("not a palindrom");
//					}
//				}
//}

//					int num= 1234;
//					int reverse= 0;
//
//					while (num> 0) {
//						
//						int remainder= num% 10;
//						reverse= (reverse*10)+ remainder;
//						num= num/10;
//					}
//					System.out.println("reverse number "+ reverse);
//				}
//}

//					int count = 0;
//					for(int i=0; i<=25; i++) {
//						
//						if(i%2!=0) {
////							count++ ;
//							System.out.println(i);
//						}
//					}
//					System.out.println("total count of odd numbers in 25 is "+count);
//				}
//}

//					String wrd= "automation";
//					String rvs= " ";
//
//					for(int i= wrd.length()-1; i>= 0; i--) {
//
//						rvs= rvs+wrd.charAt(i);
//					}
//					
//					System.out.println("Reverse string is "+ rvs);
//				}
//	
//}

//					int a= 10;
//					int b= 20;
//					
//					a= a+b; //10+20=30
//					b= a-b; //30-20= 10
//					a= a-b; //30-10=20
//					
//					System.out.println("after swapping a value is "+a);
//					System.out.println("after swapping b value is "+b);
//				}
//}

//				public static void main(String[] args) {
//
//					String input = "Siva";
//
//					printNonRepetitiveCharacters(input);
//					
//					System.out.println("practice GIT");
//				}
//
//				public static void printNonRepetitiveCharacters(String input) {
//
//					String lowerCase = input.toLowerCase();
//
//					HashMap<Character, Integer> map = new HashMap<>();
//
//					for (char ch : lowerCase.toCharArray()) {
//						map.put(ch, map.getOrDefault(ch, 0) + 1);
//					}
//
//					LinkedHashSet<Character> charOrder = new LinkedHashSet<>();
//
//					for (char ch : lowerCase.toCharArray()) {
//						charOrder.add(ch);
//
//					}
//
//					System.out.println("Non-Repetitive Characters in " + input + ":");
//
//					boolean flag = false;
//
//					for (char ch : charOrder) {
//						if (map.get(ch) == 1) {
//							System.out.print(ch + " ");
//							flag = true;
//						}
//					}
//					if (flag != false) {
//						System.out.println("None");
//					}
//				}
//
//}

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
//					int array[]= {1,2,5,2,7,6,9};
//					Set<Integer> list= new LinkedHashSet<>();
//
//					for (int i = 0; i < array.length; i++) {
//						list.add(array[i]);
//					}
//					for (Integer integer : list) {
//						System.out.println(integer);
//
//					}
//				}
//				}

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
//					System.out.println("Before sorting: "+ Arrays.toString(number));
//
//					Arrays.sort(number);
//
//					System.out.println("After sorting: "+ Arrays.toString(number));
//				}

//					String name= "siva";
//					String rev= "";
//
//					for(int i=name.length()-1; i>=0; i--) {
//
//						rev= rev+name.charAt(i);
//					}
//					System.out.println(rev);
//				}

//					for (int i = 1; i <= 5; i++) {
//						for (int j = 1; j <=6; j++) {
//							System.out.println(i);
//						}
//				}
//				}

// swap without 3rd variable
//					int a= 10;
//					int b= 20;
//
//					a= a+b;
//					b=a-b;
//					a=a-b;
//
//					System.out.println("a is '10', after Swap a is "+a);
//					System.out.println("b is '20', after Swap b is "+b);
//				}

// swap using 3rd variable
//					int a=10;
//					int b=20;
//					int temp=0;
//
//					temp=a;
//					a=b;
//					b=temp;
//
//					System.out.println("Early 'a' is 10, after swap a= "+a);
//					System.out.println("Early 'b' is 20, after swap b= "+b);
//
//				}

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

//				int num=12320;
//				int temp= num;
//				int rev=0;
//
//				while(num!=0) {
//					int rem= num%10;
//					rev= (rev*10)+rem;
//					num= num/10;
//				}
//				if(temp==rev) {
//				System.out.println("Number 12321 is Palindrome "+ temp);
//				}
//				else {
//					System.out.println("Number 12321 is not Palindrome "+ temp);
//				}
//				}

//				public PracticeTest() {
//					System.out.println("No Argument Constructor");
//				}

//				public static void main(String[] args) {
// Scanner
//						 Scanner scan = new Scanner(System.in);
//
//						 String name = scan.next();
//						 int xprns = scan.nextInt();
//						 System.out.println("Employee Name is "+ name);
//						 System.out.println("Working exprience "+ xprns);

//					PracticeTest pt = new PracticeTest();

//					String name="Sivabalan";
//
//					System.out.print("Hello \n"+name);
//
//					int a=74;
//					int b= 36;
//					int c=110;
//
//					int sum=a+b;
//
//					if(sum==c) {
//						System.out.println("Expected and Actual sum is equal as "+sum);
//					}
//					else {
//						System.out.println("Excepted output not acheived");
//					}

//					float a=50/3f;
//
//					System.out.println("Divided result is "+a);

//					int a=125;
//					int b=24;
//
//					int sum=a+b;
//					int diff=a-b;
//					int multi=a*b;
//					int divid=a/b;
//					int remain=a%b;
//
//					System.out.println("add is "+sum );
//					System.out.println("mult is "+ multi);
//					System.out.println("subract is "+ diff);
//					System.out.println("divide is "+ divid);
//					System.out.println("divdnt is "+ remain);

//					public static int addTwoNumber(int a, int b) {
//						return a+b;
//					}
//					public static void main(String[] args) {
//						PracticeTest pt=new PracticeTest();
//						int twoNumber = pt.addTwoNumber(4, 5);
//						System.out.println(twoNumber);

//				public static void main(String[] args) {

//					for (int i = 1; i <= 10; i++) {
//						if (i%2==0) {
//							System.out.println(i);

//					int count=0;
//					for (int i = 0; i <=20; i++) {
//						if(i%2==0) {
//							count++;
//						}
//
//					}
//							System.out.println(count);
//						}

//					int a=11;
//
//					if(a%2!=0) {
//					System.out.println("a is an odd number");
//					}
//
//					else {
//					System.out.println("a is an even number");
//
//					}

//					int sum= 0;
//
//					for (int i = 1; i <=10; i++) {
//						if(i%2!=0) {
//							 sum = i;
//						}
//
//					}
//					System.out.println(sum);
//					}

//				public static void main(String[] args) {
//
//					int num=1234, rev=0;
//
//					for(; num!=0; num= num/10) {
//
//						int rem= num%10;
//
//						rev= (rev*10)+rem;
//						}
//
//					System.out.println("Reversed number is "+rev);
//					}
//

//					reverse number
//					int num= 1234, rev=0;
//
//					while(num!=0) {
//						int rem= num%10;
//
//						rev= (rev*10)+rem;
//
//						num= num/10;
//					}
//					System.out.println("Reverse number is "+rev);
//

//count even number from 1-100

//					int count=0;
//					for (int i = 0; i <=100; i++) {
//						if (i%2==0) {
//							count++;
//
//						}
//
//					}
//					System.out.println(count);

//count odd number from 1-10

//					int count=0;
//
//					for (int i = 0; i <=11; i++) {
//						if (i%2!=0) {
//
//							count++;
//
//						}
//					}
//					System.out.println(count);
//
//find even number 1-10

//					for(int i=0; i<=10; i++){
//
//						if(i%2==0) {
//							System.out.println(i);
//
//						}
//
//					}

//find odd numbers from 1-10
//					for (int i = 0; i <=10; i++) {
//
//						if (i%2!=0) {
//							System.out.println(i);
//
//						}
//
//					}

//find even number or not
//					int s=10;
//					if(s%2==1) {
//						System.out.println(s+ " is even number");
//					}
//					else {
//						System.out.println("s is not a even number");
//					}
//
//					int a[] = new int[5];
//
//					a[0]=11;
//					a[1]=22;
//					a[2]=33;
//					a[3]=44;
//					a[4]=55;
//
//
////					System.out.println(a[3]);
//
//					int len= a.length;
//
//					System.out.println(len);


//			String word="Practicing Java for Automation Testing";
//			
//			HashSet<Character> map= new HashSet<>();
//			
////			String[] split = word.split("");
//			
//			for (int i = 0; i < args.length; i++) {
//				
//			}
//		}
//		}

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

//			String name="sbalan018@";
//			char[] charArray = name.toCharArray();
//
//			int number = charArray.length;
//
//			System.out.println(number);
//
//		}
//		}

// occurrence in string
//			String sentence= "today is tuesday";
//			HashMap<Character, Integer> map= new HashMap<>();
//
//			for (int i = 0; i < sentence.length(); i++) {
//				char ch= sentence.charAt(i);
//
//				if(ch!=' ') {
//					if(map.containsKey(ch)) {
//						map.put(ch, map.get(ch)+1);
//					}
//					else {
//						map.put(ch, 1);
//					}
//				}
//			}
//			for (char key : map.keySet()) {
//
//				System.out.println(key+ "=" + map.get(key));
//			}
//
//		}
//		}

//			        int[] arr = {0, 2, 4, 6, 8, 10};
//			        int target = 10;
//			        List<Integer> current = new ArrayList<>();
//
//			        System.out.println("Subsets with sum = " + target + ":");
//			        findSubsets(arr, 0, target, current);
//			    }
//
//			    // Recursive method to find subsets
//			    public static void findSubsets(int[] arr, int index, int target, List<Integer> current) {
//			        if (target == 0) {
//			            System.out.println(current);
//			            return;
//			        }
//
//			        if (index >= arr.length || target < 0) {
//			            return;
//			        }
//
//			        // Include current element
//			        current.add(arr[index]);
//			        findSubsets(arr, index + 1, target - arr[index], current);
//
//			        // Backtrack: exclude current element
//			        current.remove(current.size() - 1);
//			        findSubsets(arr, index + 1, target, current);
//			    }
//
//
//		}
//
//			String sentence= "Welcome to java class";
//			String rev= " ";
//
//			String[] words = sentence.split(" ");
//
//			for (String word : words) {
//				String s=" ";
//
//				for (int i=word.length()-1; i>=0; i--) {
//					char ch= word.charAt(i);
//					s= s+ch;
//				}
//				rev= rev+s+" ";
//			}
//				System.out.println(rev);
//		}
//}
//			String word[]= {"A","B","A","C","D"};
//			HashMap<String, Integer> map= new HashMap<>();
//
//			for (int i = 0; i < word.length; i++) {
//				if(map.containsKey(word[i])) {
//					map.put(word[i], map.get(word[i])+1);
//				}
//				else {
//					map.put(word[i], 1);
//				}
//			}
//			System.out.println(map);
//			for (Map.Entry m:map.entrySet()) {
//				if(m.getValue().equals(1)) {
//					System.out.println(m.getKey()+" is repeated");
//				}
//
//			}
//
//		}
//}
// First repetitive character



// unique element in the array
//
//			Integer array[] = { 2, 5, 6, 2, 5, 7, 2 };				//array initialisation
//			HashMap<Integer,Integer> map = new HashMap<>();
//
//			for (int i = 0; i < array.length; i++) {
//				if (map.containsKey(array[i])) {					//check number already exists in map
//					map.put(array[i], map.get(array[i]) + 1);		// count increase for the map value
//				} else {
//					map.put(array[i], 1);							//added to map key as count 1
//				}
//			}
//
//			System.out.println(map);
//			for (Map.Entry m : map.entrySet()) {					//check each key and value in the map
//				if (m.getValue().equals(1)) {						//if map value count is 1, it print it's key
//					System.out.println("unique number is " + m.getKey());
//				}
//			}
//		}
//}

// ---------------------------------*****-----------------------------------

//reverse string
//			String name= "sivabalan";
//			String rev= "";
//
//			for(int i=name.length()-1; i>=0; i--) {
//
//				rev= rev+name.charAt(i);
//			}
//			System.out.println(rev);
//


