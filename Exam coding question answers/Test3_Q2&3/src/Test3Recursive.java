// ID: s201855000
public class  Test3Recursive{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 0, -1, 5, 100, 0, -2, 4000, 500, 60, -2};
		System.out.println(findMax(intArray, 0));

	}

	public static int findMax(int[] intArray, int index) {
		if (index < intArray.length) {
			return Math.max(intArray[index], findMax(intArray, index + 1));
		}
		return intArray[index-1];
	}

}
