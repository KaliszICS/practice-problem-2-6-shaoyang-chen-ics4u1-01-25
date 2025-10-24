public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int[] counter(int swapCount, int stepCount, int swapWeight, int stepWeight) {
		int swapScore = swapCount * swapWeight;
		int stepScore = stepCount * stepWeight;
		int[] result = {swapScore, stepScore};
		return result;
	}

	public static int[] bubbleSort(double[] array) {
		double temp;
		boolean flag;
		int swapEvent = 0;
		int stepEvent = 0;
		for (int i = 0; i < array.length - 1; i++) {
			flag = true;
			for (int j = 0; j < array.length - i - 1; j++) {
				stepEvent++;
				if (array[j] > array[j + 1]) {
					flag = false;
					swapEvent += 3;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			if (flag) {
				i = array.length;
			}
		}
		return counter(swapEvent, stepEvent, 1 ,1);
	}

	public static int[] selectionSort(double[] arr) {
		int swapEvent = 0;
		int stepEvent = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				stepEvent++;
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
					swapEvent++;
				}
			}
				swapEvent += 3;
				double temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
		}
		return counter(swapEvent, stepEvent, 1, 1);
	}

	public static int[] insertionSort(double[] arr) {
		int swapEvent = 0;
		int stepEvent = 0;

		for (int i = 1; i < arr.length; i++) {
			double value = arr[i];
			int j = i - 1;
			swapEvent++;
			while (j >= 0 && value < arr[j]) {
				arr[j + 1] = arr[j];
				j = j - 1;
				stepEvent++;
				swapEvent++;
			}
			arr[j + 1] = value;
			swapEvent++;
		}
		return counter(swapEvent, stepEvent, 1, 1);
	}
	public static String leastSwaps(double[] givenArr) {
		return findLeast(givenArr, 0);
	}
	public static String leastIterations(double[] givenArr){
		return findLeast(givenArr, 1);
	}
	public static String findLeast(double[] array1, int function) {
		double[] bubbleArray = new double[array1.length];
		for (int i = 0; i < array1.length; i++) {
			bubbleArray[i] = array1[i];
		}
		double[] selectionArray = new double[array1.length];
		for (int i = 0; i < array1.length; i++) {
			selectionArray[i] = bubbleArray[i];
		}
		double[] insertionArray = new double[array1.length];
		for (int i = 0; i < array1.length; i++) {
			insertionArray[i] = selectionArray[i];
		}

		int[] bubbleResult = bubbleSort(bubbleArray);
		int[] selectionResult = selectionSort(selectionArray);
		int[] insertionResult = insertionSort(insertionArray);
		int bubbleValue, selectionValue, insertionValue;
		if (function == 0) {
			bubbleValue = bubbleResult[0];
			selectionValue = selectionResult[0];
			insertionValue = insertionResult[0];
		} else {
			bubbleValue = bubbleResult[1];
			selectionValue = selectionResult[1];
			insertionValue = insertionResult[1];
		}
		System.out.println(bubbleValue + " " + selectionValue + " " + insertionValue);
		return findBestAlgorithm(bubbleValue, selectionValue, insertionValue);
	}
	public static String findBestAlgorithm(int bubble, int selection, int insertion) {
		int minValue = Math.min(bubble, Math.min(selection, insertion));
		String[] algorithms = {"Bubble", "Insertion", "Selection"};
		int[] values = {bubble, insertion, selection};
		for (int i = 0; i < algorithms.length; i++) {
			if (values[i] == minValue) {
				String temp = algorithms[i];
				System.out.println(temp);
				return algorithms[i];
			}
		}
		return "-1";


//		int minValue = Math.min(bubble, Math.min(selection, insertion));
//		boolean bubbleIsMin = (bubble == minValue);
//		boolean selectionIsMin = (selection == minValue);
//		boolean insertionIsMin = (insertion == minValue);
//		if (bubbleIsMin) return "Bubble";
//		if (insertionIsMin) return "Insertion";
//		if (selectionIsMin) return "Selection";
//		return "-1";
	}

}
