import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {
	static sort sort = new sort();
	static long t0, t1, elapsedTime;
	public static void main(String[] args) {
		
		// take user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter array size:\n> ");
		String strAnswer = scanner.nextLine();
		int answer = Integer.parseInt(strAnswer);
		if(answer == 0) {
			int size = 2;
			while(size < 600000) {
				System.out.println("------------------------------------------------------------------------------------------------------------------------");
				sortAll(size);
				size *= 2;
			}
		} else {
			sortAll(answer);
		}
		
		
	}
	static void sortAll(int size) {
		// generate array
		System.out.println("Generating an array with length: " + size);
		int[] numbers = generateUniqueNumbers(size);
		System.out.println("Generated an array with length: " + numbers.length);
		
		
		
		// ------- SORTING -----
		// Selection Sort
		System.out.println("[ Selection Sort ] Sorting array...");
		t0 = System.currentTimeMillis();
		sort.selection(numbers);
		t1 = System.currentTimeMillis();
		elapsedTime = t1 - t0;
		System.out.println("[ Selection Sort ] Sorted array. Elapsed time: " + elapsedTime);
		
		
		// Insertion Sort
		System.out.println("[ Insertion Sort ] Sorting array...");
		t0 = System.currentTimeMillis();
		sort.insertion(numbers);
		t1 = System.currentTimeMillis();
		elapsedTime = t1 - t0;
		System.out.println("[ Insertion Sort ] Sorted array. Elapsed time: " + elapsedTime);
		
		// Bubble Sort
		System.out.println("[ Bubble Sort ] Sorting array...");
		t0 = System.currentTimeMillis();
		sort.bubble(numbers);
		t1 = System.currentTimeMillis();
		elapsedTime = t1 - t0;
		System.out.println("[ Bubble Sort ] Sorted array. Elapsed time: " + elapsedTime);
		
		
		// Exchange Sort
		System.out.println("[ Exchange Sort ] Sorting array...");
		t0 = System.currentTimeMillis();
		sort.exchange(numbers);
		t1 = System.currentTimeMillis();
		elapsedTime = t1 - t0;
		System.out.println("[ Exchange Sort ] Sorted array. Elapsed time: " + elapsedTime);
	}
	
	
	static int[] generateUniqueNumbers(int size) {
		ArrayList<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++){
		    list.add(i);
		}
		int[] shuffledArray = new int[size];
		
		// shuffle array
		int index = 0;
		do {
			shuffledArray[index] = list.remove((int)(Math.floor(Math.random() * list.size())));
			index++;
		} while(list.size() > 0);
		
		return shuffledArray;
	}
}
