Day-6;



import java.util.Stack;

public class Stacksort {
	  public static void sortStack(Stack<Integer> stack) {
	        Stack<Integer> temp = new Stack<>();
	        while (!stack.isEmpty()) {
	            int current = stack.pop();
	            while (!temp.isEmpty() && temp.peek() < current) { 
	                stack.push(temp.pop());
	            }
	           temp.push(current);
	        }
	        while (!temp.isEmpty()) {
	            stack.push(temp.pop());
	        }
	    }
	  public static void main(String[] args) {
	        Stack<Integer> stack=new Stack<>();
	        stack.push(227);
	        stack.push(24);
	        stack.push(27);
	        stack.push(127);
	        stack.push(7);
	        stack.push(733);

	        System.out.println("Stack before sorting: " + stack);

	        sortStack(stack);

	        System.out.println("Stack after sorting: " + stack);
	    }


}

