import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class StackApp {
	
	

	public static void main(String[] args) {
		
		Stack st = new Stack();
		st.push(100);
		st.push(50);
		st.push(80);
		
		System.out.println(st);
		
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		
		
		Queue <Integer> q1 = new ArrayBlockingQueue<Integer>(2);
		q1.add(10);
		q1.add(20);
		q1.offer(30);
		q1.remove();
		q1.remove();
		q1.poll();
		q1.poll();
		
		System.out.println(q1);
	}

}
