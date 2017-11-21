import java.util.Stack;

public class MinStack_155 {
    private Stack<Long> stack;
    long min;
    public MinStack_155() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if (stack.isEmpty())
        {
            stack.push((long)0);
            min = x;
        }
        else
        {
            stack.push(x - min);
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        if (!stack.isEmpty())
        {
            long x = stack.pop();
            if (x < 0)
                min = min - x;
        }
    }

    public int top() {
        long x = stack.peek();
        if (x > 0)
            return (int)(min + x);
        else
            return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}


