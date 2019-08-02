import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks_232() {
        this.stack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.push(x);
        newStack.addAll(this.stack);
        stack = newStack;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return this.stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }
}