package com.practiceauto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionsJava {

	public static void main(String[] args) {

		ArrayList<String> li= new ArrayList<String>();

		li.add("Adam");
		li.add("Brain");
		li.add("Chegu");
		li.add("Hitler");
		li.add("Markx");

		if(li.contains("Chegu")) {
			System.out.println("Character found match");
		}
		else {
			System.out.println("Character not found");
		}

	}
}

/*	int arr[]= {21, 20, 24, 27, 25, 23, 22};
		int temp= 0;

		for(int i= 0; i< arr.length; i++){

			for (int j=0; j< arr.length; j++){

				if(arr[i] > arr[j]){
					temp= arr[i];
					arr[i]= arr[j];
					arr[j]= temp;
				}
			}	
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

/*	int arr[]= {11, 12, 11, 14,15, 12};

		Set<Integer> uniq= new HashSet<Integer>();
		Set<Integer> duplc = new HashSet<Integer>();

		for(Integer value: arr) {

			if(!uniq.add(value)) {
				duplc.add(value);
			}
		}

		System.out.println("Unique elements are " + uniq);
		System.out.println("Duplicate elements are " + duplc);

	}
}

/*	int arr[]= {11, 12, 13, 14, 15};

		int temp= 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				if(arr[i] < arr[j]) {
					temp= arr[i];
					arr[i]= arr[j];
					arr[j]= temp;
				}
			}

		}

		System.out.println("largest number from array is " + arr[0]);
	}
}

/*	ArrayList<Integer> als= new ArrayList<Integer>();

		for (int i = 0; i <= 10; i++) {

			als.add(i);
		}
		System.out.println(als);

		als.remove(3);

		System.out.println("after remove ind[3] " +als);
	}

} */
