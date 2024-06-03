Day-6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSort_withonestack {
    public static void sortQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            while (!stack.isEmpty() && stack.peek() < current) { 
                queue.offer(stack.pop());
            }
           stack.push(current);
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(289);
        queue.offer(96);
        queue.offer(64);
        queue.offer(104);
        queue.offer(44);
        queue.offer(89);

        System.out.println("Queue before sorting: " + queue);

        sortQueue(queue);

        System.out.println("Queue after sorting: " + queue);
    }
}




