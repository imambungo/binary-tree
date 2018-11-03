public class Stack {
    MyLinkedList a = new MyLinkedList();

    public void push(int value) {
        a.add(value);
    }

    public Node pop() {
        return a.removeLast();
    }

    public void tampilkan() {
        a.tampilkan();
    }

    public boolean empty() {
        return a.size() == 0;
    }

    public int size() {
        return a.size();
    }
}