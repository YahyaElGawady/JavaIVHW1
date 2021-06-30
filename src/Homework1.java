import java.util.Random;
public class Homework1 {
	public static void main (String[] args) {
		Random rand = new Random();
		final int NUM_READINGS = 60;
		final int INSERTS_PER_READING = 1000;
		final double NANO_SECONDS_PER_SECOND = 1E+9;
	
		int[] array = {0};
		
		System.out.println("Array length \t Seconds per insert");
		for (int i = 0; i < NUM_READINGS; i++ ) {										
			long startTime = System.nanoTime();										
			for(int j = 0; j < INSERTS_PER_READING; j++) {														
				int index = rand.nextInt(array.length);
				int value = rand.nextInt();
				array = Homework1.insert(array, index, value);
				
			}
			long stopTime = System.nanoTime();
			double time = (double)(stopTime - startTime) / NANO_SECONDS_PER_SECOND;
			double timePerInsert = time / INSERTS_PER_READING;
			System.out.printf("%d \t\t %f\n", array.length, timePerInsert);
		}
	}
	//O
	static int[] insert(int[] array, int index, int value ) {
		int[] newArray = new int[array.length + 1];		//O(1)
		for (int i = 0; i < index; i++) {				//O(n)
			newArray[i] = array[i];						//O(1)
		}
		newArray[index] = value;						//O(1)
		for(int i = index; i < array.length; i++) {		//O(n) 
			newArray[i + 1] = array[i];					//O(1)
		}
		return newArray; 								//O(1)
	}
}
