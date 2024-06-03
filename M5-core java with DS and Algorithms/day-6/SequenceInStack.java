Day-6;

import java.util.Stack;

public class SequenceInStack {
	public static boolean sequencePresentOrNot(Stack<Integer> stack,int[] arr) {
		int max=-111111;
		if(stack.size()<arr.length || stack.size()==0)
			return false;
		while(!stack.isEmpty()) {
			while(stack.pop()!=arr[0]) {continue;}
			for(int i=1;i<arr.length;i++) {
				
				if(arr[i]==stack.pop()) {
					max=Math.max(max,i);
				}
				
				else {
					break;
				}
			}
			if(max==arr.length-1)
				return true;
					}
		return false;

		
		
	}
	public static void main(String[] args) {
		//Not taking user input here
		Stack<Integer> stack=new Stack<>();
		stack.push(50);
		stack.push(40);
		stack.push(30);
		stack.push(20);
		stack.push(10);
		int arr[]= {20,30,40};
		boolean b=sequencePresentOrNot(stack, arr);
		if(b) {
			System.out.println("Sequence is present");
		}else
		System.out.println("Sequence not present");
	}

}

