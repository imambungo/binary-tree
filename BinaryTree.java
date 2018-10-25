class BinaryTree {
    public Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isOneElement() {
        if (!isEmpty()) {
            return this.root.getRightChild() == null && this.root.getLeftChild() == null;
        }
        return false;
    }

    public boolean isLeaf(Node N) {
        return N.getRightChild() == null && N.getLeftChild() == null;
    }

    public void addLeft(Node N, int value) {
        N.setLeftChild(value);
    }

    public void addRight(Node N, int value) {
        N.setRightChild(value);
    }

    public Node delLeftChild(Node N) {
        Node returnNode = N.getLeftChild();
        N.delLeftChild();
        return returnNode;
    }

    public Node delRightChild(Node N) {
        Node returnNode = N.getRightChild();
        N.delRightChild();
        return returnNode;
    }

    class Node {
        private int value;
        private Node rightChild;
        private Node leftChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setRightChild(int value) {
            this.rightChild = new Node(value);
        }

        public void setLeftChild(int value) {
            this.leftChild = new Node(value);
        }

        public void delLeftChild() {
            this.leftChild = null;
        }

        public void delRightChild() {
            this.rightChild = null;
        }
    }
}