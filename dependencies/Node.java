package dependencies;

public class Node {
    private int isiInt;
    protected Node next;
    protected Node prev;

    public Node(int isiInt, Node prev) {
        this.isiInt = isiInt;
        this.prev = prev;
    }

    public int getIsiInt() {
        return this.isiInt;
    }
}