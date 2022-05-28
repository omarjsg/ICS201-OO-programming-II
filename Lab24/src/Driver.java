
public class Driver {

	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>();
		queue.add("X");
		queue.add("Y");
		queue.add("Z");
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());

	}

}
