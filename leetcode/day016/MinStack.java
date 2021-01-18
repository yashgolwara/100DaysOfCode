package day016;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> data;
    private Stack<Integer> mins;
    
    public MinStack() {
        data = new Stack<Integer>();
        mins = new Stack<Integer>();
    }
    
    public void pop() {
        data.pop();
        mins.pop();

    }
    
    public int top() {
        return data.peek();
    }

    public int getMin() {
        return mins.peek();
    }
    
    public void push(int x) {
        data.push(x);
        if (mins.isEmpty()) {
            mins.push(x);
        }
        else {
            mins.push(Math.min(x, mins.peek()));
        }
    }
}
