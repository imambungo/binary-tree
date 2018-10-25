class Main {
    public static void main(String[] args) {
        BinaryTree a = new BinaryTree();
        a.plant(1);
        a.root.setLeftChild(2);
        a.root.setRightChild(3);
        a.root.getLeftChild().setLeftChild(4);
        a.root.getLeftChild().setRightChild(5);
        a.root.getRightChild().setLeftChild(6);
        a.root.getRightChild().setRightChild(7);
        a.root.getLeftChild().getLeftChild().setLeftChild(8);
        a.root.getLeftChild().getLeftChild().setRightChild(9);
        a.printPreOrder();
        a.printInOrder();
        a.printPostOrder();
        a.printLeaf();
    }
}