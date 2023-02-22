public class StackDouble<T> implements IStack<T> {

    private Node<T> top;

    public StackDouble() {
        top = null;
    }

    @Override
    public int count() {
        int count = 0;
        Node<T> node = top;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(top);
        top = node;
    }

    @Override
    public T pull() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = top.getValue();
        top = top.getNext();
        return value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}

