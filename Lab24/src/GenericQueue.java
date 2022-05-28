import java.util.ArrayList;

public class GenericQueue<T> {
	private ArrayList<T> list = new ArrayList<>();

	// Get the size of the list.
	public int getSize() {
		return list.size();
	}

	// Add a new element.
	public void add(T object) {
		list.add(object);
	}

	// Remove and return the first element.
	public T remove() {
		if (isEmpty()) {
			return null;
		} else {
			T firstElemnt = list.get(0);
			list.remove(0);
			return firstElemnt;
		}
	}

	// Check if the list is empty.
	public boolean isEmpty() {
		return list.isEmpty();
	}
	// Print the list
	@Override
	public String toString()
	{
		return "Queue list: " + list.toString();
	}

}
