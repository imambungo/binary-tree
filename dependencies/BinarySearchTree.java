package dependencies;

public class BinarySearchTree {
    public Node root;
    public int size;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void plant(int value) {
        this.root = new Node(value);
        this.size++;
    }

    public void insert(int[] toInsert) {
        for (int i : toInsert) {
            insert(i);
        }
    }

    public void insert(int newValue) {
        if (this.root == null) {
            this.root = new Node(newValue);
        } else {
            Node pointer = this.root;
            while (true) {
                if (pointer.getLeftChild() != null && newValue < pointer.getValue()) {
                    pointer = pointer.getLeftChild();
                } else if (pointer.getRightChild() != null && newValue >= pointer.getValue()) {
                    pointer = pointer.getRightChild();
                } else {
                    if (newValue < pointer.getValue()) {
                        pointer.setLeftChild(newValue);
                    } else {
                        pointer.setRightChild(newValue);
                    }
                    break;
                }
            }
        }
    }

    public boolean isOneElement() {
        // if (!isEmpty()) {
        // return this.root.getRightChild() == null && this.root.getRightChild() ==
        // null;
        // }
        // return false;
        return this.size == 1;
    }

    public boolean isSkewedLeft() {
        if (this.root == null)
            return true;
        if (this.root.getRightChild() != null)
            return false;
        if (this.root.getLeftChild() == null)
            return true;
        return this.root.getLeftChild().isSkewedLeft();
    }

    public void generateCompleteBinaryTree(int n) {
        if (this.root != null) {
            System.out.println("Sudah ada isi, bikin binary tree kosong dulu!");
        } else {
            plant(1);
            if (2 <= n) {
                this.root.setLeftChild(2);
                this.root.getLeftChild().generateCompleteBinaryTree(n);
            }
            if (3 <= n) {
                this.root.setRightChild(3);
                this.root.getRightChild().generateCompleteBinaryTree(n);
            }
        }
    }

    public int get(int index) {
        if (index < 0 || index > this.size - 1) {
            System.out.println("index out of bound!");
        } else {
            Node pointer = this.root;
            Stack path = new Stack();
            int traverseIndex = index;
            while (traverseIndex != 0) {
                if (traverseIndex % 2 == 0) {
                    path.push(1);
                    traverseIndex = traverseIndex / 2 - 1;
                } else {
                    path.push(0);
                    traverseIndex = traverseIndex / 2;
                }
            }
            while (!path.empty()) {
                if (path.pop().getIsiInt() == 1) {
                    pointer = pointer.getRightChild();
                } else {
                    pointer = pointer.getLeftChild();
                }
            }
            return pointer.getValue();
        }
        return 0;
    }

    public void push(int value) {
        if (this.size == 0) {
            plant(value);
        } else {
            Node pointer = this.root;
            Stack path = new Stack();
            int traverseIndex = this.size;
            while (traverseIndex != 0) {
                if (traverseIndex % 2 == 0) {
                    path.push(1);
                    traverseIndex = traverseIndex / 2 - 1;
                } else {
                    path.push(0);
                    traverseIndex = traverseIndex / 2;
                }
            }
            while (path.size() != 1) {
                if (path.pop().getIsiInt() == 1) {
                    pointer = pointer.getRightChild();
                } else {
                    pointer = pointer.getLeftChild();
                }
            }
            if (path.pop().getIsiInt() == 1) {
                pointer.setRightChild(value);
            } else {
                pointer.setLeftChild(value);
            }
        }
    }

    public int pop() {
        if (this.size == 0) {
            System.out.println("Binary Tree sudah kosong!");
        } else if (this.size == 1) {
            return this.root.getValue();
        } else {
            Node pointer = this.root;
            Stack path = new Stack();
            int traverseIndex = this.size - 1;
            while (traverseIndex != 0) {
                if (traverseIndex % 2 == 0) {
                    path.push(1);
                    traverseIndex = traverseIndex / 2 - 1;
                } else {
                    path.push(0);
                    traverseIndex = traverseIndex / 2;
                }
            }
            while (path.size() > 1) {
                if (path.pop().getIsiInt() == 1) {
                    pointer = pointer.getRightChild();
                } else {
                    pointer = pointer.getLeftChild();
                }
            }
            if (path.pop().getIsiInt() == 1) {
                return pointer.delRightChild().getValue();
            } else {
                return pointer.delLeftChild().getValue();
            }
        }
        return 0;
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
        this.size -= returnNode.size();
        N.leftChild = null;
        return returnNode;
    }

    public Node delRightChild(Node N) {
        Node returnNode = N.getRightChild();
        this.size -= returnNode.size();
        N.rightChild = null;
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
            size++;
        }

        public void setLeftChild(int value) {
            this.leftChild = new Node(value);
            size++;
        }

        public Node delLeftChild() {
            Node returnNode = this.leftChild;
            this.leftChild = null;
            size--;
            return returnNode;
        }

        public Node delRightChild() {
            Node returnNode = this.rightChild;
            this.rightChild = null;
            size--;
            return returnNode;
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
                return 1 + this.getRightChild().depth();
            return 0;
        }

        private int max(int a, int b) {
            if (a > b)
                return a;
            else
                return b;
        }

        public boolean isSkewedLeft() {
            if (this.getRightChild() != null)
                return false;
            if (this.getLeftChild() == null)
                return true;
            return this.getLeftChild().isSkewedLeft();
        }

        public void generateCompleteBinaryTree(int n) {
            if (this.value * 2 <= n) {
                this.setLeftChild(this.value * 2);
                this.getLeftChild().generateCompleteBinaryTree(n);
            }
            if (this.value * 2 + 1 <= n) {
                this.setRightChild(this.value * 2 + 1);
                this.getRightChild().generateCompleteBinaryTree(n);
            }
        }

        public int size() {
            int returnSize = 1;
            returnSize += this.leftChild != null ? this.leftChild.size() : 0;
            returnSize += this.rightChild != null ? this.rightChild.size() : 0;
            return returnSize;
        }
    }
}