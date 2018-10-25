class BinaryTree {
    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void plant(int value) {
        this.root = new Node(value);
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

    public int delChild(Node N) {
        int deletedChild = 0;
        if (delRightChild(N) != null)
            deletedChild++;
        if (delLeftChild(N) != null)
            deletedChild++;
        return deletedChild;
    }

    public void printPreOrder() {
        if (!isEmpty()) {
            this.root.printPre();
        }
        System.out.println();
    }

    public void printInOrder() {
        if (!isEmpty()) {
            this.root.printIn();
        }
        System.out.println();
    }

    public void printPostOrder() {
        if (!isEmpty()) {
            this.root.printPost();
        }
        System.out.println();
    }

    public void printLeaf() {
        if (!isEmpty()) {
            this.root.printLeaf();
        }
        System.out.println();
    }

    public void jumlahDaun() {
        if (isEmpty())
            System.out.println(0);
        else
            System.out.println(this.root.jumlahDaun());
    }

    public void depth() {
        if (isEmpty())
            System.out.println(0);
        else
            System.out.println(this.root.depth());
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

        public void setValue(int value) {
            this.value = value;
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

        public boolean isLeaf() {
            return this.getRightChild() == null && this.getLeftChild() == null;
        }

        public void printPre() {
            System.out.print(this.value + " ");
            if (this.getLeftChild() != null)
                this.getLeftChild().printPre();
            if (this.getRightChild() != null)// Kalo tidak pake if, bisa kena null pointer exception misal rightchild ==
                                             // null
                this.getRightChild().printPre();
        }

        public void printIn() {
            if (this.getLeftChild() != null)
                this.getLeftChild().printIn();
            System.out.print(this.value + " ");
            if (this.getRightChild() != null)
                this.getRightChild().printIn();
        }

        public void printPost() {
            if (this.getLeftChild() != null)
                this.getLeftChild().printPost();
            if (this.getRightChild() != null)
                this.getRightChild().printPost();
            System.out.print(this.value + " ");
        }

        public void printLeaf() {
            if (isLeaf())
                System.out.print(this.value + " ");
            if (this.getLeftChild() != null)
                this.getLeftChild().printLeaf();
            if (this.getRightChild() != null)
                this.getRightChild().printLeaf();
        }

        public int jumlahDaun() {
            if (this.getLeftChild() != null && this.getRightChild() != null)
                return this.getLeftChild().jumlahDaun() + this.getRightChild().jumlahDaun();
            if (this.getLeftChild() != null)
                return this.getLeftChild().jumlahDaun();
            if (this.getRightChild() != null)
                return this.getRightChild().jumlahDaun();
            return 1;
        }

        public int depth() {
            if (this.getLeftChild() != null && this.getRightChild() != null)
                return 1 + max(this.getLeftChild().depth(), this.getRightChild().depth());
            if (this.getLeftChild() != null)
                return 1 + this.getLeftChild().depth();
            if (this.getRightChild() != null)
                return 1+ this.getRightChild().depth();
            return 0;
        }

        private int max(int a, int b) {
            if (a > b)
                return a;
            else
                return b;
        }
    }
}