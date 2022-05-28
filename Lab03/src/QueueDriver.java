public class QueueDriver 
{
	public static void main(String[] args) 
	{
		Queue queue = new Queue();
		// TODO Auto-generated method stub
		for (int i = 1; i <=20; i++)
		{
			queue.enqueue(i); 
		}
		System.out.print("Elements from 1 to 20 = ");
		while (!queue.empty())
		{
			System.out.print(queue.dequeue()+" ");
		}
	}
}
