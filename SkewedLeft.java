public class SkewedLeft {
    Node root;
    Node leaf;

    //

    public boolean isLeaf(Node N) {
        return N.leftChild == null;
    }

    // insert
    public void insertAsLeaf(char newValue) {
        this.leaf.leftChild = new Node(newValue, this.leaf);
        this.leaf = this.leaf.leftChild;
    }

    public void insertAsRoot(char newValue) {
        Node newNode = new Node(newValue, null);
        newNode.leftChild = this.root;
        this.root = newNode;
    }

    // del : asumsi tree tidak kosong
    public Node delLeaf() {
        Node returnNode = this.leaf;
        this.leaf = this.leaf.parent;
        this.leaf.leftChild = null;
        return returnNode;
    }

    public Node delRoot() {
        Node returnNode = this.root;
        this.root = this.root.leftChild;
        this.root.parent = null;
        return returnNode;
    }

    public void printTree() {
        Node pointer = this.root;
        while (pointer != null) {
            System.out.print(pointer.value);
            pointer = pointer.leftChild;
        }
        System.out.println();
    }

    public int depth() {
        Node pointer = this.root;
        int depthCounter = -1;
        while (pointer != null) {
            depthCounter++;
            pointer = pointer.leftChild;
        }
        return depthCounter;
    }

    class Node {
        char value;
        Node leftChild;
        Node parent;

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}