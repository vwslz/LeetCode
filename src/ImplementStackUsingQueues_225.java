import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues_225 () {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        temp.addAll(this.queue);
        queue = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
