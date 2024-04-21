import java.util.Stack;

public class QueueWithStacks<T> {

    private final Stack<T> inStack;
    private final Stack<T> outStack;

    public QueueWithStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void enqueue(T item) {

        if (inStack.isEmpty() && outStack.isEmpty()) {
            inStack.push(item);
            return;
        }

        prepareIn();
        inStack.push(item);
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    public T dequeue() {
        prepareOut();
        return outStack.pop();
    }

    public T peek() {
        prepareOut();
        return outStack.peek();
    }

    private void prepareStacks(final Stack<T> source, final Stack<T> target) {
        if (source.isEmpty()) {
            while (!target.isEmpty()) {
                source.push(target.pop());
            }
        }
    }

    private void prepareIn() {
        prepareStacks(inStack, outStack);
    }

    private void prepareOut() {
        prepareStacks(outStack, inStack);
    }

}