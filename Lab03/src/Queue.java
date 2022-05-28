public class Queue
{
	private int[] elements;
	private int size;
	public static final int DEAFULT_CAPICITY = 8;
	int i = 0;
	public Queue()
	{
		this(DEAFULT_CAPICITY);
	}
	public Queue(int capacity)
	{
		elements = new int[capacity];
	}
	public void enqueue(int v)
	{
		if (size >= elements.length)
		{
			int[] doubledArray = new int[elements.length*2];
			System.arraycopy(elements, 0, doubledArray, 0, elements.length);
			elements = doubledArray;
		}
		elements [size++] = v;
	}
	public int dequeue()
	{
		int removedElement = elements[0];
		int[] dequeued = new int[elements.length];
		System.arraycopy(elements, 1, dequeued, 0, elements.length-1);
		size--;
		elements = dequeued;
		return removedElement;
	}
	public boolean empty()
	{
		return size == 0;
	}
	public int getSize()
	{
		return size;
	}
}
